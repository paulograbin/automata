package com.paulograbin.cloudportal.web;


public class AutomataConfiguration {

    private String authenticationToken = "";
    private String subscriptionCode = "";
    private String ntfyTopic = "";


    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public String getSubscriptionCode() {
        return subscriptionCode;
    }

    public void setSubscriptionCode(String subscriptionCode) {
        this.subscriptionCode = subscriptionCode;
    }

    public String getNtfyTopic() {
        return ntfyTopic;
    }

    public void setNtfyTopic(String ntfyTopic) {
        this.ntfyTopic = ntfyTopic;
    }
}
