package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Datarestore
 */

@Schema(name = "DatarestoreDetailDTO", description = "Datarestore")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DatarestoreDetailDTO {

  @JsonProperty("datarestoreCode")
  private String datarestoreCode;

  @JsonProperty("name")
  private String name;

  @JsonProperty("status")
  private String status;

  @JsonProperty("databackupCode")
  private String databackupCode;

  @JsonProperty("createdBy")
  private String createdBy;

  @JsonProperty("createdTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime createdTimestamp;

  public DatarestoreDetailDTO datarestoreCode(String datarestoreCode) {
    this.datarestoreCode = datarestoreCode;
    return this;
  }

  /**
   * Datarestore Code
   * @return datarestoreCode
  */
  
  @Schema(name = "datarestoreCode", description = "Datarestore Code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDatarestoreCode() {
    return datarestoreCode;
  }

  public void setDatarestoreCode(String datarestoreCode) {
    this.datarestoreCode = datarestoreCode;
  }

  public DatarestoreDetailDTO name(String name) {
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

  public DatarestoreDetailDTO status(String status) {
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

  public DatarestoreDetailDTO databackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
    return this;
  }

  /**
   * Databackup that is the source of the datarestore
   * @return databackupCode
  */
  
  @Schema(name = "databackupCode", description = "Databackup that is the source of the datarestore", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getDatabackupCode() {
    return databackupCode;
  }

  public void setDatabackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
  }

  public DatarestoreDetailDTO createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * User that started (created) the datarestore
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "User that started (created) the datarestore", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public DatarestoreDetailDTO createdTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
    return this;
  }

  /**
   * Datarestore creation timestamp
   * @return createdTimestamp
  */
  @Valid 
  @Schema(name = "createdTimestamp", description = "Datarestore creation timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getCreatedTimestamp() {
    return createdTimestamp;
  }

  public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
    this.createdTimestamp = createdTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DatarestoreDetailDTO datarestoreDetailDTO = (DatarestoreDetailDTO) o;
    return Objects.equals(this.datarestoreCode, datarestoreDetailDTO.datarestoreCode) &&
        Objects.equals(this.name, datarestoreDetailDTO.name) &&
        Objects.equals(this.status, datarestoreDetailDTO.status) &&
        Objects.equals(this.databackupCode, datarestoreDetailDTO.databackupCode) &&
        Objects.equals(this.createdBy, datarestoreDetailDTO.createdBy) &&
        Objects.equals(this.createdTimestamp, datarestoreDetailDTO.createdTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(datarestoreCode, name, status, databackupCode, createdBy, createdTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatarestoreDetailDTO {\n");
    sb.append("    datarestoreCode: ").append(toIndentedString(datarestoreCode)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    databackupCode: ").append(toIndentedString(databackupCode)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdTimestamp: ").append(toIndentedString(createdTimestamp)).append("\n");
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

