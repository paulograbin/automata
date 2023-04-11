package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Deployment decisions ENUM
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public enum DeploymentDecision {
  
  ACCEPT("ACCEPT"),
  
  REJECT("REJECT"),
  
  PREPARE_CANARY("PREPARE_CANARY");

  private String value;

  DeploymentDecision(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static DeploymentDecision fromValue(String value) {
    for (DeploymentDecision b : DeploymentDecision.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

