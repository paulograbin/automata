package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Databackup
 */

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

