package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Deployment decisions
 */

@Schema(name = "DeploymentDecisionsDTO", description = "Deployment decisions")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentDecisionsDTO {

  @JsonProperty("deploymentDecisions")
  @Valid
  private List<DeploymentDecisionDTO> deploymentDecisions = null;

  public DeploymentDecisionsDTO deploymentDecisions(List<DeploymentDecisionDTO> deploymentDecisions) {
    this.deploymentDecisions = deploymentDecisions;
    return this;
  }

  public DeploymentDecisionsDTO addDeploymentDecisionsItem(DeploymentDecisionDTO deploymentDecisionsItem) {
    if (this.deploymentDecisions == null) {
      this.deploymentDecisions = new ArrayList<>();
    }
    this.deploymentDecisions.add(deploymentDecisionsItem);
    return this;
  }

  /**
   * Get deploymentDecisions
   * @return deploymentDecisions
  */
  @Valid 
  @Schema(name = "deploymentDecisions", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentDecisionDTO> getDeploymentDecisions() {
    return deploymentDecisions;
  }

  public void setDeploymentDecisions(List<DeploymentDecisionDTO> deploymentDecisions) {
    this.deploymentDecisions = deploymentDecisions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentDecisionsDTO deploymentDecisionsDTO = (DeploymentDecisionsDTO) o;
    return Objects.equals(this.deploymentDecisions, deploymentDecisionsDTO.deploymentDecisions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deploymentDecisions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentDecisionsDTO {\n");
    sb.append("    deploymentDecisions: ").append(toIndentedString(deploymentDecisions)).append("\n");
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

