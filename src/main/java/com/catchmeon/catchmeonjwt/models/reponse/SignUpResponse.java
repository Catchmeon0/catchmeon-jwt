package com.catchmeon.catchmeonjwt.models.reponse;


import java.io.Serializable;

public class SignUpResponse implements Serializable {

    private final String username;
    private final String  id;

    public SignUpResponse(String  id, String username) {
        this.id = id;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}