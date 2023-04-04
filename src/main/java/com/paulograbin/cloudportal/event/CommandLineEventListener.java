package com.paulograbin.cloudportal.event;

import com.paulograbin.cloudportal.BuildService;
import com.paulograbin.cloudportal.DeploymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Profile("commandline")
@Component
public class CommandLineEventListener
{
	private static final Logger LOG = LoggerFactory.getLogger(CommandLineEventListener.class);

	private final BuildService buildService;
	private final DeploymentService deploymentService;

	public CommandLineEventListener(BuildService buildService, DeploymentService deploymentService)
	{
		this.buildService = buildService;
		this.deploymentService = deploymentService;
	}


	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		LOG.info("Running app ready event listener...");

		buildService.monitorBuild("20230404.1");
	}
}
