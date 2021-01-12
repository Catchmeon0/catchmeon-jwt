package com.catchmeon.catchmeonjwt.models;

public class AuthenticationResponse {
    private final String jwt;
    private final String username;
    private final String email;
    private final String id;

    public AuthenticationResponse(String jwt, UserCMO userCMO) {
        this.jwt = jwt;
        this.username= userCMO.getUsername();
        this.email = userCMO.getEmail();
        this.id= userCMO.getId();
    }

    public String getJwt() {
        return jwt;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
