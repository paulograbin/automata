package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.EnvironmentService;
import com.paulograbin.cloudportal.ccv2.MiscService;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Profile({"web"})
@Component
public class WebEventListener {
    private static final Logger LOG = LoggerFactory.getLogger(WebEventListener.class);

    private final DeploymentService deploymentService;


    public WebEventListener(BuildService buildService, DeploymentService deploymentService, EnvironmentService environmentService, MiscService miscService, AsyncSampleService asyncSampleService) {
        this.deploymentService = deploymentService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws Exception {
        LOG.info("Running web runner...");

        String environmentCode = "P1";
        DeploymentDetailsDTO deploymentDetailsDTO = deploymentService.fetchLastDeploymentPerEnvironment(environmentCode);
        List<DeploymentDetailDTO> list = deploymentDetailsDTO.getValue();

        for (DeploymentDetailDTO deploymentDetailDTO : list) {
            LOG.info("Last deployment in {}, build {} when {}", environmentCode, deploymentDetailDTO.getBuildCode(), deploymentDetailDTO.getCreatedTimestamp());
        }

        LOG.info(" ******************* ");
        LOG.info(" APP READY ");
        LOG.info(" APP READY ");
        LOG.info(" APP READY ");
        LOG.info(" APP READY ");
        LOG.info(" ******************* ");
    }
}
