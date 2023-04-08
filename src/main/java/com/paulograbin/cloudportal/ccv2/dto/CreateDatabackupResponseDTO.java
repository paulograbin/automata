package com.paulograbin.cloudportal.ccv2.dto;

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
 * Create databackup response
 */

@Schema(name = "CreateDatabackupResponseDTO", description = "Create databackup response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDatabackupResponseDTO {

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("environmentCode")
  private String environmentCode;

  @JsonProperty("databackupCode")
  private String databackupCode;

  public CreateDatabackupResponseDTO subscriptionCode(String subscriptionCode) {
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

  public CreateDatabackupResponseDTO environmentCode(String environmentCode) {
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

  public CreateDatabackupResponseDTO databackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
    return this;
  }

  /**
   * Databackup code
   * @return databackupCode
  */
  @NotNull 
  @Schema(name = "databackupCode", description = "Databackup code", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDatabackupCode() {
    return databackupCode;
  }

  public void setDatabackupCode(String databackupCode) {
    this.databackupCode = databackupCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDatabackupResponseDTO createDatabackupResponseDTO = (CreateDatabackupResponseDTO) o;
    return Objects.equals(this.subscriptionCode, createDatabackupResponseDTO.subscriptionCode) &&
        Objects.equals(this.environmentCode, createDatabackupResponseDTO.environmentCode) &&
        Objects.equals(this.databackupCode, createDatabackupResponseDTO.databackupCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionCode, environmentCode, databackupCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDatabackupResponseDTO {\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    environmentCode: ").append(toIndentedString(environmentCode)).append("\n");
    sb.append("    databackupCode: ").append(toIndentedString(databackupCode)).append("\n");
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

