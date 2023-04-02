package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.CreateDeploymentRequestDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
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


    public DeploymentService(CloudPortalOperations cloudPortalOperations) {
        this.cloudPortalOperations = cloudPortalOperations;
    }

    public void makeDeployment(String buildCode) {
        CreateDeploymentRequestDTO request = new CreateDeploymentRequestDTO();
        request.setBuildCode(buildCode);
        request.setStrategy(CreateDeploymentRequestDTO.StrategyEnum.RECREATE);
        request.setDatabaseUpdateMode(CreateDeploymentRequestDTO.DatabaseUpdateModeEnum.NONE);
        request.setEnvironmentCode("d1");

        CreateDeploymentResponseDTO deployments = cloudPortalOperations.sendPostRequest("deployments", request, CreateDeploymentResponseDTO.class);

        LOG.info("Deployment created: ");
        LOG.info(" Code: {}", deployments.getCode());
    }

    @Cacheable("deployments")
    public DeploymentDetailsDTO fetchDeployments() {
        LOG.info("Fetching all recent deployments...");

        DeploymentDetailsDTO deploymentDetails = cloudPortalOperations.getDeployments("deployments");

        for (DeploymentDetailDTO buildDetailDTO : deploymentDetails.getValue()) {
            LOG.debug(" ****************** ");
            LOG.debug("Deployment details: ");
            LOG.debug(" Code {}", buildDetailDTO.getCode());
            LOG.debug(" Code {}", buildDetailDTO.getEnvironmentCode());
            LOG.debug(" Status {}", buildDetailDTO.getStatus());
            LOG.debug(" Created by {}", buildDetailDTO.getCreatedBy());
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

        for (DeploymentDetailDTO buildDetailDTO : deploymentDetails.getValue()) {
            LOG.info(" ****************** ");
            LOG.info("Deployment details: ");
            LOG.info(" Code {}", buildDetailDTO.getCode());
            LOG.info(" Code {}", buildDetailDTO.getEnvironmentCode());
            LOG.info(" Status {}", buildDetailDTO.getStatus());
            LOG.info(" Created by {}", buildDetailDTO.getCreatedBy());
        }

        return deploymentDetails;
    }
}
