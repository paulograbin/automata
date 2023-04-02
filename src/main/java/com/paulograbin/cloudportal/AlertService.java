package com.paulograbin.cloudportal;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlertService {


    public void sendAlert(String message) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://ntfy.sh/builds", message, String.class);
    }

}
