package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.cloudportal.ccv2.dto.TrafficSplitDetailDTO;
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
 * Traffic Split Audit History response DTO.
 */

@Schema(name = "TrafficSplitHistoryListDTO", description = "Traffic Split Audit History response DTO.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class TrafficSplitHistoryListDTO {

  @JsonProperty("value")
  @Valid
  private List<TrafficSplitDetailDTO> value = null;

  @JsonProperty("count")
  private Integer count;

  public TrafficSplitHistoryListDTO value(List<TrafficSplitDetailDTO> value) {
    this.value = value;
    return this;
  }

  public TrafficSplitHistoryListDTO addValueItem(TrafficSplitDetailDTO valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<>();
    }
    this.value.add(valueItem);
    return this;
  }

  /**
   * Array of traffic split history detail
   * @return value
  */
  @Valid 
  @Schema(name = "value", description = "Array of traffic split history detail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<TrafficSplitDetailDTO> getValue() {
    return value;
  }

  public void setValue(List<TrafficSplitDetailDTO> value) {
    this.value = value;
  }

  public TrafficSplitHistoryListDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The total number of traffic split
   * @return count
  */
  
  @Schema(name = "count", description = "The total number of traffic split", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    TrafficSplitHistoryListDTO trafficSplitHistoryListDTO = (TrafficSplitHistoryListDTO) o;
    return Objects.equals(this.value, trafficSplitHistoryListDTO.value) &&
        Objects.equals(this.count, trafficSplitHistoryListDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrafficSplitHistoryListDTO {\n");
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

