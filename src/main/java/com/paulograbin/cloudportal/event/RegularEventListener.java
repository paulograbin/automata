package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.AlertService;
import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.EnvironmentService;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Profile({"development", "production"})
@Component
public class RegularEventListener
{
	private static final Logger LOG = LoggerFactory.getLogger(RegularEventListener.class);

	private final BuildService buildService;
	private final DeploymentService deploymentService;
	private final EnvironmentService environmentService;
	private final AlertService alertService;

	public RegularEventListener(BuildService buildService, DeploymentService deploymentService, EnvironmentService environmentService, AlertService alertService)
	{
		this.buildService = buildService;
		this.deploymentService = deploymentService;
		this.environmentService = environmentService;
		this.alertService = alertService;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() throws Exception
	{
		LOG.info("Running commandline runner...");

		Instant tenStart = Instant.now();
		com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO last10Builds = buildService.getLast10Builds();
		long tenDuration = Duration.between(tenStart, Instant.now()).toMillis();

		Instant allStart = Instant.now();
		buildService.fetchAllBuilds();
		long allDuration = Duration.between(allStart, Instant.now()).toMillis();

		LOG.info("10 builds took {} ms", tenDuration);
		LOG.info("All builds took {} ms", allDuration);

        for (var recentBuild : last10Builds.getValue()) {
            if (recentBuild.getStatus().equalsIgnoreCase("BUILDING")) {
                new Thread(() ->
                {
                    LOG.info("WILL MONITOR BUILD {}", recentBuild.getCode());
                    buildService.monitorBuild(recentBuild.getCode());
                }).start();
            }
        }

        DeploymentDetailsDTO lastDeployments = deploymentService.fetchDeployments();
        for (var deployment : lastDeployments.getValue()) {
            if (deployment.getStatus().equalsIgnoreCase("DEPLOYING")) {
                new Thread(() ->
                {
                    LOG.info("WILL MONITOR DEPLOYMENT {}", deployment.getCode());
                    deploymentService.monitorDeployment(deployment.getCode());
                }).start();
            }
        }

		EnvironmentsDTO environments = environmentService.fetchAllEnvironments();

		for (EnvironmentDTO environment : environments.getValue()) {
			com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO deployed = deploymentService.fetchDeploymentPerEnvironment(environment.getCode());

			List<com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO> deployedDetails = deployed.getValue();

			if (deployedDetails.size() == 1) {
				com.paulograbin.cloudportal.ccv2.dto.BuildDetailDTO buildDetails = buildService.getBuildDetails(deployedDetails.get(0).getBuildCode());

				LOG.info("Environment {} has build {}-{}", environment.getCode(), buildDetails.getCode(), buildDetails.getName());
			}
		}

		LOG.info(" ******************* ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" ******************* ");
	}
}
