package com.paulograbin.cloudportal.ccv2;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentUserDTO {

    private Value value;

    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CurrentUserDTO{" +
                "value=" + value +
                '}';
    }
}

class Value {

    private String firstName;
    private String surname;
    private String username;
    private String email;

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String value) {
        this.firstName = value;
    }

    @JsonProperty("surname")
    public String getSurname() {
        return surname;
    }

    @JsonProperty("surname")
    public void setSurname(String value) {
        this.surname = value;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String value) {
        this.username = value;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String value) {
        this.email = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}