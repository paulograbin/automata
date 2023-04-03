package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import com.paulograbin.ccv2api.model.BuildProgressDTO;
import com.paulograbin.ccv2api.model.CreateBuildRequestDTO;
import com.paulograbin.ccv2api.model.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.CloudPortalOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class BuildService {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final CloudPortalOperations cloudPortalOperations;
    private final AlertService alertService;

    public BuildService(CloudPortalOperations cloudPortalOperations, AlertService alertService) {
        this.cloudPortalOperations = cloudPortalOperations;
        this.alertService = alertService;
    }

    @Cacheable("builds")
    public BuildDetailsDTO getLast10Builds() {
        LOG.info("Fetching last 10 builds...");

        Map<String, String> params = new HashMap<>(3);
        params.put("$top", "10");
        params.put("$skip", "0");
        params.put("orderby", "scheduledTimestamp desc");

        BuildDetailsDTO buildDetailsDTO = cloudPortalOperations.getBuildsWithParams(params);

        for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue()) {
            logBuildDetails(buildDetailDTO);
        }

        return buildDetailsDTO;
    }

    public BuildDetailsDTO fetchAllBuilds() {
        LOG.info("Fetching all recent builds...");

        BuildDetailsDTO buildDetailsDTO = cloudPortalOperations.getAllBuilds();

        for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue()) {
            logBuildDetails(buildDetailDTO);
        }

        return buildDetailsDTO;
    }

    public BuildDetailDTO getBuildDetails(String buildCode) {
        LOG.info("Fetching build details...");

        BuildDetailDTO buildDetailDTO = cloudPortalOperations.getBuild("builds/" + buildCode);
        LOG.info("Build details ");
        LOG.info(" Code {}", buildDetailDTO.getCode());
        LOG.info(" Branch {}", buildDetailDTO.getBranch());
        LOG.info(" Status {}", buildDetailDTO.getStatus());
        LOG.info(" Start time {}", buildDetailDTO.getBuildStartTimestamp());
        LOG.info(" End time {}", buildDetailDTO.getBuildEndTimestamp());
        LOG.info(" Created by {}", buildDetailDTO.getCreatedBy());

        return buildDetailDTO;
    }

    private void logBuildDetails(BuildDetailDTO buildDetailDTO) {
        LOG.debug("Build details ");
        LOG.debug(" Code {}", buildDetailDTO.getCode());
        LOG.debug(" Branch {}", buildDetailDTO.getBranch());
        LOG.debug(" Status {}", buildDetailDTO.getStatus());
        LOG.debug(" Start time {}", buildDetailDTO.getBuildStartTimestamp());
        LOG.debug(" End time {}", buildDetailDTO.getBuildEndTimestamp());
        LOG.debug(" Created by {}", buildDetailDTO.getCreatedBy());
    }

    public void createBuildAndAlertWhenDone(String branch) throws InterruptedException {
        String formattedDate = new SimpleDateFormat("dd-MM-yy HH-mm").format(new Date());

        String buildName = branch + " " + formattedDate;
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO createBuildResponse = cloudPortalOperations.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to create {} ", createBuildResponse.getCode());

//		CreateBuildResponseDTO createBuildResponse = new CreateBuildResponseDTO();
//		createBuildResponse.setCode("20230329.3");

        Thread.sleep(5000L);

        monitorBuild(createBuildResponse.getCode());
    }

    public void monitorBuild(String buildCode) {
        BuildProgressDTO buildProgress = cloudPortalOperations.getBuildProgress(buildCode);

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm");
        String formattedDate = dateFormat.format(new Date());

        String buildName = branch + " " + formattedDate;
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO response = cloudPortalOperations.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to be created {}", response.getCode());

        return response;
    }
}
