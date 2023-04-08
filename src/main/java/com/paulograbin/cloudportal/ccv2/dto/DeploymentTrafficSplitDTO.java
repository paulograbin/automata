package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.cloudportal.ccv2.dto.TrafficPercentageDTO;
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
 * Traffic split DTO for deployment detail.
 */

@Schema(name = "DeploymentTrafficSplitDTO", description = "Traffic split DTO for deployment detail.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentTrafficSplitDTO {

  @JsonProperty("services")
  @Valid
  private List<TrafficPercentageDTO> services = null;

  @JsonProperty("endpoints")
  @Valid
  private List<TrafficPercentageDTO> endpoints = null;

  public DeploymentTrafficSplitDTO services(List<TrafficPercentageDTO> services) {
    this.services = services;
    return this;
  }

  public DeploymentTrafficSplitDTO addServicesItem(TrafficPercentageDTO servicesItem) {
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

  public DeploymentTrafficSplitDTO endpoints(List<TrafficPercentageDTO> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public DeploymentTrafficSplitDTO addEndpointsItem(TrafficPercentageDTO endpointsItem) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList<>();
    }
    this.endpoints.add(endpointsItem);
    return this;
  }

  /**
   * Traffic Split for endpoints
   * @return endpoints
  */
  @Valid 
  @Schema(name = "endpoints", description = "Traffic Split for endpoints", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<TrafficPercentageDTO> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<TrafficPercentageDTO> endpoints) {
    this.endpoints = endpoints;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentTrafficSplitDTO deploymentTrafficSplitDTO = (DeploymentTrafficSplitDTO) o;
    return Objects.equals(this.services, deploymentTrafficSplitDTO.services) &&
        Objects.equals(this.endpoints, deploymentTrafficSplitDTO.endpoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services, endpoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentTrafficSplitDTO {\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    endpoints: ").append(toIndentedString(endpoints)).append("\n");
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

