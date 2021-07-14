package com.jforce.lms.jwt;

import java.util.Set;

public class JwtResponse {
    private String token;
    private Long id;
    private String username;
    private Set<String> authorities;

    public JwtResponse(String token,
                       Long id,
                       String username,
                       Set<String> authorities) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

}