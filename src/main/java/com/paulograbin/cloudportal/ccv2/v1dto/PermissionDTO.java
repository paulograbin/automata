package com.paulograbin.cloudportal.ccv2.v1dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PermissionDTO {
    private String scopeName;
    private List<String> permissions;
    private List<String> environments;

    @JsonProperty("scopeName")
    public String getScopeName() { return scopeName; }
    @JsonProperty("scopeName")
    public void setScopeName(String value) { this.scopeName = value; }

    @JsonProperty("permissions")
    public List<String> getPermissions() { return permissions; }
    @JsonProperty("permissions")
    public void setPermissions(List<String> value) { this.permissions = value; }

    @JsonProperty("environments")
    public List<String> getEnvironments() { return environments; }
    @JsonProperty("environments")
    public void setEnvironments(List<String> value) { this.environments = value; }
}