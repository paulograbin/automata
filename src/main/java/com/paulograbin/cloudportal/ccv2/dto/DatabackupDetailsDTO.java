package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Collection of databackup details
 */

@Schema(name = "DatabackupDetailsDTO", description = "Collection of databackup details")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DatabackupDetailsDTO {

  @JsonProperty("value")
  @Valid
  private List<DatabackupDetailDTO> value = null;

  @JsonProperty("count")
  private Integer count;

  public DatabackupDetailsDTO value(List<DatabackupDetailDTO> value) {
    this.value = value;
    return this;
  }

  public DatabackupDetailsDTO addValueItem(DatabackupDetailDTO valueItem) {
    if (this.value == null) {
      this.value = new ArrayList<>();
    }
    this.value.add(valueItem);
    return this;
  }

  /**
   * Array of databackup details
   * @return value
  */
  @Valid 
  @Schema(name = "value", description = "Array of databackup details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DatabackupDetailDTO> getValue() {
    return value;
  }

  public void setValue(List<DatabackupDetailDTO> value) {
    this.value = value;
  }

  public DatabackupDetailsDTO count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The total number of databackups
   * @return count
  */
  
  @Schema(name = "count", description = "The total number of databackups", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    DatabackupDetailsDTO databackupDetailsDTO = (DatabackupDetailsDTO) o;
    return Objects.equals(this.value, databackupDetailsDTO.value) &&
        Objects.equals(this.count, databackupDetailsDTO.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DatabackupDetailsDTO {\n");
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

