package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Deployment cancelation options detail
 */

@Schema(name = "DeploymentCancellationOptionsDetailDTO", description = "Deployment cancelation options detail")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentCancellationOptionsDetailDTO {

  @JsonProperty("databaseRollbackRestoreTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime databaseRollbackRestoreTimestamp;

  public DeploymentCancellationOptionsDetailDTO databaseRollbackRestoreTimestamp(OffsetDateTime databaseRollbackRestoreTimestamp) {
    this.databaseRollbackRestoreTimestamp = databaseRollbackRestoreTimestamp;
    return this;
  }

  /**
   * Time the database can be rolled back to
   * @return databaseRollbackRestoreTimestamp
  */
  @Valid 
  @Schema(name = "databaseRollbackRestoreTimestamp", description = "Time the database can be rolled back to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getDatabaseRollbackRestoreTimestamp() {
    return databaseRollbackRestoreTimestamp;
  }

  public void setDatabaseRollbackRestoreTimestamp(OffsetDateTime databaseRollbackRestoreTimestamp) {
    this.databaseRollbackRestoreTimestamp = databaseRollbackRestoreTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentCancellationOptionsDetailDTO deploymentCancellationOptionsDetailDTO = (DeploymentCancellationOptionsDetailDTO) o;
    return Objects.equals(this.databaseRollbackRestoreTimestamp, deploymentCancellationOptionsDetailDTO.databaseRollbackRestoreTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databaseRollbackRestoreTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentCancellationOptionsDetailDTO {\n");
    sb.append("    databaseRollbackRestoreTimestamp: ").append(toIndentedString(databaseRollbackRestoreTimestamp)).append("\n");
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

