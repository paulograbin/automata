package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Entity to be used to cancel a deployment
 */

@Schema(name = "DeploymentCancellationRequestDTO", description = "Entity to be used to cancel a deployment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentCancellationRequestDTO {

  @JsonProperty("rollbackDatabase")
  private Boolean rollbackDatabase;

  @JsonProperty("cancelReason")
  private String cancelReason;

  public DeploymentCancellationRequestDTO rollbackDatabase(Boolean rollbackDatabase) {
    this.rollbackDatabase = rollbackDatabase;
    return this;
  }

  /**
   * Optional flag to indicate if the database should be rolled back
   * @return rollbackDatabase
  */
  
  @Schema(name = "rollbackDatabase", description = "Optional flag to indicate if the database should be rolled back", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean getRollbackDatabase() {
    return rollbackDatabase;
  }

  public void setRollbackDatabase(Boolean rollbackDatabase) {
    this.rollbackDatabase = rollbackDatabase;
  }

  public DeploymentCancellationRequestDTO cancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
    return this;
  }

  /**
   * Reason for cancelling a deployment
   * @return cancelReason
  */
  @Size(min = 4, max = 255) 
  @Schema(name = "cancelReason", description = "Reason for cancelling a deployment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCancelReason() {
    return cancelReason;
  }

  public void setCancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentCancellationRequestDTO deploymentCancellationRequestDTO = (DeploymentCancellationRequestDTO) o;
    return Objects.equals(this.rollbackDatabase, deploymentCancellationRequestDTO.rollbackDatabase) &&
        Objects.equals(this.cancelReason, deploymentCancellationRequestDTO.cancelReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rollbackDatabase, cancelReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentCancellationRequestDTO {\n");
    sb.append("    rollbackDatabase: ").append(toIndentedString(rollbackDatabase)).append("\n");
    sb.append("    cancelReason: ").append(toIndentedString(cancelReason)).append("\n");
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

