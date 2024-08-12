package com.paulograbin.cloudportal.ccv2.v1dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username", "permissionDTOS"})
public class PermissionDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String toString() {
        return "PermissionDTO{" +
                ", username='" + username + '\'' +
                '}';
    }
}