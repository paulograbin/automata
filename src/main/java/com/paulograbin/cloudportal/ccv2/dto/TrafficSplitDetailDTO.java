package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.cloudportal.ccv2.dto.TrafficPercentageDTO;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Traffic Split detail DTO.
 */

@Schema(name = "TrafficSplitDetailDTO", description = "Traffic Split detail DTO.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class TrafficSplitDetailDTO {

  @JsonProperty("services")
  @Valid
  private List<TrafficPercentageDTO> services = null;

  @JsonProperty("endpoints")
  @Valid
  private List<TrafficPercentageDTO> endpoints = null;

  @JsonProperty("lastModifiedTimestamp")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime lastModifiedTimestamp;

  @JsonProperty("lastModifiedBy")
  private String lastModifiedBy;

  @JsonProperty("subscriptionCode")
  private String subscriptionCode;

  @JsonProperty("deploymentCode")
  private String deploymentCode;

  @JsonProperty("code")
  private String code;

  public TrafficSplitDetailDTO services(List<TrafficPercentageDTO> services) {
    this.services = services;
    return this;
  }

  public TrafficSplitDetailDTO addServicesItem(TrafficPercentageDTO servicesItem) {
    if (this.services == null) {
      this.services = new ArrayList<>();
    }
    this.services.add(servicesItem);
    return this;
  }

  /**
   * Traffic Split for services
   * @return services
  */
  @Valid 
  @Schema(name = "services", description = "Traffic Split for services", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<TrafficPercentageDTO> getServices() {
    return services;
  }

  public void setServices(List<TrafficPercentageDTO> services) {
    this.services = services;
  }

  public TrafficSplitDetailDTO endpoints(List<TrafficPercentageDTO> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public TrafficSplitDetailDTO addEndpointsItem(TrafficPercentageDTO endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

  /**
   * Get endpoints
   * @return endpoints
  */
  @Valid 
  @Schema(name = "endpoints", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<TrafficPercentageDTO> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<TrafficPercentageDTO> endpoints) {
    this.endpoints = endpoints;
  }

  public TrafficSplitDetailDTO lastModifiedTimestamp(OffsetDateTime lastModifiedTimestamp) {
    this.lastModifiedTimestamp = lastModifiedTimestamp;
    return this;
  }

  /**
   * last Modified Timestamp
   * @return lastModifiedTimestamp
  */
  @Valid 
  @Schema(name = "lastModifiedTimestamp", description = "last Modified Timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public OffsetDateTime getLastModifiedTimestamp() {
    return lastModifiedTimestamp;
  }

  public void setLastModifiedTimestamp(OffsetDateTime lastModifiedTimestamp) {
    this.lastModifiedTimestamp = lastModifiedTimestamp;
  }

  public TrafficSplitDetailDTO lastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
    return this;
  }

  /**
   * last Modified user
   * @return lastModifiedBy
  */
  
  @Schema(name = "lastModifiedBy", description = "last Modified user", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }

  public TrafficSplitDetailDTO subscriptionCode(String subscriptionCode) {
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

  public TrafficSplitDetailDTO deploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
    return this;
  }

  /**
   * Code of the deployment
   * @return deploymentCode
  */
  @NotNull 
  @Schema(name = "deploymentCode", description = "Code of the deployment", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getDeploymentCode() {
    return deploymentCode;
  }

  public void setDeploymentCode(String deploymentCode) {
    this.deploymentCode = deploymentCode;
  }

  public TrafficSplitDetailDTO code(String code) {
    this.code = code;
    return this;
  }

  /**
   * unique code of traffic split
   * @return code
  */
  
  @Schema(name = "code", description = "unique code of traffic split", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    TrafficSplitDetailDTO trafficSplitDetailDTO = (TrafficSplitDetailDTO) o;
    return Objects.equals(this.services, trafficSplitDetailDTO.services) &&
        Objects.equals(this.endpoints, trafficSplitDetailDTO.endpoints) &&
        Objects.equals(this.lastModifiedTimestamp, trafficSplitDetailDTO.lastModifiedTimestamp) &&
        Objects.equals(this.lastModifiedBy, trafficSplitDetailDTO.lastModifiedBy) &&
        Objects.equals(this.subscriptionCode, trafficSplitDetailDTO.subscriptionCode) &&
        Objects.equals(this.deploymentCode, trafficSplitDetailDTO.deploymentCode) &&
        Objects.equals(this.code, trafficSplitDetailDTO.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services, endpoints, lastModifiedTimestamp, lastModifiedBy, subscriptionCode, deploymentCode, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrafficSplitDetailDTO {\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
    sb.append("    lastModifiedTimestamp: ").append(toIndentedString(lastModifiedTimestamp)).append("\n");
    sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");
    sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
    sb.append("    deploymentCode: ").append(toIndentedString(deploymentCode)).append("\n");
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

