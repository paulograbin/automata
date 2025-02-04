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
    public void testOldAPI() {
        LOG.info("Misc ended...");


//        cloudPortalOperations.getPermissions();
//        cloudPortalOperations.getCurrentUser();
//        cloudPortalOperations.getCustomers();

//        cloudPortalOperations.applyConfigurationsToEnvironment("s1");

        LOG.info("Misc ended...");
    }
}
