package com.paulograbin.cloudportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class AlertService {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);


    public void sendAlert(String message) {
        LOG.info("Sending alert: {} at {}", message,  new SimpleDateFormat("HH:mm:ss").format(new Date()));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://ntfy.sh/builds", message, String.class);
    }

}
