package com.paulograbin.cloudportal.ccv2.v1dto;

public class EnvironmentDTO {

    private String timezone;
    private String code;
    private String name;
    private String description;
    private String status;
    private String type;
    private String dynatraceUrl;
    private String cloudPortalDeepLink;
    private String externalId;
    private String subscriptionCode;


    public EnvironmentDTO() {
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDynatraceUrl() {
        return dynatraceUrl;
    }

    public void setDynatraceUrl(String dynatraceUrl) {
        this.dynatraceUrl = dynatraceUrl;
    }

    public String getCloudPortalDeepLink() {
        return cloudPortalDeepLink;
    }

    public void setCloudPortalDeepLink(String cloudPortalDeepLink) {
        this.cloudPortalDeepLink = cloudPortalDeepLink;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

    public void setSubscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
    }

    @Override
    public String toString() {
        return "EnvironmentDTO{" +
                "timezone='" + timezone + '\'' +
                ", code='" + code + '\'' +
                ", nome='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
