package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Create datarestore response
 */

@Schema(name = "CreateDatarestoreResponseDTO", description = "Create datarestore response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDatarestoreResponseDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("environmentCode")
  private String environmentCode;

  @JsonProperty("datarestoreCode")
  private String datarestoreCode;

  public CreateDatarestoreResponseDTO subscriptionCode(String subscriptionCode) {
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

  public CreateDatarestoreResponseDTO environmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
    return this;
  }

  /**
   * Code of the environment
   * @return environmentCode
  */
  
  @Schema(name = "environmentCode", description = "Code of the environment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getEnvironmentCode() {
    return environmentCode;
  }

  public void setEnvironmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
  }

  public CreateDatarestoreResponseDTO datarestoreCode(String datarestoreCode) {
    this.datarestoreCode = datarestoreCode;
    return this;
  }

  /**
   * Datarestore code
   * @return datarestoreCode
  */
  @NotNull 
  @Schema(name = "datarestoreCode", description = "Datarestore code", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDatarestoreCode() {
    return datarestoreCode;
  }

  public void setDatarestoreCode(String datarestoreCode) {
    this.datarestoreCode = datarestoreCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDatarestoreResponseDTO createDatarestoreResponseDTO = (CreateDatarestoreResponseDTO) o;
    return Objects.equals(this.subscriptionCode, createDatarestoreResponseDTO.subscriptionCode) &&
        Objects.equals(this.environmentCode, createDatarestoreResponseDTO.environmentCode) &&
        Objects.equals(this.datarestoreCode, createDatarestoreResponseDTO.datarestoreCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, environmentCode, datarestoreCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDatarestoreResponseDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    environmentCode: ").append(toIndentedString(environmentCode)).append("\n");
    sb.append("    datarestoreCode: ").append(toIndentedString(datarestoreCode)).append("\n");
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

