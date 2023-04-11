package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Deployment decision
 */

@Schema(name = "DeploymentDecisionDTO", description = "Deployment decision")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentDecisionDTO {

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("type")
  private DeploymentDecision type;

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("deploymentCode")
  private String deploymentCode;

  @JsonProperty("createdTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdTimestamp;

  @JsonProperty("createdBy")
  private String createdBy;

  public DeploymentDecisionDTO reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * reason for decision
   * @return reason
  */
  
  @Schema(name = "reason", description = "reason for decision", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public DeploymentDecisionDTO type(DeploymentDecision type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public DeploymentDecision getType() {
    return type;
  }

  public void setType(DeploymentDecision type) {
    this.type = type;
  }

  public DeploymentDecisionDTO subscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
    return this;
  }

  /**
   * subscription code
   * @return subscriptionCode
  */
  
  @Schema(name = "subscriptionCode", description = "subscription code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSubscriptionCode() {
    return subscriptionCode;
  }

  public void setSubscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
  }

  public DeploymentDecisionDTO deploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
    return this;
  }

  /**
   * deployment code
   * @return deploymentCode
  */
  
  @Schema(name = "deploymentCode", description = "deployment code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDeploymentCode() {
    return deploymentCode;
  }

  public void setDeploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
  }

  public DeploymentDecisionDTO createdTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
    return this;
  }

  /**
   * date time when decision was made
   * @return createdTimestamp
  */
  @Valid 
  @Schema(name = "createdTimestamp", description = "date time when decision was made", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getCreatedTimestamp() {
    return createdTimestamp;
  }

  public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  public DeploymentDecisionDTO createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * userId who made the decision
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "userId who made the decision", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentDecisionDTO deploymentDecisionDTO = (DeploymentDecisionDTO) o;
    return Objects.equals(this.reason, deploymentDecisionDTO.reason) &&
        Objects.equals(this.type, deploymentDecisionDTO.type) &&
        Objects.equals(this.subscriptionCode, deploymentDecisionDTO.subscriptionCode) &&
        Objects.equals(this.deploymentCode, deploymentDecisionDTO.deploymentCode) &&
        Objects.equals(this.createdTimestamp, deploymentDecisionDTO.createdTimestamp) &&
        Objects.equals(this.createdBy, deploymentDecisionDTO.createdBy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, type, subscriptionCode, deploymentCode, createdTimestamp, createdBy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentDecisionDTO {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    deploymentCode: ").append(toIndentedString(deploymentCode)).append("\n");
    sb.append("    createdTimestamp: ").append(toIndentedString(createdTimestamp)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
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

