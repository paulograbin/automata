package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import com.paulograbin.cloudportal.EnvironmentService;
import com.paulograbin.cloudportal.ccv2.MiscService;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@Profile({"development", "production"})
@Component
public class RegularEventListener
{
	private static final Logger LOG = LoggerFactory.getLogger(RegularEventListener.class);

	private final BuildService buildService;
	private final DeploymentService deploymentService;
	private final EnvironmentService environmentService;
    private final MiscService miscService;
    private final AsyncSampleService asyncSampleService;


    public RegularEventListener(BuildService buildService,
                                DeploymentService deploymentService,
                                EnvironmentService environmentService,
                                MiscService miscService,
                                AsyncSampleService asyncSampleService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.environmentService = environmentService;
        this.miscService = miscService;
        this.asyncSampleService = asyncSampleService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws Exception {
        LOG.info("Running commandline runner...");

//        miscService.teste();
//        externo.makeSomeAsyncCalls(buildService);

        CompletableFuture<BuildDetailsDTO> last10BuildsFuture = buildService.getLast10Builds();
//
//        while (!last10BuildsFuture.isDone()) {
//        }
//        LOG.info("Done waiting...");


        last10BuildsFuture.thenAccept(builds -> {
            for (var recentBuild : builds.getValue()) {
                if (recentBuild.getStatus().equalsIgnoreCase("BUILDING") || recentBuild.getStatus().equals("UNKNOWN")) {
                    new Thread(() ->
                    {
                        LOG.info("WILL MONITOR BUILD {}", recentBuild.getCode());
                        buildService.monitorBuild(recentBuild.getCode());
                    }).start();
                }
            }
        });

        CompletableFuture<DeploymentDetailsDTO> deploymentDetailsFuture = deploymentService.fetchDeployments();
        deploymentDetailsFuture.thenAccept(deploys -> {
            for (var deployment : deploys.getValue()) {
                if (deployment.getStatus().equalsIgnoreCase("DEPLOYING")) {
                    new Thread(() ->
                    {
                        LOG.info("WILL MONITOR DEPLOYMENT {}", deployment.getCode());
                        deploymentService.monitorDeployment(deployment.getCode());
                    }).start();
                }
            }
        });

        CompletableFuture<EnvironmentsDTO> environmentsFuture = environmentService.fetchAllEnvironments();
        environmentsFuture.thenAccept(environments -> {
            for (EnvironmentDTO environment : environments.getValue()) {
                com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO deployed = deploymentService.fetchDeploymentPerEnvironment(environment.getCode());

                List<com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO> deployedDetails = deployed.getValue();

                if (deployedDetails.size() == 1) {
                    com.paulograbin.cloudportal.ccv2.dto.BuildDetailDTO buildDetails = buildService.getBuildDetails(deployedDetails.get(0).getBuildCode());

                    LOG.info("Environment {} has build {}-{}", environment.getCode(), buildDetails.getCode(), buildDetails.getName());
                }
            }
        });

		LOG.info(" ******************* ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" APP READY ");
		LOG.info(" ******************* ");
	}
}
