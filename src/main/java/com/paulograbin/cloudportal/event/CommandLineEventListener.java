package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.model.AutomataDeploymentDetailDTO;
import com.paulograbin.cloudportal.model.AutomataDeploymentDetailsDTO;
import com.paulograbin.cloudportal.web.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Profile("commandline")
@Component
public class CommandLineEventListener implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(CommandLineEventListener.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;
    private final ConfigurationService configurationService;

    public CommandLineEventListener(BuildService buildService, DeploymentService deploymentService, ConfigurationService configurationService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.configurationService = configurationService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (args[0].equalsIgnoreCase("monitor")) {
            monitorCurrentBuildsAndDeployments();
        } else {

            Path configurationPath = configurationService.getConfigurationPath();
            LOG.info("Configuration path {}", configurationPath);

            String branchName = args[0];
            String environmentCode = args[1];

            if (branchName.isEmpty() || environmentCode.isEmpty()) {
                throw new RuntimeException("Branch name and environment code cannot be empty");
            }

            LOG.info("Branch name {}", branchName);
            LOG.info("Environment code {}", environmentCode);

//		CreateBuildResponseDTO createBuildResponse = buildService.createBuild(branchName);
//		buildService.monitorBuild(createBuildResponse.getCode());
//
//		LOG.info("Send deployment request");
//		CreateDeploymentResponseDTO createDeploymentResponseDTO = deploymentService.makeDeployment(createBuildResponse.getCode(), environmentCode);
//
//		LOG.info("Will start monitoring the deployment");
//		deploymentService.monitorDeployment(createDeploymentResponseDTO.getCode());

            System.exit(0);
        }
    }

    private void monitorCurrentBuildsAndDeployments() throws ExecutionException, InterruptedException {
        CompletableFuture<AutomataDeploymentDetailsDTO> deploymentDetailsDTOCompletableFuture = deploymentService.fetchPendingDeployments();

        AutomataDeploymentDetailsDTO deploymentDetailsDTO = deploymentDetailsDTOCompletableFuture.get();

        List<AutomataDeploymentDetailDTO> value = deploymentDetailsDTO.getValue();

        for (AutomataDeploymentDetailDTO deployment : value) {
            LOG.info("Will monitor deployment {}", deployment.getCode());

            new Thread(() -> {
                deploymentService.monitorDeployment(deployment.getCode());

            }).start();
        }
    }
}
