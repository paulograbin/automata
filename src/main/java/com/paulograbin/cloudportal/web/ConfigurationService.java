package com.paulograbin.cloudportal.web;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ConfigurationService {

    private final Logger LOG = LoggerFactory.getLogger(ConfigurationService.class);

    private final String APP_CONFIGURATION_DIRECTORY = ".automata";
    private final String CONFIGURATION_FILE_NAME = "config.json";


    public AutomataConfiguration loadConfiguration() {
        Path path = getConfigurationPath();
        File configFile = new File(path.toString());

        AutomataConfiguration automataConfiguration = new AutomataConfiguration();

        try
        {
            if (Files.exists(path)) {
                LOG.info("Config file exist!");
            } else {
                LOG.info("Config file was not found or its empty, please check {}", path);
                FileUtils.touch(configFile);

                automataConfiguration = new AutomataConfiguration();

                String json = new Gson().toJson(automataConfiguration);

                FileUtils.writeStringToFile(configFile, json, StandardCharsets.UTF_8);

                System.exit(1);
            }

            String configFileContentAsJson = new String(Files.readAllBytes(path));
            automataConfiguration = new Gson().fromJson(configFileContentAsJson, AutomataConfiguration.class);

            validateConfiguration(automataConfiguration);

            return automataConfiguration;
        } catch (RuntimeException | IOException e) {
            System.err.println("Could not load configurations:" + e.getMessage());
            System.exit(1);
        }

        return automataConfiguration;
    }

    private void validateConfiguration(AutomataConfiguration automataConfiguration)
    {
        if (StringUtils.isBlank(automataConfiguration.getSubscriptionCode()) || StringUtils.isBlank(automataConfiguration.getAuthenticationToken())) {
            throw new RuntimeException("Empty configuration file");
        }
    }

    private Path getConfigurationPath() {
        String osName = System.getProperty("os.name");

        if (StringUtils.isBlank(osName)) {
            throw new RuntimeException("Could not load OS name");
        }

        String userHome = System.getProperty("user.home");

//        LOG.info("Running on {}", osName);
//        LOG.info("User home {}", userHome);

        return Paths.get(userHome + "/" + APP_CONFIGURATION_DIRECTORY + "/" + CONFIGURATION_FILE_NAME);
    }
}
