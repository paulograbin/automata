package com.paulograbin.cloudportal.web;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class ConfigurationService {

    private final Logger LOG = LoggerFactory.getLogger(ConfigurationService.class);

    private final String APP_CONFIGURATION_DIRECTORY = ".automata";
    private final String CONFIGURATION_FILE_NAME = "config.json";

    public Path getConfigurationPath() throws IOException {
        String osName = System.getProperty("os.name");

        if (StringUtils.isBlank(osName)) {
            throw new RuntimeException("Could not load OS name");
        }

        String userHome = System.getProperty("user.home");

        LOG.info("Running on {}", osName);
        LOG.info("User home {}", userHome);

        Path path = Paths.get(userHome + "/" + APP_CONFIGURATION_DIRECTORY + "/" + CONFIGURATION_FILE_NAME);
        File configFile = new File(path.toString());

        if (Files.exists(path)) {
            LOG.info("Config file exist!");
        } else {
            LOG.info("Config file not found...");
            FileUtils.touch(configFile);

            AutomataConfiguration automataConfiguration = new AutomataConfiguration();

            String json = new Gson().toJson(automataConfiguration);

            FileUtils.writeStringToFile(configFile, json);
        }

        LOG.info("Returning path...");
        return path;
    }
}
