package com.paulograbin.cloudportal.web;

public class NewBuildRequest {

    private String branchName;
    private String environmentCode;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
    }

    @Override
    public String toString() {
        return "NewBuildRequest{" +
                "branchName='" + branchName + '\'' +
                ", environmentCode='" + environmentCode + '\'' +
                '}';
    }
}
