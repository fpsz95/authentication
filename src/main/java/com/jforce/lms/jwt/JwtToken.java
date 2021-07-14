package com.jforce.lms.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
