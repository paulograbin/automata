package com.paulograbin.ccv2api.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.paulograbin.ccv2api.model.TrafficPercentageRequestDTO;
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
 * Update Traffic Split request.
 */

@Schema(name = "UpdateTrafficSplitRequestDTO", description = "Update Traffic Split request.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class UpdateTrafficSplitRequestDTO {

  @JsonProperty("services")
  @Valid
  private List<TrafficPercentageRequestDTO> services = null;

  @JsonProperty("endpoints")
  @Valid
  private List<TrafficPercentageRequestDTO> endpoints = null;

  public UpdateTrafficSplitRequestDTO services(List<TrafficPercentageRequestDTO> services) {
    this.services = services;
    return this;
  }

  public UpdateTrafficSplitRequestDTO addServicesItem(TrafficPercentageRequestDTO servicesItem) {
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
  public List<TrafficPercentageRequestDTO> getServices() {
    return services;
  }

  public void setServices(List<TrafficPercentageRequestDTO> services) {
    this.services = services;
  }

  public UpdateTrafficSplitRequestDTO endpoints(List<TrafficPercentageRequestDTO> endpoints) {
    this.endpoints = endpoints;
    return this;
  }

  public UpdateTrafficSplitRequestDTO addEndpointsItem(TrafficPercentageRequestDTO endpointsItem) {
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
  public List<TrafficPercentageRequestDTO> getEndpoints() {
    return endpoints;
  }

  public void setEndpoints(List<TrafficPercentageRequestDTO> endpoints) {
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
    UpdateTrafficSplitRequestDTO updateTrafficSplitRequestDTO = (UpdateTrafficSplitRequestDTO) o;
    return Objects.equals(this.services, updateTrafficSplitRequestDTO.services) &&
        Objects.equals(this.endpoints, updateTrafficSplitRequestDTO.endpoints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(services, endpoints);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTrafficSplitRequestDTO {\n");
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

