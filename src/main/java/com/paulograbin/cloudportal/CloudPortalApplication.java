package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CloudPortalApplication implements CommandLineRunner
{
	private BuildService buildService;
	private DeploymentService deploymentService;


	public CloudPortalApplication(BuildService buildService, DeploymentService deploymentService)
	{
		this.buildService = buildService;
		this.deploymentService = deploymentService;
	}


	public static void main(String[] args)
	{
		SpringApplication.run(CloudPortalApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
//		BuildDetailDTO buildDetails = buildService.getBuildDetails("20230323.1");
		BuildDetailsDTO allBuilds = buildService.getAllBuilds();


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
//		System.exit(0);

//		BuildDetailsDTO allBuilds1 = buildService.getAllBuilds();
//		LOG.info(allBuilds1.toString());
	}
}
