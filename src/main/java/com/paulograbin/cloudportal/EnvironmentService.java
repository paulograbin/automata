package com.paulograbin.cloudportal;

import com.paulograbin.cloudportal.ccv2.CloudPortalAPI;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class EnvironmentService {

    private final Logger LOG = LoggerFactory.getLogger(DeploymentService.class);

    private final CloudPortalAPI cloudPortalOperations;


    public EnvironmentService(CloudPortalAPI cloudPortalOperations) {
        this.cloudPortalOperations = cloudPortalOperations;
    }


    @Async
    public CompletableFuture<EnvironmentsDTO> fetchAllEnvironments() {
        LOG.info("Fetching all environments...");

        return CompletableFuture.completedFuture(cloudPortalOperations.fetchEnvironments());
    }

    @Cacheable("environments")
    public EnvironmentsDTO fetchAllEnvironmentsSync() {
        LOG.info("Fetching all environments...");

        return cloudPortalOperations.fetchEnvironments();
    }

    public EnvironmentsDTO fetchAllEnvironmentsByPassCache() {
        LOG.info("Fetching all environments...");

        return cloudPortalOperations.fetchEnvironments();
    }
}
