package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentDetailDTO;
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
 * Collection of deployment details
 */

@Schema(name = "DeploymentDetailsDTO", description = "Collection of deployment details")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentDetailsDTO {

  @JsonProperty("value")
  @Valid
  private List<DeploymentDetailDTO> value = null;

  @JsonProperty("count")
  private Integer count;

  public DeploymentDetailsDTO value(List<DeploymentDetailDTO> value) {
    this.value = value;
    return this;
  }

  public DeploymentDetailsDTO addValueItem(DeploymentDetailDTO valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<>();
    }
    this.value.add(valueItem);
    return this;
  }

  /**
   * Array of deployment details
   * @return value
  */
  @Valid 
  @Schema(name = "value", description = "Array of deployment details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentDetailDTO> getValue() {
    return value;
  }

  public void setValue(List<DeploymentDetailDTO> value) {
    this.value = value;
  }

  public DeploymentDetailsDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The total number of deployments
   * @return count
  */
  
  @Schema(name = "count", description = "The total number of deployments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentDetailsDTO deploymentDetailsDTO = (DeploymentDetailsDTO) o;
    return Objects.equals(this.value, deploymentDetailsDTO.value) &&
        Objects.equals(this.count, deploymentDetailsDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentDetailsDTO {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

