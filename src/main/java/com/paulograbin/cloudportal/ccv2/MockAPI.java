package com.paulograbin.cloudportal.ccv2;

import com.google.gson.Gson;
import com.paulograbin.ccv2api.model.BuildDetailDTO;
import com.paulograbin.ccv2api.model.BuildDetailsDTO;
import com.paulograbin.ccv2api.model.BuildProgressDTO;
import com.paulograbin.ccv2api.model.CreateBuildRequestDTO;
import com.paulograbin.ccv2api.model.CreateBuildResponseDTO;
import com.paulograbin.ccv2api.model.CreateDatabackupResponseDTO;
import com.paulograbin.ccv2api.model.CreateDatarestoreResponseDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentDecisionResponseDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentRequestDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import com.paulograbin.ccv2api.model.DatabackupDetailDTO;
import com.paulograbin.ccv2api.model.DatabackupDetailsDTO;
import com.paulograbin.ccv2api.model.DatarestoreDetailDTO;
import com.paulograbin.ccv2api.model.DatarestoreDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentDecisionsDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import com.paulograbin.ccv2api.model.DeploymentModeDTO;
import com.paulograbin.ccv2api.model.DeploymentProgressDTO;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Service
//@Profile("development")
@Profile("production")
public class MockAPI implements CloudPortalOperations {

    private final ResourceLoader resourceLoader;
    private final Gson gson;

    public MockAPI(ResourceLoader resourceLoader, Gson gson) {
        this.resourceLoader = resourceLoader;
        this.gson = gson;
    }

//    @Override
//    public <T> T sendRequest(String urlPath, Class<T> returnType) {
//        return null;
//    }

    @Override
    public <T> T sendPostRequest(String s, Object request, Class<T> responseType) {
        return null;
    }

    @Override
    public BuildProgressDTO getBuildProgress(String buildCode) {
        return null;
    }

    @Override
    public BuildDetailsDTO getAllBuilds() {
        String contentAsString = loadResourceByName("returns/builds/allBuilds.json");

        return gson.fromJson(contentAsString, BuildDetailsDTO.class);
    }

    private String loadResourceByName(String resourcePath) {
        org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:" + resourcePath);

        String contentAsString = null;
        try {
            contentAsString = resource.getContentAsString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contentAsString;
    }

    @Override
    public BuildDetailDTO getBuild(String code) {
        String contentAsString = loadResourceByName("returns/builds/build.json");

        return gson.fromJson(contentAsString, BuildDetailDTO.class);
    }

    @Override
    public CreateBuildResponseDTO createBuild(CreateBuildRequestDTO requestDTO) {
        return null;
    }

    @Override
    public String getBuildLogs(String buildCode) {
        return null;
    }

    @Override
    public DeploymentDetailsDTO getDeployments(String deployments) {
        return null;
    }

    @Override
    public DeploymentDetailDTO getDeployment(String deployments) {
        return null;
    }

    @Override
    public CreateDeploymentResponseDTO createDeployment(CreateDeploymentRequestDTO deploymentRequestDTO) {
        return null;
    }

    @Override
    public CreateDeploymentDecisionResponseDTO createDeploymentDecision(CreateDeploymentDecisionResponseDTO responseDTO) {
        return null;
    }

    @Override
    public DeploymentDecisionsDTO getDeploymentDecisions() {
        return null;
    }

    @Override
    public DeploymentModeDTO getDeploymentModes() {
        return null;
    }

    @Override
    public DeploymentProgressDTO getDeploymentProgress() {
        return null;
    }

    @Override
    public CreateDatabackupResponseDTO createDataBackup() {
        return null;
    }

    @Override
    public CreateDatarestoreResponseDTO createDataRestore() {
        return null;
    }

    @Override
    public DatabackupDetailDTO getDataBackup() {
        return null;
    }

    @Override
    public DatabackupDetailsDTO getDataBackups() {
        return null;
    }

    @Override
    public DatarestoreDetailDTO getDataRestore() {
        return null;
    }

    @Override
    public DatarestoreDetailsDTO getDataRestores() {
        return null;
    }
}
