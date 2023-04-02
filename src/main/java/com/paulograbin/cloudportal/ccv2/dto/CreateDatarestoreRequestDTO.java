package com.paulograbin.ccv2api.model;

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
 * Create datarestore request
 */

@Schema(name = "CreateDatarestoreRequestDTO", description = "Create datarestore request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDatarestoreRequestDTO {

  @JsonProperty("databackupCode")
  private String databackupCode;

  @JsonProperty("sourceEnvironmentCode")
  private String sourceEnvironmentCode;

  public CreateDatarestoreRequestDTO databackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
    return this;
  }

  /**
   * Databackup code
   * @return databackupCode
  */
  
  @Schema(name = "databackupCode", description = "Databackup code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDatabackupCode() {
    return databackupCode;
  }

  public void setDatabackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
  }

  public CreateDatarestoreRequestDTO sourceEnvironmentCode(String sourceEnvironmentCode) {
    this.sourceEnvironmentCode = sourceEnvironmentCode;
    return this;
  }

  /**
   * Source environment (where the databackup was created)
   * @return sourceEnvironmentCode
  */
  
  @Schema(name = "sourceEnvironmentCode", description = "Source environment (where the databackup was created)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSourceEnvironmentCode() {
    return sourceEnvironmentCode;
  }

  public void setSourceEnvironmentCode(String sourceEnvironmentCode) {
    this.sourceEnvironmentCode = sourceEnvironmentCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDatarestoreRequestDTO createDatarestoreRequestDTO = (CreateDatarestoreRequestDTO) o;
    return Objects.equals(this.databackupCode, createDatarestoreRequestDTO.databackupCode) &&
        Objects.equals(this.sourceEnvironmentCode, createDatarestoreRequestDTO.sourceEnvironmentCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databackupCode, sourceEnvironmentCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDatarestoreRequestDTO {\n");
    sb.append("    databackupCode: ").append(toIndentedString(databackupCode)).append("\n");
    sb.append("    sourceEnvironmentCode: ").append(toIndentedString(sourceEnvironmentCode)).append("\n");
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

