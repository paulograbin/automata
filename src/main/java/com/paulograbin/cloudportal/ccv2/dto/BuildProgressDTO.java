package com.paulograbin.ccv2api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.ccv2api.model.BuildProgressStartedTaskDTO;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Build progress
 */

@Schema(name = "BuildProgressDTO", description = "Build progress")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class BuildProgressDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("buildCode")
  private String buildCode;

  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("numberOfTasks")
  private Integer numberOfTasks;

  @JsonProperty("percentage")
  private Integer percentage;

  @JsonProperty("buildStatus")
  private String buildStatus;

  @JsonProperty("startedTasks")
  @Valid
  private List<BuildProgressStartedTaskDTO> startedTasks = null;

  public BuildProgressDTO subscriptionCode(String subscriptionCode) {
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

  public BuildProgressDTO buildCode(String buildCode) {
    this.buildCode = buildCode;
    return this;
  }

  /**
   * Code of the build
   * @return buildCode
  */
  
  @Schema(name = "buildCode", description = "Code of the build", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBuildCode() {
    return buildCode;
  }

  public void setBuildCode(String buildCode) {
    this.buildCode = buildCode;
  }

  public BuildProgressDTO errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Human readable error message
   * @return errorMessage
  */
  
  @Schema(name = "errorMessage", description = "Human readable error message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public BuildProgressDTO numberOfTasks(Integer numberOfTasks) {
    this.numberOfTasks = numberOfTasks;
    return this;
  }

  /**
   * Total number of tasks that will be executed
   * @return numberOfTasks
  */
  
  @Schema(name = "numberOfTasks", description = "Total number of tasks that will be executed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getNumberOfTasks() {
    return numberOfTasks;
  }

  public void setNumberOfTasks(Integer numberOfTasks) {
    this.numberOfTasks = numberOfTasks;
  }

  public BuildProgressDTO percentage(Integer percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Progress percentage
   * @return percentage
  */
  
  @Schema(name = "percentage", description = "Progress percentage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getPercentage() {
    return percentage;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  public BuildProgressDTO buildStatus(String buildStatus) {
    this.buildStatus = buildStatus;
    return this;
  }

  /**
   * Current status of the build , possible values are \"BUILDING\",\"SUCCESS\",\"FAIL\",\"SCHEDULED\",\"DELETED\" or \"UNKNOWN\"
   * @return buildStatus
  */
  
  @Schema(name = "buildStatus", description = "Current status of the build , possible values are \"BUILDING\",\"SUCCESS\",\"FAIL\",\"SCHEDULED\",\"DELETED\" or \"UNKNOWN\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getBuildStatus() {
    return buildStatus;
  }

  public void setBuildStatus(String buildStatus) {
    this.buildStatus = buildStatus;
  }

  public BuildProgressDTO startedTasks(List<BuildProgressStartedTaskDTO> startedTasks) {
    this.startedTasks = startedTasks;
    return this;
  }

  public BuildProgressDTO addStartedTasksItem(BuildProgressStartedTaskDTO startedTasksItem) {
    if (this.startedTasks == null) {
      this.startedTasks = new ArrayList<>();
    }
    this.startedTasks.add(startedTasksItem);
    return this;
  }

  /**
   * List of started tasks of this progress
   * @return startedTasks
  */
  @Valid 
  @Schema(name = "startedTasks", description = "List of started tasks of this progress", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<BuildProgressStartedTaskDTO> getStartedTasks() {
    return startedTasks;
  }

  public void setStartedTasks(List<BuildProgressStartedTaskDTO> startedTasks) {
    this.startedTasks = startedTasks;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuildProgressDTO buildProgressDTO = (BuildProgressDTO) o;
    return Objects.equals(this.subscriptionCode, buildProgressDTO.subscriptionCode) &&
        Objects.equals(this.buildCode, buildProgressDTO.buildCode) &&
        Objects.equals(this.errorMessage, buildProgressDTO.errorMessage) &&
        Objects.equals(this.numberOfTasks, buildProgressDTO.numberOfTasks) &&
        Objects.equals(this.percentage, buildProgressDTO.percentage) &&
        Objects.equals(this.buildStatus, buildProgressDTO.buildStatus) &&
        Objects.equals(this.startedTasks, buildProgressDTO.startedTasks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, buildCode, errorMessage, numberOfTasks, percentage, buildStatus, startedTasks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildProgressDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    buildCode: ").append(toIndentedString(buildCode)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    numberOfTasks: ").append(toIndentedString(numberOfTasks)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    buildStatus: ").append(toIndentedString(buildStatus)).append("\n");
    sb.append("    startedTasks: ").append(toIndentedString(startedTasks)).append("\n");
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

