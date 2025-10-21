package com.apmaco.login_sample_ahmadvand.model;

public class LoginRequest {
    public String username;
    public String password;

    public String toJson() {
        return "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";
    }
}