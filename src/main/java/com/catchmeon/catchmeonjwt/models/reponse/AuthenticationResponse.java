package com.catchmeon.catchmeonjwt.models.reponse;

import com.catchmeon.catchmeonjwt.models.UserCMO;

import java.util.HashMap;

public class AuthenticationResponse {
    private final String jwt;
    private final String username;
    private final String email;


    private final String id;
    private final HashMap userIds;

    public AuthenticationResponse(String jwt, UserCMO userCMO) {
        this.jwt = jwt;
        this.username = userCMO.getUsername();
        this.email = userCMO.getEmail();
        this.id = userCMO.getId();
        this.userIds = userCMO.getUserIds();
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

    public HashMap<String,String> getUserIds() {
        return userIds;
    }
}
