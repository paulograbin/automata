package com.paulograbin.ccv2api.model;

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
 * Databackup
 */

@Schema(name = "DatabackupDetailDTO", description = "Databackup")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DatabackupDetailDTO {

  @JsonProperty("databackupCode")
  private String databackupCode;

  @JsonProperty("name")
  private String name;

  @JsonProperty("buildCode")
  private String buildCode;

  @JsonProperty("status")
  private String status;

  @JsonProperty("description")
  private String description;

  @JsonProperty("createdBy")
  private String createdBy;

  @JsonProperty("createdTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdTimestamp;

  @JsonProperty("canBeRestored")
  private Boolean canBeRestored;

  @JsonProperty("canBeDeleted")
  private Boolean canBeDeleted;

  public DatabackupDetailDTO databackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
    return this;
  }

  /**
   * Databackup Code
   * @return databackupCode
  */
  
  @Schema(name = "databackupCode", description = "Databackup Code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDatabackupCode() {
    return databackupCode;
  }

  public void setDatabackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
  }

  public DatabackupDetailDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  */
  
  @Schema(name = "name", description = "Name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DatabackupDetailDTO buildCode(String buildCode) {
    this.buildCode = buildCode;
    return this;
  }

  /**
   * Build code
   * @return buildCode
  */
  
  @Schema(name = "buildCode", description = "Build code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBuildCode() {
    return buildCode;
  }

  public void setBuildCode(String buildCode) {
    this.buildCode = buildCode;
  }

  public DatabackupDetailDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status
   * @return status
  */
  
  @Schema(name = "status", description = "Status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DatabackupDetailDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description
   * @return description
  */
  
  @Schema(name = "description", description = "Description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DatabackupDetailDTO createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * User that created the databackup
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "User that created the databackup", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public DatabackupDetailDTO createdTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
    return this;
  }

  /**
   * Databackup creation timestamp
   * @return createdTimestamp
  */
  @Valid 
  @Schema(name = "createdTimestamp", description = "Databackup creation timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getCreatedTimestamp() {
    return createdTimestamp;
  }

  public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  public DatabackupDetailDTO canBeRestored(Boolean canBeRestored) {
    this.canBeRestored = canBeRestored;
    return this;
  }

  /**
   * Can be restored
   * @return canBeRestored
  */
  
  @Schema(name = "canBeRestored", description = "Can be restored", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean getCanBeRestored() {
    return canBeRestored;
  }

  public void setCanBeRestored(Boolean canBeRestored) {
    this.canBeRestored = canBeRestored;
  }

  public DatabackupDetailDTO canBeDeleted(Boolean canBeDeleted) {
    this.canBeDeleted = canBeDeleted;
    return this;
  }

  /**
   * Can be deleted
   * @return canBeDeleted
  */
  
  @Schema(name = "canBeDeleted", description = "Can be deleted", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Boolean getCanBeDeleted() {
    return canBeDeleted;
  }

  public void setCanBeDeleted(Boolean canBeDeleted) {
    this.canBeDeleted = canBeDeleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatabackupDetailDTO databackupDetailDTO = (DatabackupDetailDTO) o;
    return Objects.equals(this.databackupCode, databackupDetailDTO.databackupCode) &&
        Objects.equals(this.name, databackupDetailDTO.name) &&
        Objects.equals(this.buildCode, databackupDetailDTO.buildCode) &&
        Objects.equals(this.status, databackupDetailDTO.status) &&
        Objects.equals(this.description, databackupDetailDTO.description) &&
        Objects.equals(this.createdBy, databackupDetailDTO.createdBy) &&
        Objects.equals(this.createdTimestamp, databackupDetailDTO.createdTimestamp) &&
        Objects.equals(this.canBeRestored, databackupDetailDTO.canBeRestored) &&
        Objects.equals(this.canBeDeleted, databackupDetailDTO.canBeDeleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(databackupCode, name, buildCode, status, description, createdBy, createdTimestamp, canBeRestored, canBeDeleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatabackupDetailDTO {\n");
    sb.append("    databackupCode: ").append(toIndentedString(databackupCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    buildCode: ").append(toIndentedString(buildCode)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdTimestamp: ").append(toIndentedString(createdTimestamp)).append("\n");
    sb.append("    canBeRestored: ").append(toIndentedString(canBeRestored)).append("\n");
    sb.append("    canBeDeleted: ").append(toIndentedString(canBeDeleted)).append("\n");
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

