package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

import java.time.Duration;
import java.time.Instant;
import java.util.List;


@SpringBootApplication
@EnableCaching
public class App implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;
    private final EnvironmentService environmentService;
    private final AlertService alertService;


    public App(BuildService buildService, DeploymentService deploymentService, EnvironmentService environmentService, AlertService alertService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.environmentService = environmentService;
        this.alertService = alertService;
    }

	public static void main(String[] args) {
		for (String arg : args) {
			LOG.info("Arg {}", arg);
		}

		if (args.length > 0) {
			LOG.info("Found args, so do not start web server");

			new SpringApplicationBuilder(App.class)
					.web(WebApplicationType.NONE)
					.run(args);

		} else {
			LOG.info("Found no args, so start web server...");
			SpringApplication.run(App.class, args);
		}
	}

    @Override
    public void run(String... args) throws Exception {
        Instant tenStart = Instant.now();
        BuildDetailsDTO last10Builds = buildService.getLast10Builds();
        long tenDuration = Duration.between(tenStart, Instant.now()).toMillis();

        Instant allStart = Instant.now();
        buildService.fetchAllBuilds();
        long allDuration = Duration.between(allStart, Instant.now()).toMillis();

        LOG.info("10 builds took {} ms", tenDuration);
        LOG.info("All builds took {} ms", allDuration);


        for (var recentBuild : last10Builds.getValue())
        {
            if (recentBuild.getStatus().equalsIgnoreCase("BUILDING") )
            {
				new Thread(() ->
				{
					LOG.info("WILL MONITOR BUILD {}", recentBuild.getCode());
					buildService.monitorBuild(recentBuild.getCode());
				}).start();
            }
        }

		DeploymentDetailsDTO lastDeployments = deploymentService.fetchDeployments();
		for (var deployment : lastDeployments.getValue())
		{
			if (deployment.getStatus().equalsIgnoreCase("DEPLOYING"))
			{
				new Thread(() ->
				{
					LOG.info("WILL MONITOR DEPLOYMENT {}", deployment.getCode());
					deploymentService.monitorDeployment(deployment.getCode());
				}).start();
			}
		}

		EnvironmentsDTO environments = environmentService.fetchAllEnvironments();

        for (EnvironmentDTO environment : environments.getValue()) {
            DeploymentDetailsDTO deployed = deploymentService.fetchDeploymentPerEnvironment(environment.getCode());

            List<DeploymentDetailDTO> deployedDetails = deployed.getValue();

            if (deployedDetails.size() == 1) {
                BuildDetailDTO buildDetails = buildService.getBuildDetails(deployedDetails.get(0).getBuildCode());

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
