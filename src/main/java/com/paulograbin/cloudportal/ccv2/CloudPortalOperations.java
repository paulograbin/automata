package com.paulograbin.cloudportal.ccv2;

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
import com.paulograbin.cloudportal.ccv2.v1dto.EnvironmentsDTO;

import java.util.Map;

public interface CloudPortalOperations {

    <T> T sendPostRequest(String s, Object request, Class<T> responseType);

    /**
     * BUILDS
     */
    BuildDetailsDTO getAllBuilds();
    BuildDetailDTO getBuild(String code);
    CreateBuildResponseDTO createBuild(CreateBuildRequestDTO requestDTO);
    String getBuildLogs(String buildCode);
    BuildProgressDTO getBuildProgress(String buildCode);

    /**
     * DEPLOYMENTS
     */
    DeploymentDetailsDTO getDeployments(String deployments);
    DeploymentDetailDTO getDeployment(String deployments);

    CreateDeploymentResponseDTO createDeployment(CreateDeploymentRequestDTO deploymentRequestDTO);
    CreateDeploymentDecisionResponseDTO createDeploymentDecision(CreateDeploymentDecisionResponseDTO responseDTO);

    DeploymentDecisionsDTO getDeploymentDecisions();
    DeploymentModeDTO getDeploymentModes();
    DeploymentProgressDTO getDeploymentProgress();

    /**
     * BACKUP
     */
    CreateDatabackupResponseDTO createDataBackup();
    CreateDatarestoreResponseDTO createDataRestore();
    DatabackupDetailDTO getDataBackup();
    DatabackupDetailsDTO getDataBackups();
    DatarestoreDetailDTO getDataRestore();
    DatarestoreDetailsDTO getDataRestores();

    EnvironmentsDTO fetchEnvironments();

    DeploymentDetailsDTO getDeployments(String deployments, Map<String, String> params);
}
