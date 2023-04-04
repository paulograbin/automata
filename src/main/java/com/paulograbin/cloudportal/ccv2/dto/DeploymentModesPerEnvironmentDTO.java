package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentModeDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Details of a deploymentmodes per environment
 */

@Schema(name = "DeploymentModesPerEnvironmentDTO", description = "Details of a deploymentmodes per environment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentModesPerEnvironmentDTO {

  @JsonProperty("environmentCode")
  private String environmentCode;

  @JsonProperty("deploymentModes")
  private DeploymentModeDTO deploymentModes;

  public DeploymentModesPerEnvironmentDTO environmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
    return this;
  }

  /**
   * Environment code
   * @return environmentCode
  */
  
  @Schema(name = "environmentCode", description = "Environment code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getEnvironmentCode() {
    return environmentCode;
  }

  public void setEnvironmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
  }

  public DeploymentModesPerEnvironmentDTO deploymentModes(DeploymentModeDTO deploymentModes) {
    this.deploymentModes = deploymentModes;
    return this;
  }

  /**
   * Get deploymentModes
   * @return deploymentModes
  */
  @Valid 
  @Schema(name = "deploymentModes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public DeploymentModeDTO getDeploymentModes() {
    return deploymentModes;
  }

  public void setDeploymentModes(DeploymentModeDTO deploymentModes) {
    this.deploymentModes = deploymentModes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentModesPerEnvironmentDTO deploymentModesPerEnvironmentDTO = (DeploymentModesPerEnvironmentDTO) o;
    return Objects.equals(this.environmentCode, deploymentModesPerEnvironmentDTO.environmentCode) &&
        Objects.equals(this.deploymentModes, deploymentModesPerEnvironmentDTO.deploymentModes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(environmentCode, deploymentModes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentModesPerEnvironmentDTO {\n");
    sb.append("    environmentCode: ").append(toIndentedString(environmentCode)).append("\n");
    sb.append("    deploymentModes: ").append(toIndentedString(deploymentModes)).append("\n");
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

