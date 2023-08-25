package com.paulograbin.cloudportal;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;


@SpringBootApplication
@EnableCaching
@EnableAsync
public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);


    public static void main(String[] args) {
        if (args[0].equalsIgnoreCase("web")) {
            LOG.warn("Starting web mode");

            SpringApplication app = new SpringApplicationBuilder(App.class)
                    .profiles("web")
                    .build();

            Environment environment = app.run(args).getEnvironment();
            log(environment);
        } else {
            LOG.warn("Starting app in commandline mode");

            new SpringApplicationBuilder(App.class)
                    .web(WebApplicationType.NONE)
                    .profiles("commandline")
                    .headless(true)
                    .build();
        }
    }

    private static void log(Environment environment) {
        String serverPort = environment.getProperty("server.port");

        String hostAddress = "localhost";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOG.warn("The host name could not be determined, using `localhost` as fallback");
        }

        String contextPath = Optional
                .ofNullable(environment.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");


        String protocol = Optional.ofNullable(environment.getProperty("server.ssl.key-store")).map(key -> "https").orElse("http");
        String text =
                """
                        
                        ----------------------------------------------------------
                            Application '{}' is running! Access URLs:
                            Local:     {}://localhost:{}{}
                            External:  {}://{}:{}{}
                            Profile(s):    {}
                        ----------------------------------------------------------""";

        LOG.info(text,
                environment.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                environment.getActiveProfiles().length == 0 ? environment.getDefaultProfiles() : environment.getActiveProfiles()
        );
    }
}
