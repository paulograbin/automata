package com.paulograbin.cloudportal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class AutomataDeploymentDetailsDTO {

    @JsonProperty("value")
    @Valid
    private List<AutomataDeploymentDetailDTO> value = null;

    @JsonProperty("count")
    private Integer count;

    public AutomataDeploymentDetailsDTO value(List<AutomataDeploymentDetailDTO> value) {
        this.value = value;
        return this;
    }

    public AutomataDeploymentDetailsDTO addValueItem(AutomataDeploymentDetailDTO valueItem) {
        if (this.value == null) {
            this.value = new ArrayList<>();
        }
        this.value.add(valueItem);
        return this;
    }


    @Valid
    public List<AutomataDeploymentDetailDTO> getValue() {
        return value;
    }

    public void setValue(List<AutomataDeploymentDetailDTO> value) {
        this.value = value;
    }

    public AutomataDeploymentDetailsDTO count(Integer count) {
        this.count = count;
        return this;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AutomataDeploymentDetailsDTO deploymentDetailsDTO = (AutomataDeploymentDetailsDTO) o;
        return Objects.equals(this.value, deploymentDetailsDTO.value) &&
                Objects.equals(this.count, deploymentDetailsDTO.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentDetailsDTO {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

