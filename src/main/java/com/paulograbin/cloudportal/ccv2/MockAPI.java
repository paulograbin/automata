package com.paulograbin.cloudportal.ccv2;

import com.google.gson.Gson;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.BuildDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.BuildProgressDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildRequestDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateBuildResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDatabackupResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDatarestoreResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentDecisionResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentRequestDTO;
import com.paulograbin.cloudportal.ccv2.dto.CreateDeploymentResponseDTO;
import com.paulograbin.cloudportal.ccv2.dto.DatabackupDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DatabackupDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DatarestoreDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DatarestoreDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDecisionsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailsDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentModeDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentProgressDTO;
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


//@Profile("development")
public class MockAPI {

    private final ResourceLoader resourceLoader;
    private final Gson gson;

    public MockAPI(ResourceLoader resourceLoader, Gson gson) {
        this.resourceLoader = resourceLoader;
        this.gson = gson;
    }

    public <T> T sendPostRequest(String s, Object request, Class<T> responseType) {
        return null;
    }

    public BuildProgressDTO getBuildProgress(String buildCode) {
        return null;
    }

    private String loadResourceByName(String resourcePath) {
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + resourcePath);

        String contentAsString;
        try {
            contentAsString = resource.getContentAsString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contentAsString;
    }

    public BuildDetailDTO getBuild(String code) {
        String contentAsString = loadResourceByName("returns/builds/build.json");

        return gson.fromJson(contentAsString, BuildDetailDTO.class);
    }

    public BuildDetailsDTO getAllBuilds()
    {
        String contentAsString = loadResourceByName("returns/builds/allBuilds.json");

        return gson.fromJson(contentAsString, BuildDetailsDTO.class);
    }

    public CreateBuildResponseDTO createBuild(CreateBuildRequestDTO requestDTO) {
        return null;
    }

    public String getBuildLogs(String buildCode) {
        return null;
    }

    public DeploymentDetailsDTO getDeployments(String deployments) {
        return null;
    }

    public DeploymentDetailDTO getDeployment(String deployments) {
        return null;
    }

    public CreateDeploymentResponseDTO createDeployment(CreateDeploymentRequestDTO deploymentRequestDTO) {
        return null;
    }

    public CreateDeploymentDecisionResponseDTO createDeploymentDecision(CreateDeploymentDecisionResponseDTO responseDTO) {
        return null;
    }

    public DeploymentDecisionsDTO getDeploymentDecisions() {
        return null;
    }

    public DeploymentModeDTO getDeploymentModes() {
        return null;
    }

    public DeploymentProgressDTO getDeploymentProgress(String deploymentCode) {
        return null;
    }

    public CreateDatabackupResponseDTO createDataBackup() {
        return null;
    }

    public CreateDatarestoreResponseDTO createDataRestore() {
        return null;
    }

    public DatabackupDetailDTO getDataBackup() {
        return null;
    }

    public DatabackupDetailsDTO getDataBackups() {
        return null;
    }

    public DatarestoreDetailDTO getDataRestore() {
        return null;
    }

    public DatarestoreDetailsDTO getDataRestores() {
        return null;
    }

    public EnvironmentsDTO fetchEnvironments() {

        return null;
    }

    public DeploymentDetailsDTO getDeployments(String deployments, Map<String, String> params) {
        return null;
    }

    public BuildDetailsDTO getBuildsWithParams(Map<String, String> params) {
        return null;
    }
}
