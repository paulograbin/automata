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
 * One step in a deployment progress stage
 */

@Schema(name = "DeploymentProgressStepDTO", description = "One step in a deployment progress stage")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentProgressStepDTO {

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("startTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTimestamp;

  @JsonProperty("endTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTimestamp;

  @JsonProperty("message")
  private String message;

  @JsonProperty("status")
  private String status;

  @JsonProperty("children")
  @Valid
  private List<DeploymentProgressStepDTO> children = null;

  public DeploymentProgressStepDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Unique code of the step
   * @return code
  */
  
  @Schema(name = "code", description = "Unique code of the step", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public DeploymentProgressStepDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the step
   * @return name
  */
  
  @Schema(name = "name", description = "Name of the step", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeploymentProgressStepDTO startTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
    return this;
  }

  /**
   * Start timestamp of the step
   * @return startTimestamp
  */
  @Valid 
  @Schema(name = "startTimestamp", description = "Start timestamp of the step", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  public DeploymentProgressStepDTO endTimestamp(OffsetDateTime endTimestamp) {
    this.endTimestamp = endTimestamp;
    return this;
  }

  /**
   * End timestamp of the step
   * @return endTimestamp
  */
  @Valid 
  @Schema(name = "endTimestamp", description = "End timestamp of the step", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getEndTimestamp() {
    return endTimestamp;
  }

  public void setEndTimestamp(OffsetDateTime endTimestamp) {
    this.endTimestamp = endTimestamp;
  }

  public DeploymentProgressStepDTO message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Optional message for the step describing what happened
   * @return message
  */
  
  @Schema(name = "message", description = "Optional message for the step describing what happened", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public DeploymentProgressStepDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Current status of the step, possible values are \"PENDING\",\"RUNNING\",\"DONE\" or \"FAIL\"
   * @return status
  */
  
  @Schema(name = "status", description = "Current status of the step, possible values are \"PENDING\",\"RUNNING\",\"DONE\" or \"FAIL\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DeploymentProgressStepDTO children(List<DeploymentProgressStepDTO> children) {
    this.children = children;
    return this;
  }

  public DeploymentProgressStepDTO addChildrenItem(DeploymentProgressStepDTO childrenItem) {
    if (this.children == null) {
      this.children = new ArrayList<>();
    }
    this.children.add(childrenItem);
    return this;
  }

  /**
   * One or multiple deployment progress steps
   * @return children
  */
  @Valid 
  @Schema(name = "children", description = "One or multiple deployment progress steps", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentProgressStepDTO> getChildren() {
    return children;
  }

  public void setChildren(List<DeploymentProgressStepDTO> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentProgressStepDTO deploymentProgressStepDTO = (DeploymentProgressStepDTO) o;
    return Objects.equals(this.code, deploymentProgressStepDTO.code) &&
        Objects.equals(this.name, deploymentProgressStepDTO.name) &&
        Objects.equals(this.startTimestamp, deploymentProgressStepDTO.startTimestamp) &&
        Objects.equals(this.endTimestamp, deploymentProgressStepDTO.endTimestamp) &&
        Objects.equals(this.message, deploymentProgressStepDTO.message) &&
        Objects.equals(this.status, deploymentProgressStepDTO.status) &&
        Objects.equals(this.children, deploymentProgressStepDTO.children);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, startTimestamp, endTimestamp, message, status, children);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentProgressStepDTO {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startTimestamp: ").append(toIndentedString(startTimestamp)).append("\n");
    sb.append("    endTimestamp: ").append(toIndentedString(endTimestamp)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    children: ").append(toIndentedString(children)).append("\n");
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

