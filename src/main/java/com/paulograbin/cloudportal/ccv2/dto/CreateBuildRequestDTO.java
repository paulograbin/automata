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
 * Entity to be used to start new builds
 */

@Schema(name = "CreateBuildRequestDTO", description = "Entity to be used to start new builds")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateBuildRequestDTO {

  @JsonProperty("applicationCode")
  private String applicationCode;

  @JsonProperty("branch")
  private String branch;

  @JsonProperty("name")
  private String name;

  public CreateBuildRequestDTO applicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
    return this;
  }

  /**
   * Code of the application
   * @return applicationCode
  */
  
  @Schema(name = "applicationCode", description = "Code of the application", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }

  public CreateBuildRequestDTO branch(String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * Branch name of the application
   * @return branch
  */
  @NotNull 
  @Schema(name = "branch", description = "Branch name of the application", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public CreateBuildRequestDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the build
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Name of the build", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBuildRequestDTO createBuildRequestDTO = (CreateBuildRequestDTO) o;
    return Objects.equals(this.applicationCode, createBuildRequestDTO.applicationCode) &&
        Objects.equals(this.branch, createBuildRequestDTO.branch) &&
        Objects.equals(this.name, createBuildRequestDTO.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationCode, branch, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBuildRequestDTO {\n");
    sb.append("    applicationCode: ").append(toIndentedString(applicationCode)).append("\n");
    sb.append("    branch: ").append(toIndentedString(branch)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

