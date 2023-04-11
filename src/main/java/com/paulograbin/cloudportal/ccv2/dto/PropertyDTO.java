package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * Property key and value pair
 */

@Schema(name = "PropertyDTO", description = "Property key and value pair")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class PropertyDTO {

  @JsonProperty("key")
  private String key;

  @JsonProperty("value")
  private String value;

  public PropertyDTO key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Property key
   * @return key
  */
  
  @Schema(name = "key", description = "Property key", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public PropertyDTO value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Property value
   * @return value
  */
  
  @Schema(name = "value", description = "Property value", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PropertyDTO propertyDTO = (PropertyDTO) o;
    return Objects.equals(this.key, propertyDTO.key) &&
        Objects.equals(this.value, propertyDTO.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PropertyDTO {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

