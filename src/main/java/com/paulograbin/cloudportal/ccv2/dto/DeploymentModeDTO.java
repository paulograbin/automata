package com.paulograbin.cloudportal.ccv2.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details of a deploymentmodes per environment
 */

@Schema(name = "DeploymentModeDTO", description = "Details of a deploymentmodes per environment")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-01T15:22:33.524558250-03:00[America/Sao_Paulo]")
public class DeploymentModeDTO {

  /**
   * Gets or Sets dataMigrationMode
   */
  public enum DataMigrationModeEnum {
    NONE("NONE"),
    
    UPDATE("UPDATE"),
    
    INITIALIZE("INITIALIZE");

    private String value;

    DataMigrationModeEnum(String value) {
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
    public static DataMigrationModeEnum fromValue(String value) {
      for (DataMigrationModeEnum b : DataMigrationModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("dataMigrationMode")
  @Valid
  private List<DataMigrationModeEnum> dataMigrationMode = null;

  /**
   * Gets or Sets deploymentMode
   */
  public enum DeploymentModeEnum {
    ROLLING_UPDATE("ROLLING_UPDATE"),
    
    RECREATE("RECREATE"),
    
    GREEN("GREEN");

    private String value;

    DeploymentModeEnum(String value) {
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
    public static DeploymentModeEnum fromValue(String value) {
      for (DeploymentModeEnum b : DeploymentModeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("deploymentMode")
  @Valid
  private List<DeploymentModeEnum> deploymentMode = null;

  public DeploymentModeDTO dataMigrationMode(List<DataMigrationModeEnum> dataMigrationMode) {
    this.dataMigrationMode = dataMigrationMode;
    return this;
  }

  public DeploymentModeDTO addDataMigrationModeItem(DataMigrationModeEnum dataMigrationModeItem) {
    if (this.dataMigrationMode == null) {
      this.dataMigrationMode = new ArrayList<>();
    }
    this.dataMigrationMode.add(dataMigrationModeItem);
    return this;
  }

  /**
   * Data migration modes
   * @return dataMigrationMode
  */
  
  @Schema(name = "dataMigrationMode", description = "Data migration modes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DataMigrationModeEnum> getDataMigrationMode() {
    return dataMigrationMode;
  }

  public void setDataMigrationMode(List<DataMigrationModeEnum> dataMigrationMode) {
    this.dataMigrationMode = dataMigrationMode;
  }

  public DeploymentModeDTO deploymentMode(List<DeploymentModeEnum> deploymentMode) {
    this.deploymentMode = deploymentMode;
    return this;
  }

  public DeploymentModeDTO addDeploymentModeItem(DeploymentModeEnum deploymentModeItem) {
    if (this.deploymentMode == null) {
      this.deploymentMode = new ArrayList<>();
    }
    this.deploymentMode.add(deploymentModeItem);
    return this;
  }

  /**
   * deployment modes
   * @return deploymentMode
  */
  
  @Schema(name = "deploymentMode", description = "deployment modes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public List<DeploymentModeEnum> getDeploymentMode() {
    return deploymentMode;
  }

  public void setDeploymentMode(List<DeploymentModeEnum> deploymentMode) {
    this.deploymentMode = deploymentMode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentModeDTO deploymentModeDTO = (DeploymentModeDTO) o;
    return Objects.equals(this.dataMigrationMode, deploymentModeDTO.dataMigrationMode) &&
        Objects.equals(this.deploymentMode, deploymentModeDTO.deploymentMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataMigrationMode, deploymentMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentModeDTO {\n");
    sb.append("    dataMigrationMode: ").append(toIndentedString(dataMigrationMode)).append("\n");
    sb.append("    deploymentMode: ").append(toIndentedString(deploymentMode)).append("\n");
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

