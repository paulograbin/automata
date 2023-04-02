package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.CreateBuildResponseDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("newbuild")
public class CreateNewBuildController {

    private final Logger LOG = LoggerFactory.getLogger(BuildService.class);

    private final BuildService buildService;
    private final DeploymentService deploymentService;

    public CreateNewBuildController(BuildService buildService, DeploymentService deploymentService) {
        this.buildService = buildService;
        this.deploymentService = deploymentService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<CreateBuildResponseDTO> createAndDeployBuild(@RequestBody NewBuildRequest request) {
        LOG.info("New build request: {}", request);

        CreateBuildResponseDTO createBuildResponse = buildService.createBuild(request.getBranchName());

        return ResponseEntity.ok().body(createBuildResponse);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateBuildResponseDTO> createAndDeployBuildJson(@RequestBody NewBuildRequest request) throws InterruptedException {
        LOG.info("New build request: {}", request);

        CreateBuildResponseDTO createBuildResponse = buildService.createBuild(request.getBranchName());

        buildService.monitorBuild(createBuildResponse.getCode());

        CreateDeploymentResponseDTO createDeploymentResponseDTO = deploymentService.makeDeployment(createBuildResponse.getCode(), request.getEnvironmentCode());

        deploymentService.monitorDeployment(createDeploymentResponseDTO.getCode());

        return ResponseEntity.ok().body(createBuildResponse);
    }
}