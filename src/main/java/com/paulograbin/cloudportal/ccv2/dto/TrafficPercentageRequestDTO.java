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
 * Traffic percentage Request DTO.
 */

@Schema(name = "TrafficPercentageRequestDTO", description = "Traffic percentage Request DTO.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class TrafficPercentageRequestDTO {

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("percentage")
  private Integer percentage;

  public TrafficPercentageRequestDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Code of the traffic split entity. eg. service code, endpoint code
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "Code of the traffic split entity. eg. service code, endpoint code", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public TrafficPercentageRequestDTO percentage(Integer percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Percentage of the traffic split
   * minimum: 0
   * maximum: 100
   * @return percentage
  */
  @NotNull @Min(0) @Max(100) 
  @Schema(name = "percentage", description = "Percentage of the traffic split", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getPercentage() {
    return percentage;
  }

  public void setPercentage(Integer percentage) {
    this.percentage = percentage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrafficPercentageRequestDTO trafficPercentageRequestDTO = (TrafficPercentageRequestDTO) o;
    return Objects.equals(this.code, trafficPercentageRequestDTO.code) &&
        Objects.equals(this.percentage, trafficPercentageRequestDTO.percentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, percentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrafficPercentageRequestDTO {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
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

