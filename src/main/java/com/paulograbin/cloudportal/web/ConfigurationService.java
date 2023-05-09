package com.paulograbin.cloudportal.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ConfigurationService
{

	private final Logger LOG = LoggerFactory.getLogger(ConfigurationService.class);


	public Path getConfigurationPath() {
		String osName = System.getProperty("os.name");

		if (StringUtils.isBlank(osName)) {
			throw new RuntimeException("Could not load OS name");
		}

		String userHome = System.getProperty("user.home");

		LOG.info("Running on {}", osName);
		LOG.info("User home {}", userHome);



		return Paths.get("/");
	}

}
