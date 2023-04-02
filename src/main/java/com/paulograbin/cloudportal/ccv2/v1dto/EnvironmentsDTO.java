package com.paulograbin.cloudportal.ccv2.v1dto;

import java.util.List;


public class EnvironmentsDTO {

    List<EnvironmentDTO> value = null;


    public List<EnvironmentDTO> getValue() {
        return value;
    }

    public void setValue(List<EnvironmentDTO> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "EnvironmentsDTO{" +
                "environments=" + value +
                '}';
    }
}
