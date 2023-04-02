package com.paulograbin.ccv2api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paulograbin.ccv2api.model.DeploymentDecision;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Deployment decision response
 */

@Schema(name = "CreateDeploymentDecisionResponseDTO", description = "Deployment decision response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDeploymentDecisionResponseDTO {

  @JsonProperty("newDeploymentCode")
  private String newDeploymentCode;

  @JsonProperty("decison")
  private DeploymentDecision decison;

  public CreateDeploymentDecisionResponseDTO newDeploymentCode(String newDeploymentCode) {
    this.newDeploymentCode = newDeploymentCode;
    return this;
  }

  /**
   * Code of the new deployment, will have a value only when the decision is not REJECT.
   * @return newDeploymentCode
  */
  
  @Schema(name = "newDeploymentCode", description = "Code of the new deployment, will have a value only when the decision is not REJECT.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getNewDeploymentCode() {
    return newDeploymentCode;
  }

  public void setNewDeploymentCode(String newDeploymentCode) {
    this.newDeploymentCode = newDeploymentCode;
  }

  public CreateDeploymentDecisionResponseDTO decison(DeploymentDecision decison) {
    this.decison = decison;
    return this;
  }

  /**
   * Get decison
   * @return decison
  */
  @Valid 
  @Schema(name = "decison", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public DeploymentDecision getDecison() {
    return decison;
  }

  public void setDecison(DeploymentDecision decison) {
    this.decison = decison;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDeploymentDecisionResponseDTO createDeploymentDecisionResponseDTO = (CreateDeploymentDecisionResponseDTO) o;
    return Objects.equals(this.newDeploymentCode, createDeploymentDecisionResponseDTO.newDeploymentCode) &&
        Objects.equals(this.decison, createDeploymentDecisionResponseDTO.decison);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newDeploymentCode, decison);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDeploymentDecisionResponseDTO {\n");
    sb.append("    newDeploymentCode: ").append(toIndentedString(newDeploymentCode)).append("\n");
    sb.append("    decison: ").append(toIndentedString(decison)).append("\n");
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

