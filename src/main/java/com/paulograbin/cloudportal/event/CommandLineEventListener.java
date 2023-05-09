package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("commandline")
@Component
public class CommandLineEventListener implements CommandLineRunner
{
	private static final Logger LOG = LoggerFactory.getLogger(CommandLineEventListener.class);

	private final BuildService buildService;
	private final DeploymentService deploymentService;

	public CommandLineEventListener(BuildService buildService, DeploymentService deploymentService) {
		this.buildService = buildService;
		this.deploymentService = deploymentService;
	}

	@Override
	public void run(String... args) throws Exception {
        String branchName = args[0];
        String environmentCode = args[1];

        if (branchName.isEmpty() || environmentCode.isEmpty()) {
            throw new RuntimeException("Branch name and environment code cannot be empty");
        }

        LOG.info("Branch name {}", branchName);
        LOG.info("Environment code {}", environmentCode);

		CreateBuildResponseDTO createBuildResponse = buildService.createBuild(branchName);
		buildService.monitorBuild(createBuildResponse.getCode());

		LOG.info("Send deployment request");
		CreateDeploymentResponseDTO createDeploymentResponseDTO = deploymentService.makeDeployment(createBuildResponse.getCode(), environmentCode);

		LOG.info("Will start monitoring the deployment");
		deploymentService.monitorDeployment(createDeploymentResponseDTO.getCode());

        System.exit(0);
	}
}
