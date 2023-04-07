package com.paulograbin.cloudportal.ccv2.v1dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomersDTO {

    private String code;
    private String name;
    private String customerID;
    private String cloudPortalDeepLink;

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String value) { this.code = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("customerId")
    public String getCustomerID() { return customerID; }
    @JsonProperty("customerId")
    public void setCustomerID(String value) { this.customerID = value; }

    @JsonProperty("cloudPortalDeepLink")
    public String getCloudPortalDeepLink() { return cloudPortalDeepLink; }
    @JsonProperty("cloudPortalDeepLink")
    public void setCloudPortalDeepLink(String value) { this.cloudPortalDeepLink = value; }
}

