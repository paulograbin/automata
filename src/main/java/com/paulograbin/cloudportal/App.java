package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;


@SpringBootApplication
@EnableCaching
public class App implements CommandLineRunner {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;
    private final EnvironmentService environmentService;


    public App(BuildService buildService, DeploymentService deploymentService, EnvironmentService environmentService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
        this.environmentService = environmentService;
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        EnvironmentsDTO environmentsDTO = environmentService.fetchAllEnvironments();

        for (EnvironmentDTO environment : environmentsDTO.getEnvironments()) {
            DeploymentDetailsDTO deploymentDetailsDTO = deploymentService.fetchDeploymentPerEnvironment(environment.getCode());

            List<DeploymentDetailDTO> value = deploymentDetailsDTO.getValue();

            if (value.size() == 1) {
                BuildDetailDTO buildDetails = buildService.getBuildDetails(value.get(0).getBuildCode());

                LOG.info("Environment {} has build {}-{}", environment.getCode(), buildDetails.getCode(), buildDetails.getName());
            }

        }

//        BuildDetailDTO buildDetails = buildService.getBuildDetails("20230323.1");
//        BuildDetailsDTO allBuilds = buildService.getAllBuilds();
//        BuildDetailDTO buildDetails = buildService.getBuildDetails("20230323.1");


//        DeploymentDetailsDTO deploymentDetailsDTO = deploymentService.fetchDeployments();
//        LOG.info("Found {} deployments", deploymentDetailsDTO.getCount());

        //		develop 28-03-23 09-49
        //		20230328.3
//		buildService.createBuild("develop");

//		buildService.createBuildAndAlertWhenDone("develop");

//		deploymentService.makeDeployment("20230329.4");
//
//		System.exit(0);


//		globale_experiment 28-03-23 09-49
//		20230328.4


//		buildService.createBuild("globale_experiment");


//
//		BuildDetailsDTO allBuilds1 = buildService.getAllBuilds();
//		LOG.info(allBuilds1.toString());
    }
}
