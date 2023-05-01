package com.paulograbin.cloudportal.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentCancelationDetailDTO;
import com.paulograbin.cloudportal.ccv2.dto.DeploymentTrafficSplitDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;


public class AutomataDeploymentDetailDTO {

    @JsonProperty("code")
    private String code;

    @JsonProperty("percentage")
    private Integer percentage;

    @JsonProperty("subscriptionCode")
    private String subscriptionCode;

    @JsonProperty("createdBy")
    private String createdBy;

    @JsonProperty("createdTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdTimestamp;

    @JsonProperty("buildCode")
    private String buildCode;

    @JsonProperty("environmentCode")
    private String environmentCode;

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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @JsonProperty("strategy")
    private StrategyEnum strategy;

    @JsonProperty("scheduledTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime scheduledTimestamp;

    @JsonProperty("deployedTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime deployedTimestamp;

    @JsonProperty("failedTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime failedTimestamp;

    @JsonProperty("undeployedTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime undeployedTimestamp;

    @JsonProperty("status")
    private String status;

    @JsonProperty("canceledBy")
    private String canceledBy;

    @JsonProperty("canceledTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime canceledTimestamp;

    @JsonProperty("cancellationFinishedTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime cancellationFinishedTimestamp;

    @JsonProperty("cancellationFailed")
    private Boolean cancellationFailed;

    @JsonProperty("cancelation")
    private DeploymentCancelationDetailDTO cancelation;

    @JsonProperty("isCanaryAvailable")
    private Boolean isCanaryAvailable;

    @JsonProperty("previousDeploymentCode")
    private String previousDeploymentCode;

    @JsonProperty("expireAtTimestamp")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime expireAtTimestamp;

    public enum CanaryStatusEnum {
        STARTED("STARTED"),
        SUCCEEDED("SUCCEEDED"),
        FAILED("FAILED");

        private String value;

        CanaryStatusEnum(String value) {
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
        public static CanaryStatusEnum fromValue(String value) {
            for (CanaryStatusEnum b : CanaryStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("canaryStatus")
    private CanaryStatusEnum canaryStatus;

    @JsonProperty("trafficSplit")
    private DeploymentTrafficSplitDTO trafficSplit;

    public AutomataDeploymentDetailDTO code(String code) {
        this.code = code;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AutomataDeploymentDetailDTO subscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
        return this;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

    public void setSubscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
    }

    public AutomataDeploymentDetailDTO createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public AutomataDeploymentDetailDTO createdTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }

    @Valid
    public OffsetDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(OffsetDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public AutomataDeploymentDetailDTO buildCode(String buildCode) {
        this.buildCode = buildCode;
        return this;
    }

    /**
     * Code of the deployed build
     *
     * @return buildCode
     */

    public String getBuildCode() {
        return buildCode;
    }

    public void setBuildCode(String buildCode) {
        this.buildCode = buildCode;
    }

    public AutomataDeploymentDetailDTO environmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
        return this;
    }

    /**
     * Code of the environment where the build will be deployed to
     *
     * @return environmentCode
     */

    public String getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
    }

    public AutomataDeploymentDetailDTO databaseUpdateMode(DatabaseUpdateModeEnum databaseUpdateMode) {
        this.databaseUpdateMode = databaseUpdateMode;
        return this;
    }

    /**
     * Database action used in the deployment
     *
     * @return databaseUpdateMode
     */

    @Schema(name = "databaseUpdateMode", description = "Database action used in the deployment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public DatabaseUpdateModeEnum getDatabaseUpdateMode() {
        return databaseUpdateMode;
    }

    public void setDatabaseUpdateMode(DatabaseUpdateModeEnum databaseUpdateMode) {
        this.databaseUpdateMode = databaseUpdateMode;
    }

    public AutomataDeploymentDetailDTO strategy(StrategyEnum strategy) {
        this.strategy = strategy;
        return this;
    }

    /**
     * Strategy for the deployment. Could be rolling-update or re-create
     *
     * @return strategy
     */

    @Schema(name = "strategy", description = "Strategy for the deployment. Could be rolling-update or re-create", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public StrategyEnum getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyEnum strategy) {
        this.strategy = strategy;
    }

    public AutomataDeploymentDetailDTO scheduledTimestamp(OffsetDateTime scheduledTimestamp) {
        this.scheduledTimestamp = scheduledTimestamp;
        return this;
    }

    /**
     * Time the deployment is scheduled for. If not provided current timestamp is used.
     *
     * @return scheduledTimestamp
     */
    @Valid
    @Schema(name = "scheduledTimestamp", description = "Time the deployment is scheduled for. If not provided current timestamp is used.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getScheduledTimestamp() {
        return scheduledTimestamp;
    }

    public void setScheduledTimestamp(OffsetDateTime scheduledTimestamp) {
        this.scheduledTimestamp = scheduledTimestamp;
    }

    public AutomataDeploymentDetailDTO deployedTimestamp(OffsetDateTime deployedTimestamp) {
        this.deployedTimestamp = deployedTimestamp;
        return this;
    }

    /**
     * Time the deployment was successful
     *
     * @return deployedTimestamp
     */
    @Valid
    @Schema(name = "deployedTimestamp", description = "Time the deployment was successful", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getDeployedTimestamp() {
        return deployedTimestamp;
    }

    public void setDeployedTimestamp(OffsetDateTime deployedTimestamp) {
        this.deployedTimestamp = deployedTimestamp;
    }

    public AutomataDeploymentDetailDTO failedTimestamp(OffsetDateTime failedTimestamp) {
        this.failedTimestamp = failedTimestamp;
        return this;
    }

    /**
     * Time the deployment failed
     *
     * @return failedTimestamp
     */
    @Valid
    @Schema(name = "failedTimestamp", description = "Time the deployment failed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getFailedTimestamp() {
        return failedTimestamp;
    }

    public void setFailedTimestamp(OffsetDateTime failedTimestamp) {
        this.failedTimestamp = failedTimestamp;
    }

    public AutomataDeploymentDetailDTO undeployedTimestamp(OffsetDateTime undeployedTimestamp) {
        this.undeployedTimestamp = undeployedTimestamp;
        return this;
    }

    /**
     * Time the deployment was un-deployed and replaced
     *
     * @return undeployedTimestamp
     */
    @Valid
    @Schema(name = "undeployedTimestamp", description = "Time the deployment was un-deployed and replaced", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getUndeployedTimestamp() {
        return undeployedTimestamp;
    }

    public void setUndeployedTimestamp(OffsetDateTime undeployedTimestamp) {
        this.undeployedTimestamp = undeployedTimestamp;
    }

    public AutomataDeploymentDetailDTO status(String status) {
        this.status = status;
        return this;
    }

    @Schema(name = "status", description = "Status of the deployment, possible values are \"SCHEDULED\",\"DEPLOYING\",\"DEPLOYED\",\"UNDEPLOYED\" or \"FAIL\"", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AutomataDeploymentDetailDTO canceledBy(String canceledBy) {
        this.canceledBy = canceledBy;
        return this;
    }

    @Schema(name = "canceledBy", description = "User that canceled the deployment. This property was moved under `cancelation`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public String getCanceledBy() {
        return canceledBy;
    }

    public void setCanceledBy(String canceledBy) {
        this.canceledBy = canceledBy;
    }

    public AutomataDeploymentDetailDTO canceledTimestamp(OffsetDateTime canceledTimestamp) {
        this.canceledTimestamp = canceledTimestamp;
        return this;
    }


    @Valid
    @Schema(name = "canceledTimestamp", description = "Time the cancelation was requested. This property was moved under `cancelation`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getCanceledTimestamp() {
        return canceledTimestamp;
    }

    public void setCanceledTimestamp(OffsetDateTime canceledTimestamp) {
        this.canceledTimestamp = canceledTimestamp;
    }

    public AutomataDeploymentDetailDTO cancellationFinishedTimestamp(OffsetDateTime cancellationFinishedTimestamp) {
        this.cancellationFinishedTimestamp = cancellationFinishedTimestamp;
        return this;
    }


    @Valid
    @Schema(name = "cancellationFinishedTimestamp", description = "Time the cancelation finished. This property was moved under `cancelation`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public OffsetDateTime getCancellationFinishedTimestamp() {
        return cancellationFinishedTimestamp;
    }

    public void setCancellationFinishedTimestamp(OffsetDateTime cancellationFinishedTimestamp) {
        this.cancellationFinishedTimestamp = cancellationFinishedTimestamp;
    }

    public AutomataDeploymentDetailDTO cancellationFailed(Boolean cancellationFailed) {
        this.cancellationFailed = cancellationFailed;
        return this;
    }

    @Schema(name = "cancellationFailed", description = "Flag to indicate if the deployment cancelation failed. This property was moved under `cancelation`.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public Boolean getCancellationFailed() {
        return cancellationFailed;
    }

    public void setCancellationFailed(Boolean cancellationFailed) {
        this.cancellationFailed = cancellationFailed;
    }

    public AutomataDeploymentDetailDTO cancelation(DeploymentCancelationDetailDTO cancelation) {
        this.cancelation = cancelation;
        return this;
    }

    @Valid
    @Schema(name = "cancelation", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public DeploymentCancelationDetailDTO getCancelation() {
        return cancelation;
    }

    public void setCancelation(DeploymentCancelationDetailDTO cancelation) {
        this.cancelation = cancelation;
    }

    public AutomataDeploymentDetailDTO isCanaryAvailable(Boolean isCanaryAvailable) {
        this.isCanaryAvailable = isCanaryAvailable;
        return this;
    }

    @Schema(name = "isCanaryAvailable", description = "true if canary is available", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public Boolean getIsCanaryAvailable() {
        return isCanaryAvailable;
    }

    public void setIsCanaryAvailable(Boolean isCanaryAvailable) {
        this.isCanaryAvailable = isCanaryAvailable;
    }

    public AutomataDeploymentDetailDTO previousDeploymentCode(String previousDeploymentCode) {
        this.previousDeploymentCode = previousDeploymentCode;
        return this;
    }

    @Schema(name = "previousDeploymentCode", description = "Code of the previous deployment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public String getPreviousDeploymentCode() {
        return previousDeploymentCode;
    }

    public void setPreviousDeploymentCode(String previousDeploymentCode) {
        this.previousDeploymentCode = previousDeploymentCode;
    }

    public AutomataDeploymentDetailDTO expireAtTimestamp(OffsetDateTime expireAtTimestamp) {
        this.expireAtTimestamp = expireAtTimestamp;
        return this;
    }

    @Valid
    public OffsetDateTime getExpireAtTimestamp() {
        return expireAtTimestamp;
    }

    public void setExpireAtTimestamp(OffsetDateTime expireAtTimestamp) {
        this.expireAtTimestamp = expireAtTimestamp;
    }

    public AutomataDeploymentDetailDTO canaryStatus(CanaryStatusEnum canaryStatus) {
        this.canaryStatus = canaryStatus;
        return this;
    }

    /**
     * Deployment Canary status
     *
     * @return canaryStatus
     */

    public CanaryStatusEnum getCanaryStatus() {
        return canaryStatus;
    }

    public void setCanaryStatus(CanaryStatusEnum canaryStatus) {
        this.canaryStatus = canaryStatus;
    }

    public AutomataDeploymentDetailDTO trafficSplit(DeploymentTrafficSplitDTO trafficSplit) {
        this.trafficSplit = trafficSplit;
        return this;
    }

    @Valid
    public DeploymentTrafficSplitDTO getTrafficSplit() {
        return trafficSplit;
    }

    public void setTrafficSplit(DeploymentTrafficSplitDTO trafficSplit) {
        this.trafficSplit = trafficSplit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AutomataDeploymentDetailDTO deploymentDetailDTO = (AutomataDeploymentDetailDTO) o;
        return Objects.equals(this.code, deploymentDetailDTO.code) &&
                Objects.equals(this.subscriptionCode, deploymentDetailDTO.subscriptionCode) &&
                Objects.equals(this.createdBy, deploymentDetailDTO.createdBy) &&
                Objects.equals(this.createdTimestamp, deploymentDetailDTO.createdTimestamp) &&
                Objects.equals(this.buildCode, deploymentDetailDTO.buildCode) &&
                Objects.equals(this.environmentCode, deploymentDetailDTO.environmentCode) &&
                Objects.equals(this.databaseUpdateMode, deploymentDetailDTO.databaseUpdateMode) &&
                Objects.equals(this.strategy, deploymentDetailDTO.strategy) &&
                Objects.equals(this.scheduledTimestamp, deploymentDetailDTO.scheduledTimestamp) &&
                Objects.equals(this.deployedTimestamp, deploymentDetailDTO.deployedTimestamp) &&
                Objects.equals(this.failedTimestamp, deploymentDetailDTO.failedTimestamp) &&
                Objects.equals(this.undeployedTimestamp, deploymentDetailDTO.undeployedTimestamp) &&
                Objects.equals(this.status, deploymentDetailDTO.status) &&
                Objects.equals(this.canceledBy, deploymentDetailDTO.canceledBy) &&
                Objects.equals(this.canceledTimestamp, deploymentDetailDTO.canceledTimestamp) &&
                Objects.equals(this.cancellationFinishedTimestamp, deploymentDetailDTO.cancellationFinishedTimestamp) &&
                Objects.equals(this.cancellationFailed, deploymentDetailDTO.cancellationFailed) &&
                Objects.equals(this.cancelation, deploymentDetailDTO.cancelation) &&
                Objects.equals(this.isCanaryAvailable, deploymentDetailDTO.isCanaryAvailable) &&
                Objects.equals(this.previousDeploymentCode, deploymentDetailDTO.previousDeploymentCode) &&
                Objects.equals(this.expireAtTimestamp, deploymentDetailDTO.expireAtTimestamp) &&
                Objects.equals(this.canaryStatus, deploymentDetailDTO.canaryStatus) &&
                Objects.equals(this.trafficSplit, deploymentDetailDTO.trafficSplit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, subscriptionCode, createdBy, createdTimestamp, buildCode, environmentCode, databaseUpdateMode, strategy, scheduledTimestamp, deployedTimestamp, failedTimestamp, undeployedTimestamp, status, canceledBy, canceledTimestamp, cancellationFinishedTimestamp, cancellationFailed, cancelation, isCanaryAvailable, previousDeploymentCode, expireAtTimestamp, canaryStatus, trafficSplit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentDetailDTO {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    subscriptionCode: ").append(toIndentedString(subscriptionCode)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdTimestamp: ").append(toIndentedString(createdTimestamp)).append("\n");
        sb.append("    buildCode: ").append(toIndentedString(buildCode)).append("\n");
        sb.append("    environmentCode: ").append(toIndentedString(environmentCode)).append("\n");
        sb.append("    databaseUpdateMode: ").append(toIndentedString(databaseUpdateMode)).append("\n");
        sb.append("    strategy: ").append(toIndentedString(strategy)).append("\n");
        sb.append("    scheduledTimestamp: ").append(toIndentedString(scheduledTimestamp)).append("\n");
        sb.append("    deployedTimestamp: ").append(toIndentedString(deployedTimestamp)).append("\n");
        sb.append("    failedTimestamp: ").append(toIndentedString(failedTimestamp)).append("\n");
        sb.append("    undeployedTimestamp: ").append(toIndentedString(undeployedTimestamp)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    canceledBy: ").append(toIndentedString(canceledBy)).append("\n");
        sb.append("    canceledTimestamp: ").append(toIndentedString(canceledTimestamp)).append("\n");
        sb.append("    cancellationFinishedTimestamp: ").append(toIndentedString(cancellationFinishedTimestamp)).append("\n");
        sb.append("    cancellationFailed: ").append(toIndentedString(cancellationFailed)).append("\n");
        sb.append("    cancelation: ").append(toIndentedString(cancelation)).append("\n");
        sb.append("    isCanaryAvailable: ").append(toIndentedString(isCanaryAvailable)).append("\n");
        sb.append("    previousDeploymentCode: ").append(toIndentedString(previousDeploymentCode)).append("\n");
        sb.append("    expireAtTimestamp: ").append(toIndentedString(expireAtTimestamp)).append("\n");
        sb.append("    canaryStatus: ").append(toIndentedString(canaryStatus)).append("\n");
        sb.append("    trafficSplit: ").append(toIndentedString(trafficSplit)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

