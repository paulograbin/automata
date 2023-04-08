package com.paulograbin.cloudportal.ccv2.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Entity to be used to start a new deployment
 */

@Schema(name = "CreateDeploymentRequestDTO", description = "Entity to be used to start a new deployment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class CreateDeploymentRequestDTO {

  @JsonProperty("buildCode")
  private String buildCode;

  @JsonProperty("environmentCode")
  private String environmentCode;

  /**
   * Database action used in the deployment
   */
  public enum DatabaseUpdateModeEnum {
    NONE("NONE"),
    
    UPDATE("UPDATE"),
    
    INITIALIZE("INITIALIZE");

    private String value;

    DatabaseUpdateModeEnum(String value) {
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
    public static DatabaseUpdateModeEnum fromValue(String value) {
      for (DatabaseUpdateModeEnum b : DatabaseUpdateModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("databaseUpdateMode")
  private DatabaseUpdateModeEnum databaseUpdateMode;

  /**
   * Strategy for the deployment. Could be rolling-update or re-create
   */
  public enum StrategyEnum {
    ROLLING_UPDATE("ROLLING_UPDATE"),
    
    RECREATE("RECREATE"),
    
    GREEN("GREEN");

    private String value;

    StrategyEnum(String value) {
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
    public static StrategyEnum fromValue(String value) {
      for (StrategyEnum b : StrategyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("strategy")
  private StrategyEnum strategy;

  public CreateDeploymentRequestDTO buildCode(String buildCode) {
    this.buildCode = buildCode;
    return this;
  }

  /**
   * Code of the build to be deployed
   * @return buildCode
  */
  @NotNull 
  @Schema(name = "buildCode", description = "Code of the build to be deployed", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getBuildCode() {
    return buildCode;
  }

  public void setBuildCode(String buildCode) {
    this.buildCode = buildCode;
  }

  public CreateDeploymentRequestDTO environmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
    return this;
  }

  /**
   * Code of the environment where the build will be deployed to
   * @return environmentCode
  */
  @NotNull 
  @Schema(name = "environmentCode", description = "Code of the environment where the build will be deployed to", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getEnvironmentCode() {
    return environmentCode;
  }

  public void setEnvironmentCode(String environmentCode) {
    this.environmentCode = environmentCode;
  }

  public CreateDeploymentRequestDTO databaseUpdateMode(DatabaseUpdateModeEnum databaseUpdateMode) {
    this.databaseUpdateMode = databaseUpdateMode;
    return this;
  }

  /**
   * Database action used in the deployment
   * @return databaseUpdateMode
  */
  @NotNull 
  @Schema(name = "databaseUpdateMode", description = "Database action used in the deployment", requiredMode = Schema.RequiredMode.REQUIRED)
  public DatabaseUpdateModeEnum getDatabaseUpdateMode() {
    return databaseUpdateMode;
  }

  public void setDatabaseUpdateMode(DatabaseUpdateModeEnum databaseUpdateMode) {
    this.databaseUpdateMode = databaseUpdateMode;
  }

  public CreateDeploymentRequestDTO strategy(StrategyEnum strategy) {
    this.strategy = strategy;
    return this;
  }

  /**
   * Strategy for the deployment. Could be rolling-update or re-create
   * @return strategy
  */
  @NotNull 
  @Schema(name = "strategy", description = "Strategy for the deployment. Could be rolling-update or re-create", requiredMode = Schema.RequiredMode.REQUIRED)
  public StrategyEnum getStrategy() {
    return strategy;
  }

  public void setStrategy(StrategyEnum strategy) {
    this.strategy = strategy;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateDeploymentRequestDTO createDeploymentRequestDTO = (CreateDeploymentRequestDTO) o;
    return Objects.equals(this.buildCode, createDeploymentRequestDTO.buildCode) &&
        Objects.equals(this.environmentCode, createDeploymentRequestDTO.environmentCode) &&
        Objects.equals(this.databaseUpdateMode, createDeploymentRequestDTO.databaseUpdateMode) &&
        Objects.equals(this.strategy, createDeploymentRequestDTO.strategy);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buildCode, environmentCode, databaseUpdateMode, strategy);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateDeploymentRequestDTO {\n");
    sb.append("    buildCode: ").append(toIndentedString(buildCode)).append("\n");
    sb.append("    environmentCode: ").append(toIndentedString(environmentCode)).append("\n");
    sb.append("    databaseUpdateMode: ").append(toIndentedString(databaseUpdateMode)).append("\n");
    sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
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

