package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Entity to be used describe a deployment cancelation
 */

@Schema(name = "DeploymentCancelationDetailDTO", description = "Entity to be used describe a deployment cancelation")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentCancelationDetailDTO {

  @JsonProperty("canceledBy")
  private String canceledBy;

  @JsonProperty("startTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTimestamp;

  @JsonProperty("finishedTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime finishedTimestamp;

  @JsonProperty("failed")
  private Boolean failed;

  @JsonProperty("rollbackDatabase")
  private Boolean rollbackDatabase;

  @JsonProperty("cancelReason")
  private String cancelReason;

  public DeploymentCancelationDetailDTO canceledBy(String canceledBy) {
    this.canceledBy = canceledBy;
    return this;
  }

  /**
   * User that canceled the deployment
   * @return canceledBy
  */
  
  @Schema(name = "canceledBy", description = "User that canceled the deployment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCanceledBy() {
    return canceledBy;
  }

  public void setCanceledBy(String canceledBy) {
    this.canceledBy = canceledBy;
  }

  public DeploymentCancelationDetailDTO startTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
    return this;
  }

  /**
   * Time the cancelation was requested
   * @return startTimestamp
  */
  @Valid 
  @Schema(name = "startTimestamp", description = "Time the cancelation was requested", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  public DeploymentCancelationDetailDTO finishedTimestamp(OffsetDateTime finishedTimestamp) {
    this.finishedTimestamp = finishedTimestamp;
    return this;
  }

  /**
   * Time the cancelation finished
   * @return finishedTimestamp
  */
  @Valid 
  @Schema(name = "finishedTimestamp", description = "Time the cancelation finished", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getFinishedTimestamp() {
    return finishedTimestamp;
  }

  public void setFinishedTimestamp(OffsetDateTime finishedTimestamp) {
    this.finishedTimestamp = finishedTimestamp;
  }

  public DeploymentCancelationDetailDTO failed(Boolean failed) {
    this.failed = failed;
    return this;
  }

  /**
   * Flag to indicate if the deployment cancelation failed
   * @return failed
  */
  
  @Schema(name = "failed", description = "Flag to indicate if the deployment cancelation failed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean getFailed() {
    return failed;
  }

  public void setFailed(Boolean failed) {
    this.failed = failed;
  }

  public DeploymentCancelationDetailDTO rollbackDatabase(Boolean rollbackDatabase) {
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

  public DeploymentCancelationDetailDTO cancelReason(String cancelReason) {
    this.cancelReason = cancelReason;
    return this;
  }

  /**
   * Reason for cancelling a deployment
   * @return cancelReason
  */
  
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
    DeploymentCancelationDetailDTO deploymentCancelationDetailDTO = (DeploymentCancelationDetailDTO) o;
    return Objects.equals(this.canceledBy, deploymentCancelationDetailDTO.canceledBy) &&
        Objects.equals(this.startTimestamp, deploymentCancelationDetailDTO.startTimestamp) &&
        Objects.equals(this.finishedTimestamp, deploymentCancelationDetailDTO.finishedTimestamp) &&
        Objects.equals(this.failed, deploymentCancelationDetailDTO.failed) &&
        Objects.equals(this.rollbackDatabase, deploymentCancelationDetailDTO.rollbackDatabase) &&
        Objects.equals(this.cancelReason, deploymentCancelationDetailDTO.cancelReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canceledBy, startTimestamp, finishedTimestamp, failed, rollbackDatabase, cancelReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentCancelationDetailDTO {\n");
    sb.append("    canceledBy: ").append(toIndentedString(canceledBy)).append("\n");
    sb.append("    startTimestamp: ").append(toIndentedString(startTimestamp)).append("\n");
    sb.append("    finishedTimestamp: ").append(toIndentedString(finishedTimestamp)).append("\n");
    sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
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

