package com.paulograbin.cloudportal;

import com.paulograbin.cloudportal.build.BuildNameCreator;
import com.paulograbin.cloudportal.ccv2.CloudPortalAPI;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.BuildProgressDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildRequestDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@Service
public class BuildService {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final CloudPortalAPI cloudPortalAPI;
    private final AlertService alertService;

    private final BuildNameCreator buildNameCreator;

    public BuildService(CloudPortalAPI cloudPortalAPI, AlertService alertService) {
        this.cloudPortalAPI = cloudPortalAPI;
        this.alertService = alertService;

        this.buildNameCreator = new BuildNameCreator();
    }

    @Async
    public CompletableFuture<BuildDetailsDTO> getLast10Builds() {
        LOG.info("Fetching last 10 builds...");

        Map<String, String> params = new HashMap<>(3);
        params.put("$top", "10");
        params.put("$skip", "0");
        params.put("orderby", "scheduledTimestamp desc");

        BuildDetailsDTO buildDetailsDTO = cloudPortalAPI.getBuildsWithParams(params);

        for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue()) {
            logBuildDetails(buildDetailDTO);
        }

        return CompletableFuture.completedFuture(buildDetailsDTO);
    }

    @Cacheable("builds")
    public BuildDetailsDTO getLast10BuildsSync() {
        LOG.info("Fetching last 10 builds...");

        Map<String, String> params = new HashMap<>(3);
        params.put("$top", "10");
        params.put("$skip", "0");
        params.put("orderby", "scheduledTimestamp desc");

        BuildDetailsDTO buildDetailsDTO = cloudPortalAPI.getBuildsWithParams(params);

        for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue()) {
            logBuildDetails(buildDetailDTO);
        }

        return buildDetailsDTO;
    }

    @Async
    public CompletableFuture<BuildDetailsDTO> fetchAllBuilds() {
        LOG.info("Fetching all recent builds...");

        BuildDetailsDTO buildDetailsDTO = cloudPortalAPI.getAllBuilds();

        for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue()) {
            logBuildDetails(buildDetailDTO);
        }

        return CompletableFuture.completedFuture(buildDetailsDTO);
    }

    public BuildDetailDTO getBuildDetails(String buildCode) {
        LOG.info("Fetching build details...");

        BuildDetailDTO build = cloudPortalAPI.getBuild("builds/" + buildCode);
        logBuildDetails(build);

        return build;
    }

    private void logBuildDetails(BuildDetailDTO build) {
        LOG.debug("Build details: Code {}, Branch {}, Status {}, Created by {}", build.getCode(), build.getBranch(), build.getStatus(), build.getCreatedBy());
    }

    public void createBuildAndAlertWhenDone(String branch) throws InterruptedException {
        String formattedDate = new SimpleDateFormat("dd-MM-yy HH-mm").format(new Date());

        String buildName = buildNameCreator.makeBuildNameFromBranch(branch);
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO createBuildResponse = cloudPortalAPI.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to create {} ", createBuildResponse.getCode());

//		CreateBuildResponseDTO createBuildResponse = new CreateBuildResponseDTO();
//		createBuildResponse.setCode("20230329.3");

        Thread.sleep(5000L);

        monitorBuild(createBuildResponse.getCode());
    }

    public void monitorBuild(String buildCode) {
        BuildProgressDTO buildProgress = cloudPortalAPI.getBuildProgress(buildCode);

        String message = "";

        LOG.info("Build {} has status {}", buildProgress.getBuildCode(), buildProgress.getBuildStatus());

        if (buildProgress.getBuildStatus().equalsIgnoreCase("SUCCESS")) {
            message = "Build " + buildProgress.getBuildCode() + " ready";

            alertService.sendAlert(message);
            return;
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("FAILED")) {
            message = "Build " + buildProgress.getBuildCode() + " failed";

            alertService.sendAlert(message);
            return;
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("BUILDING")) {
            message = "Build " + buildProgress.getBuildCode() + " is building, at " + buildProgress.getPercentage() + "%";
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("UNKNOWN")) {
            message = "Build " + buildProgress.getBuildCode() + " not started yet";
        } else {
            message = "Build " + buildProgress.getBuildCode() + " new status " + buildProgress.getBuildStatus();
        }

        alertService.sendAlert(message);
        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        monitorBuild(buildCode);
    }

    public CreateBuildResponseDTO createBuild(String branch) {
        String buildName = buildNameCreator.makeBuildNameFromBranch(branch);
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO response = cloudPortalAPI.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to be created {}", response.getCode());

        return response;
    }
}
