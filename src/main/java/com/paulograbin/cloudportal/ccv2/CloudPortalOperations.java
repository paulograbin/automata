package com.paulograbin.cloudportal.ccv2;

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

import java.util.Map;

public interface CloudPortalOperations {

    <T> T sendPostRequest(String s, Object request, Class<T> responseType);

    /**
     * BUILDS
     */
    BuildDetailDTO getBuild(String code);
    BuildDetailsDTO getAllBuilds();
    BuildDetailsDTO getBuildsWithParams(Map<String, String> params);
    BuildProgressDTO getBuildProgress(String buildCode);
    CreateBuildResponseDTO createBuild(CreateBuildRequestDTO requestDTO);
    String getBuildLogs(String buildCode);

    /**
     * DEPLOYMENTS
     */
    CreateDeploymentDecisionResponseDTO createDeploymentDecision(CreateDeploymentDecisionResponseDTO responseDTO);
    CreateDeploymentResponseDTO createDeployment(CreateDeploymentRequestDTO deploymentRequestDTO);
    DeploymentDecisionsDTO getDeploymentDecisions();
    DeploymentDetailDTO getDeployment(String deployments);
    DeploymentDetailsDTO getDeployments(String deployments);
    DeploymentDetailsDTO getDeployments(String deployments, Map<String, String> params);
    DeploymentModeDTO getDeploymentModes();
    DeploymentProgressDTO getDeploymentProgress(String deploymentCode);

    /**
     * BACKUP
     */
    CreateDatabackupResponseDTO createDataBackup();
    CreateDatarestoreResponseDTO createDataRestore();
    DatabackupDetailDTO getDataBackup();
    DatabackupDetailsDTO getDataBackups();
    DatarestoreDetailDTO getDataRestore();
    DatarestoreDetailsDTO getDataRestores();


    /**
     * ENVIRONMENTS
     */
    EnvironmentsDTO fetchEnvironments();
}
