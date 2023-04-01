package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import com.paulograbin.ccv2api.model.BuildProgressDTO;
import com.paulograbin.ccv2api.model.CreateBuildRequestDTO;
import com.paulograbin.ccv2api.model.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.CloudPortalOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class BuildService {
    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final CloudPortalOperations cloudPortalOperations;

    public BuildService(CloudPortalOperations cloudPortalOperations) {
        this.cloudPortalOperations = cloudPortalOperations;
    }


    public BuildDetailsDTO getAllBuilds() {
        LOG.info("Fetching all recent builds...");

        BuildDetailsDTO buildDetailsDTO = cloudPortalOperations.getAllBuilds();

//		for (BuildDetailDTO buildDetailDTO : buildDetailsDTO.getValue())
//		{
//			LOG.info(" ****************** ");
//			LOG.info("Build details: ");
//			LOG.info(" Code {}", buildDetailDTO.getCode());
//			LOG.info(" Branch {}", buildDetailDTO.getBranch());
//			LOG.info(" Status {}", buildDetailDTO.getStatus());
//			LOG.info(" Start time {}", buildDetailDTO.getBuildStartTimestamp());
//			LOG.info(" End time {}", buildDetailDTO.getBuildEndTimestamp());
//			LOG.info(" Created by {}", buildDetailDTO.getCreatedBy());
//		}

        return buildDetailsDTO;
    }

    public BuildDetailDTO getBuildDetails(String buildCode) {
        LOG.info("Fetching build codes...");

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


    public void createBuildAndAlertWhenDone(String branch) throws InterruptedException {
        String formattedDate = new SimpleDateFormat("dd-MM-yy HH-mm").format(new Date());

        String buildName = branch + " " + formattedDate;
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO createBuildResponse = cloudPortalOperations.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to be created ");
        LOG.info(" Code {}", createBuildResponse.getCode());

//		CreateBuildResponseDTO createBuildResponse = new CreateBuildResponseDTO();
//		createBuildResponse.setCode("20230329.3");

        Thread.sleep(5000L);

        monitorBuild(createBuildResponse);
    }

    private void monitorBuild(CreateBuildResponseDTO createBuildResponse) throws InterruptedException {
        BuildProgressDTO buildProgress = cloudPortalOperations.getBuildProgress(createBuildResponse.getCode());

        String message = "";

        LOG.info("Build {} has status {}", buildProgress.getBuildCode(), buildProgress.getBuildStatus());

        if (buildProgress.getBuildStatus().equalsIgnoreCase("SUCCESS")) {
            message = buildProgress.getBuildCode() + " ready";
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("FAILED")) {
            message = buildProgress.getBuildCode() + " failed";
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("BUILDING")) {
            message = buildProgress.getBuildCode() + " is building, at " + buildProgress.getPercentage() + "%";
        } else if (buildProgress.getBuildStatus().equalsIgnoreCase("UNKNOWN")) {
            message = buildProgress.getBuildCode() + " building not started yet";
        } else {
            message = buildProgress.getBuildCode() + " new status " + buildProgress.getBuildStatus();
        }

        LOG.info("Sending alert message: {} at {}", message, new SimpleDateFormat("HH:mm:ss").format(new Date()));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject("http://ntfy.sh/builds", message, String.class);

        Thread.sleep(5 * 60 * 1000);

        monitorBuild(createBuildResponse);
    }

    public void createBuild(String branch) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm");
        String formattedDate = dateFormat.format(new Date());

        String buildName = branch + " " + formattedDate;
        LOG.info("Build will have name {}", buildName);

        CreateBuildRequestDTO request = new CreateBuildRequestDTO()
                .name(buildName)
                .branch(branch);

        CreateBuildResponseDTO response = cloudPortalOperations.sendPostRequest("builds", request, CreateBuildResponseDTO.class);

        LOG.info("Build to be created ");
        LOG.info(" Code {}", response.getCode());
    }

}
