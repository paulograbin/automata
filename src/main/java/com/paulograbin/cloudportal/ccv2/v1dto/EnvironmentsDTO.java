package com.paulograbin.cloudportal.ccv2.v1dto;

import java.util.List;


public class EnvironmentsDTO {

    List<EnvironmentDTO> value = null;


    public EnvironmentsDTO(List<EnvironmentDTO> environments) {
        this.value = environments;
    }

    public List<EnvironmentDTO> getEnvironments() {
        return value;
    }

    public void setEnvironments(List<EnvironmentDTO> environments) {
        this.value = environments;
    }

    @Override
    public String toString() {
        return "EnvironmentsDTO{" +
                "environments=" + value +
                '}';
    }
}
