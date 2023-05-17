package com.paulograbin.cloudportal;

import com.paulograbin.cloudportal.web.AutomataConfiguration;
import com.paulograbin.cloudportal.web.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class AlertService {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);


    private final ConfigurationService configurationService;

    public AlertService(ConfigurationService configurationService)
    {
        this.configurationService = configurationService;
    }


    public void sendAlert(String message) {
        LOG.info("Sending alert: {} at {}", message,  new SimpleDateFormat("HH:mm:ss").format(new Date()));

        AutomataConfiguration automataConfiguration = configurationService.loadConfiguration();
        String ntfyTopic = automataConfiguration.getNtfyTopic();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://ntfy.sh/" + ntfyTopic, message, String.class);
    }

}
