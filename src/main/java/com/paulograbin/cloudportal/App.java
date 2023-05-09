package com.paulograbin.cloudportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StringUtils;


@SpringBootApplication
@EnableCaching
@EnableAsync
public class App {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);


	public static void main(String[] args) {
		if (args[0].equalsIgnoreCase("web")) {
			LOG.warn("Starting web mode");

			new SpringApplicationBuilder(App.class)
					.profiles("web")
					.run(args);
		}

        LOG.warn("Starting app in commandline mode");

        new SpringApplicationBuilder(App.class)
                .web(WebApplicationType.NONE)
                .profiles("commandline")
                .headless(true)
                .run(args);
    }
}
