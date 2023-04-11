package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details of a build
 */

@Schema(name = "BuildDetailDTO", description = "Details of a build")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class BuildDetailDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("applicationCode")
  private String applicationCode;

  @JsonProperty("applicationDefinitionVersion")
  private String applicationDefinitionVersion;

  @JsonProperty("branch")
  private String branch;

  @JsonProperty("name")
  private String name;

  @JsonProperty("code")
  private String code;

  @JsonProperty("buildStartTimestamp")
  @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
  private OffsetDateTime buildStartTimestamp;

  @JsonProperty("buildEndTimestamp")
  @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
  private OffsetDateTime buildEndTimestamp;

  @JsonProperty("buildVersion")
  private String buildVersion;

  @JsonProperty("createdBy")
  private String createdBy;

  @JsonProperty("status")
  private String status;

  @JsonProperty("properties")
  @Valid
  private List<PropertyDTO> properties = null;

  public BuildDetailDTO subscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
    return this;
  }

  /**
   * Code of the subscription
   * @return subscriptionCode
  */
  
  @Schema(name = "subscriptionCode", description = "Code of the subscription", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getSubscriptionCode() {
    return subscriptionCode;
  }

  public void setSubscriptionCode(String subscriptionCode) {
    this.subscriptionCode = subscriptionCode;
  }

  public BuildDetailDTO applicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
    return this;
  }

  /**
   * Application code
   * @return applicationCode
  */
  
  @Schema(name = "applicationCode", description = "Application code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }

  public BuildDetailDTO applicationDefinitionVersion(String applicationDefinitionVersion) {
    this.applicationDefinitionVersion = applicationDefinitionVersion;
    return this;
  }

  /**
   * Application definition version
   * @return applicationDefinitionVersion
  */
  
  @Schema(name = "applicationDefinitionVersion", description = "Application definition version", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getApplicationDefinitionVersion() {
    return applicationDefinitionVersion;
  }

  public void setApplicationDefinitionVersion(String applicationDefinitionVersion) {
    this.applicationDefinitionVersion = applicationDefinitionVersion;
  }

  public BuildDetailDTO branch(String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * Branch name
   * @return branch
  */
  
  @Schema(name = "branch", description = "Branch name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public BuildDetailDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Build name
   * @return name
  */
  
  @Schema(name = "name", description = "Build name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BuildDetailDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Build code
   * @return code
  */
  
  @Schema(name = "code", description = "Build code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public BuildDetailDTO buildStartTimestamp(OffsetDateTime buildStartTimestamp) {
    this.buildStartTimestamp = buildStartTimestamp;
    return this;
  }

  /**
   * Build start timestamp
   * @return buildStartTimestamp
  */
  @Valid 
  @Schema(name = "buildStartTimestamp", description = "Build start timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getBuildStartTimestamp() {
    return buildStartTimestamp;
  }

  public void setBuildStartTimestamp(OffsetDateTime buildStartTimestamp) {
    this.buildStartTimestamp = buildStartTimestamp;
  }

  public BuildDetailDTO buildEndTimestamp(OffsetDateTime buildEndTimestamp) {
    this.buildEndTimestamp = buildEndTimestamp;
    return this;
  }

  /**
   * Build end timestamp
   * @return buildEndTimestamp
  */
  @Valid 
  @Schema(name = "buildEndTimestamp", description = "Build end timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getBuildEndTimestamp() {
    return buildEndTimestamp;
  }

  public void setBuildEndTimestamp(OffsetDateTime buildEndTimestamp) {
    this.buildEndTimestamp = buildEndTimestamp;
  }

  public BuildDetailDTO buildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
    return this;
  }

  /**
   * Build version
   * @return buildVersion
  */
  
  @Schema(name = "buildVersion", description = "Build version", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBuildVersion() {
    return buildVersion;
  }

  public void setBuildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
  }

  public BuildDetailDTO createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

  /**
   * Initiator of the build
   * @return createdBy
  */
  
  @Schema(name = "createdBy", description = "Initiator of the build", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public BuildDetailDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Current status of the build , possible values are \"BUILDING\",\"SUCCESS\",\"FAIL\",\"SCHEDULED\",\"DELETED\" or \"UNKNOWN\"
   * @return status
  */
  
  @Schema(name = "status", description = "Current status of the build , possible values are \"BUILDING\",\"SUCCESS\",\"FAIL\",\"SCHEDULED\",\"DELETED\" or \"UNKNOWN\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BuildDetailDTO properties(List<PropertyDTO> properties) {
    this.properties = properties;
    return this;
  }

  public BuildDetailDTO addPropertiesItem(PropertyDTO propertiesItem) {
    if (this.properties == null) {
      this.properties = new ArrayList<>();
    }
    this.properties.add(propertiesItem);
    return this;
  }

  /**
   * Properties that are used for this build
   * @return properties
  */
  @Valid 
  @Schema(name = "properties", description = "Properties that are used for this build", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<PropertyDTO> getProperties() {
    return properties;
  }

  public void setProperties(List<PropertyDTO> properties) {
    this.properties = properties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuildDetailDTO buildDetailDTO = (BuildDetailDTO) o;
    return Objects.equals(this.subscriptionCode, buildDetailDTO.subscriptionCode) &&
        Objects.equals(this.applicationCode, buildDetailDTO.applicationCode) &&
        Objects.equals(this.applicationDefinitionVersion, buildDetailDTO.applicationDefinitionVersion) &&
        Objects.equals(this.branch, buildDetailDTO.branch) &&
        Objects.equals(this.name, buildDetailDTO.name) &&
        Objects.equals(this.code, buildDetailDTO.code) &&
        Objects.equals(this.buildStartTimestamp, buildDetailDTO.buildStartTimestamp) &&
        Objects.equals(this.buildEndTimestamp, buildDetailDTO.buildEndTimestamp) &&
        Objects.equals(this.buildVersion, buildDetailDTO.buildVersion) &&
        Objects.equals(this.createdBy, buildDetailDTO.createdBy) &&
        Objects.equals(this.status, buildDetailDTO.status) &&
        Objects.equals(this.properties, buildDetailDTO.properties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, applicationCode, applicationDefinitionVersion, branch, name, code, buildStartTimestamp, buildEndTimestamp, buildVersion, createdBy, status, properties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildDetailDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    applicationCode: ").append(toIndentedString(applicationCode)).append("\n");
    sb.append("    applicationDefinitionVersion: ").append(toIndentedString(applicationDefinitionVersion)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    buildStartTimestamp: ").append(toIndentedString(buildStartTimestamp)).append("\n");
    sb.append("    buildEndTimestamp: ").append(toIndentedString(buildEndTimestamp)).append("\n");
    sb.append("    buildVersion: ").append(toIndentedString(buildVersion)).append("\n");
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
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

