package com.paulograbin.cloudportal.ccv2.v1dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomersDTO {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("customerId")
    @Expose
    private String customerId;
    @SerializedName("cloudPortalDeepLink")
    @Expose
    private String cloudPortalDeepLink;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCloudPortalDeepLink() {
        return cloudPortalDeepLink;
    }

    public void setCloudPortalDeepLink(String cloudPortalDeepLink) {
        this.cloudPortalDeepLink = cloudPortalDeepLink;
    }

    @Override
    public String toString() {
        return "CustomersDTO{" +
                "cloudPortalDeepLink='" + cloudPortalDeepLink + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}

