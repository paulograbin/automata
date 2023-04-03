package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.CreateDeploymentRequestDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentProgressDTO;
import com.paulograbin.cloudportal.ccv2.CloudPortalOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class DeploymentService {

    private final Logger LOG = LoggerFactory.getLogger(DeploymentService.class);

    private final CloudPortalOperations cloudPortalOperations;
    private final AlertService alertService;


    public DeploymentService(CloudPortalOperations cloudPortalOperations, AlertService alertService) {
        this.cloudPortalOperations = cloudPortalOperations;
        this.alertService = alertService;
    }

    public CreateDeploymentResponseDTO makeDeployment(String buildCode, String environmentCode) {
        CreateDeploymentRequestDTO request = new CreateDeploymentRequestDTO();
        request.setBuildCode(buildCode);
        request.setStrategy(CreateDeploymentRequestDTO.StrategyEnum.RECREATE);
        request.setDatabaseUpdateMode(CreateDeploymentRequestDTO.DatabaseUpdateModeEnum.NONE);
        request.setEnvironmentCode(environmentCode);

        CreateDeploymentResponseDTO deploymentResponse = cloudPortalOperations.sendPostRequest("deployments", request, CreateDeploymentResponseDTO.class);

        LOG.info("Deployment created: ");
        LOG.info(" Code: {}", deploymentResponse.getCode());

        return deploymentResponse;
    }

    @Cacheable("deployments")
    public DeploymentDetailsDTO fetchDeployments() {
        LOG.info("Fetching all recent deployments...");

        DeploymentDetailsDTO deploymentDetails = cloudPortalOperations.getDeployments("deployments");

        for (DeploymentDetailDTO deployment : deploymentDetails.getValue()) {
            LOG.info("Deployment code {}, environment {}, status {}", deployment.getCode(), deployment.getEnvironmentCode(), deployment.getStatus());
        }

        return deploymentDetails;
    }

    public DeploymentDetailsDTO fetchDeploymentPerEnvironment(String environmentCode) {
        LOG.info("Fetching deployment for environment {}", environmentCode);

        Map<String, String> params = new HashMap<>(3);
        params.put("environmentCode", "d1");
        params.put("$top", "1");
        params.put("$skip", "0");
        params.put("orderby", "scheduledTimestamp desc");

        DeploymentDetailsDTO deploymentDetails = cloudPortalOperations.getDeployments("deployments", params);

        for (DeploymentDetailDTO deployment : deploymentDetails.getValue()) {
            LOG.info("Deployment code {}, environment {}, status {}", deployment.getCode(), deployment.getEnvironmentCode(), deployment.getStatus());
        }

        return deploymentDetails;
    }

    public void monitorDeployment(String code) {
        DeploymentProgressDTO deploymentProgress = cloudPortalOperations.getDeploymentProgress(code);

        String message = "";

        LOG.info("Build {} has status {}", deploymentProgress.getDeploymentCode(), deploymentProgress.getDeploymentStatus());

        if (deploymentProgress.getDeploymentStatus().equalsIgnoreCase("DEPLOYED")) {
            message = "Deployment " + deploymentProgress.getDeploymentCode() + " ready";

            alertService.sendAlert(message);
            return;
        } else if (deploymentProgress.getDeploymentStatus().equalsIgnoreCase("FAIL")) {
            message = "Deployment " + deploymentProgress.getDeploymentCode() + " failed";

            alertService.sendAlert(message);
            return;
        } else if (deploymentProgress.getDeploymentStatus().equalsIgnoreCase("DEPLOYING")) {
            message = "Deployment " + deploymentProgress.getDeploymentCode() + " is running, at " + deploymentProgress.getPercentage() + "%";
        } else if (deploymentProgress.getDeploymentStatus().equalsIgnoreCase("SCHEDULED")) {
            message = "Deployment " + deploymentProgress.getDeploymentCode() + " not started yet";
        } else {
            message = "Deployment " + deploymentProgress.getDeploymentCode() + " new status " + deploymentProgress.getDeploymentStatus();
        }

        alertService.sendAlert(message);
        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        monitorDeployment(code);
    }
}
