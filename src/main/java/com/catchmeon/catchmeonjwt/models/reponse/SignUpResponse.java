package com.catchmeon.catchmeonjwt.models.reponse;


import java.io.Serializable;

public class SignUpResponse implements Serializable {

    private final String username;


    public SignUpResponse( String username) {

        this.username = username;

    }

    public String getUsername() {
        return username;
    }


}