package com.paulograbin.ccv2api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.ccv2api.model.DeploymentProgressStageDTO;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Deployment progress insight with several stages
 */

@Schema(name = "DeploymentProgressDTO", description = "Deployment progress insight with several stages")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentProgressDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("deploymentCode")
  private String deploymentCode;

  @JsonProperty("deploymentStatus")
  private String deploymentStatus;

  @JsonProperty("percentage")
  private Integer percentage;

  @JsonProperty("stages")
  @Valid
  private List<DeploymentProgressStageDTO> stages = null;

  public DeploymentProgressDTO subscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
    return this;
  }

  /**
   * Code of the subscription
   * @return subscriptionCode
  */
  
  @Schema(name = "subscriptionCode", description = "Code of the subscription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSubscriptionCode() {
    return subscriptionCode;
  }

  public void setSubscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
  }

  public DeploymentProgressDTO deploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
    return this;
  }

  /**
   * Code of the deployment
   * @return deploymentCode
  */
  
  @Schema(name = "deploymentCode", description = "Code of the deployment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDeploymentCode() {
    return deploymentCode;
  }

  public void setDeploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
  }

  public DeploymentProgressDTO deploymentStatus(String deploymentStatus) {
    this.deploymentStatus = deploymentStatus;
    return this;
  }

  /**
   * Status of the current deployment, possible values are \"SCHEDULED\",\"DEPLOYING\",\"DEPLOYED\",\"UNDEPLOYED\" or \"FAIL\"
   * @return deploymentStatus
  */
  
  @Schema(name = "deploymentStatus", description = "Status of the current deployment, possible values are \"SCHEDULED\",\"DEPLOYING\",\"DEPLOYED\",\"UNDEPLOYED\" or \"FAIL\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDeploymentStatus() {
    return deploymentStatus;
  }

  public void setDeploymentStatus(String deploymentStatus) {
    this.deploymentStatus = deploymentStatus;
  }

  public DeploymentProgressDTO percentage(Integer percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Completion percentage calculated by checking how many items are now running/finished/failed
   * @return percentage
  */
  
  @Schema(name = "percentage", description = "Completion percentage calculated by checking how many items are now running/finished/failed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getPercentage() {
    return percentage;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  public DeploymentProgressDTO stages(List<DeploymentProgressStageDTO> stages) {
    this.stages = stages;
    return this;
  }

  public DeploymentProgressDTO addStagesItem(DeploymentProgressStageDTO stagesItem) {
    if (this.stages == null) {
      this.stages = new ArrayList<>();
    }
    this.stages.add(stagesItem);
    return this;
  }

  /**
   * One or multiple deployment progress stages with individual steps
   * @return stages
  */
  @Valid 
  @Schema(name = "stages", description = "One or multiple deployment progress stages with individual steps", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentProgressStageDTO> getStages() {
    return stages;
  }

  public void setStages(List<DeploymentProgressStageDTO> stages) {
    this.stages = stages;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentProgressDTO deploymentProgressDTO = (DeploymentProgressDTO) o;
    return Objects.equals(this.subscriptionCode, deploymentProgressDTO.subscriptionCode) &&
        Objects.equals(this.deploymentCode, deploymentProgressDTO.deploymentCode) &&
        Objects.equals(this.deploymentStatus, deploymentProgressDTO.deploymentStatus) &&
        Objects.equals(this.percentage, deploymentProgressDTO.percentage) &&
        Objects.equals(this.stages, deploymentProgressDTO.stages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, deploymentCode, deploymentStatus, percentage, stages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentProgressDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    deploymentCode: ").append(toIndentedString(deploymentCode)).append("\n");
    sb.append("    deploymentStatus: ").append(toIndentedString(deploymentStatus)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    stages: ").append(toIndentedString(stages)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

