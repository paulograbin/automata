package com.paulograbin.cloudportal.ccv2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MiscService {

    private static final Logger LOG = LoggerFactory.getLogger(MiscService.class);


    private final OlderAPIService cloudPortalOperations;

    public MiscService(OlderAPIService cloudPortalOperations) {
        this.cloudPortalOperations = cloudPortalOperations;
    }

    @Async
    public void teste() {
        LOG.info("Foi 11111......");
        cloudPortalOperations.getPermissions();
        LOG.info("Foi 22222......");
        cloudPortalOperations.getCurrentUser();
        LOG.info("Foi 33333......");
        cloudPortalOperations.getCustomers();

        LOG.info("Terminou...");
    }
}
