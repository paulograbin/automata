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
 * One deployment progress stage
 */

@Schema(name = "DeploymentProgressStageDTO", description = "One deployment progress stage")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentProgressStageDTO {

  @JsonProperty("name")
  private String name;

  @JsonProperty("type")
  private String type;

  @JsonProperty("startTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTimestamp;

  @JsonProperty("endTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endTimestamp;

  @JsonProperty("status")
  private String status;

  @JsonProperty("logLink")
  private String logLink;

  @JsonProperty("steps")
  @Valid
  private List<DeploymentProgressStepDTO> steps = null;

  public DeploymentProgressStageDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the stage
   * @return name
  */
  
  @Schema(name = "name", description = "Name of the stage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeploymentProgressStageDTO type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the stage
   * @return type
  */
  
  @Schema(name = "type", description = "Type of the stage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public DeploymentProgressStageDTO startTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
    return this;
  }

  /**
   * Start timestamp of the stage
   * @return startTimestamp
  */
  @Valid 
  @Schema(name = "startTimestamp", description = "Start timestamp of the stage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  public DeploymentProgressStageDTO endTimestamp(OffsetDateTime endTimestamp) {
    this.endTimestamp = endTimestamp;
    return this;
  }

  /**
   * End timestamp of the stage
   * @return endTimestamp
  */
  @Valid 
  @Schema(name = "endTimestamp", description = "End timestamp of the stage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getEndTimestamp() {
    return endTimestamp;
  }

  public void setEndTimestamp(OffsetDateTime endTimestamp) {
    this.endTimestamp = endTimestamp;
  }

  public DeploymentProgressStageDTO status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Current status of the stage, possible values are \"PENDING\",\"RUNNING\",\"DONE\" or \"FAIL\"
   * @return status
  */
  
  @Schema(name = "status", description = "Current status of the stage, possible values are \"PENDING\",\"RUNNING\",\"DONE\" or \"FAIL\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DeploymentProgressStageDTO logLink(String logLink) {
    this.logLink = logLink;
    return this;
  }

  /**
   * Link to logs of the stage
   * @return logLink
  */
  
  @Schema(name = "logLink", description = "Link to logs of the stage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getLogLink() {
    return logLink;
  }

  public void setLogLink(String logLink) {
    this.logLink = logLink;
  }

  public DeploymentProgressStageDTO steps(List<DeploymentProgressStepDTO> steps) {
    this.steps = steps;
    return this;
  }

  public DeploymentProgressStageDTO addStepsItem(DeploymentProgressStepDTO stepsItem) {
    if (this.steps == null) {
      this.steps = new ArrayList<>();
    }
    this.steps.add(stepsItem);
    return this;
  }

  /**
   * One or multiple deployment progress steps
   * @return steps
  */
  @Valid 
  @Schema(name = "steps", description = "One or multiple deployment progress steps", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentProgressStepDTO> getSteps() {
    return steps;
  }

  public void setSteps(List<DeploymentProgressStepDTO> steps) {
    this.steps = steps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentProgressStageDTO deploymentProgressStageDTO = (DeploymentProgressStageDTO) o;
    return Objects.equals(this.name, deploymentProgressStageDTO.name) &&
        Objects.equals(this.type, deploymentProgressStageDTO.type) &&
        Objects.equals(this.startTimestamp, deploymentProgressStageDTO.startTimestamp) &&
        Objects.equals(this.endTimestamp, deploymentProgressStageDTO.endTimestamp) &&
        Objects.equals(this.status, deploymentProgressStageDTO.status) &&
        Objects.equals(this.logLink, deploymentProgressStageDTO.logLink) &&
        Objects.equals(this.steps, deploymentProgressStageDTO.steps);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type, startTimestamp, endTimestamp, status, logLink, steps);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentProgressStageDTO {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    startTimestamp: ").append(toIndentedString(startTimestamp)).append("\n");
    sb.append("    endTimestamp: ").append(toIndentedString(endTimestamp)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    logLink: ").append(toIndentedString(logLink)).append("\n");
    sb.append("    steps: ").append(toIndentedString(steps)).append("\n");
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

