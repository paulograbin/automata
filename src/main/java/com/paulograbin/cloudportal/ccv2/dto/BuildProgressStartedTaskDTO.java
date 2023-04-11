package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Started task of a build progress
 */

@Schema(name = "BuildProgressStartedTaskDTO", description = "Started task of a build progress")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class BuildProgressStartedTaskDTO {

  @JsonProperty("task")
  private String task;

  @JsonProperty("name")
  private String name;

  @JsonProperty("startTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startTimestamp;

  public BuildProgressStartedTaskDTO task(String task) {
    this.task = task;
    return this;
  }

  /**
   * Name of the task
   * @return task
  */
  
  @Schema(name = "task", description = "Name of the task", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public BuildProgressStartedTaskDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Business name of the task
   * @return name
  */
  
  @Schema(name = "name", description = "Business name of the task", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BuildProgressStartedTaskDTO startTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
    return this;
  }

  /**
   * Start timestamp of the task
   * @return startTimestamp
  */
  @Valid 
  @Schema(name = "startTimestamp", description = "Start timestamp of the task", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getStartTimestamp() {
    return startTimestamp;
  }

  public void setStartTimestamp(OffsetDateTime startTimestamp) {
    this.startTimestamp = startTimestamp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuildProgressStartedTaskDTO buildProgressStartedTaskDTO = (BuildProgressStartedTaskDTO) o;
    return Objects.equals(this.task, buildProgressStartedTaskDTO.task) &&
        Objects.equals(this.name, buildProgressStartedTaskDTO.name) &&
        Objects.equals(this.startTimestamp, buildProgressStartedTaskDTO.startTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(task, name, startTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildProgressStartedTaskDTO {\n");
    sb.append("    task: ").append(toIndentedString(task)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    startTimestamp: ").append(toIndentedString(startTimestamp)).append("\n");
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

