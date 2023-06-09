package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * Entity to be used to make decision on a green deployment
 */

@Schema(name = "CreateDeploymentDecisionRequestDTO", description = "Entity to be used to make decision on a green deployment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDeploymentDecisionRequestDTO {

  @JsonProperty("reason")
  private String reason;

  @JsonProperty("decision")
  private DeploymentDecision decision;

  public CreateDeploymentDecisionRequestDTO reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * reason for deployment decision
   * @return reason
  */
  
  @Schema(name = "reason", description = "reason for deployment decision", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public CreateDeploymentDecisionRequestDTO decision(DeploymentDecision decision) {
    this.decision = decision;
    return this;
  }

  /**
   * Get decision
   * @return decision
  */
  @Valid 
  @Schema(name = "decision", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public DeploymentDecision getDecision() {
    return decision;
  }

  public void setDecision(DeploymentDecision decision) {
    this.decision = decision;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDeploymentDecisionRequestDTO createDeploymentDecisionRequestDTO = (CreateDeploymentDecisionRequestDTO) o;
    return Objects.equals(this.reason, createDeploymentDecisionRequestDTO.reason) &&
        Objects.equals(this.decision, createDeploymentDecisionRequestDTO.decision);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reason, decision);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDeploymentDecisionRequestDTO {\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    decision: ").append(toIndentedString(decision)).append("\n");
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

