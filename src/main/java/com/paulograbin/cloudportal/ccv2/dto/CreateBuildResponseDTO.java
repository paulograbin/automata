package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Create build response
 */

@Schema(name = "CreateBuildResponseDTO", description = "Create build response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateBuildResponseDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("code")
  private String code;

  public CreateBuildResponseDTO subscriptionCode(String subscriptionCode) {
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

  public CreateBuildResponseDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Build code
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "Build code", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateBuildResponseDTO createBuildResponseDTO = (CreateBuildResponseDTO) o;
    return Objects.equals(this.subscriptionCode, createBuildResponseDTO.subscriptionCode) &&
        Objects.equals(this.code, createBuildResponseDTO.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateBuildResponseDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

