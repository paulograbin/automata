package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity to represent a property used by a service into an environment
 */

@Schema(name = "ServicePropertyDTO", description = "Entity to represent a property used by a service into an environment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class ServicePropertyDTO {

  @JsonProperty("key")
  private String key;

  @JsonProperty("value")
  private Object value;

  @JsonProperty("flags")
  @Valid
  private List<String> flags = null;

  public ServicePropertyDTO key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Property name
   * @return key
  */
  @NotNull 
  @Schema(name = "key", description = "Property name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public ServicePropertyDTO value(Object value) {
    this.value = value;
    return this;
  }

  /**
   * Property value
   * @return value
  */
  @NotNull 
  @Schema(name = "value", description = "Property value", requiredMode = Schema.RequiredMode.REQUIRED)
  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public ServicePropertyDTO flags(List<String> flags) {
    this.flags = flags;
    return this;
  }

  public ServicePropertyDTO addFlagsItem(String flagsItem) {
    if (this.flags == null) {
      this.flags = new ArrayList<>();
    }
    this.flags.add(flagsItem);
    return this;
  }

  /**
   * Array of build details
   * @return flags
  */
  
  @Schema(name = "flags", description = "Array of build details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<String> getFlags() {
    return flags;
  }

  public void setFlags(List<String> flags) {
    this.flags = flags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServicePropertyDTO servicePropertyDTO = (ServicePropertyDTO) o;
    return Objects.equals(this.key, servicePropertyDTO.key) &&
        Objects.equals(this.value, servicePropertyDTO.value) &&
        Objects.equals(this.flags, servicePropertyDTO.flags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value, flags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServicePropertyDTO {\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
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

