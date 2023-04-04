package com.paulograbin.cloudportal;

import com.paulograbin.cloudportal.ccv2.CloudPortalOperations;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class EnvironmentService {

    private final Logger LOG = LoggerFactory.getLogger(DeploymentService.class);

    private final CloudPortalOperations cloudPortalOperations;


    public EnvironmentService(CloudPortalOperations cloudPortalOperations) {
        this.cloudPortalOperations = cloudPortalOperations;
    }


    @Cacheable("environments")
    public EnvironmentsDTO fetchAllEnvironments() {
        LOG.info("Fetching all environments...");

        return cloudPortalOperations.fetchEnvironments();
    }

    public EnvironmentsDTO fetchAllEnvironmentsByPassCache() {
        LOG.info("Fetching all environments...");

        return cloudPortalOperations.fetchEnvironments();
    }
}
