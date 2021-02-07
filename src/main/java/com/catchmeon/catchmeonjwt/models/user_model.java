package com.catchmeon.catchmeonjwt.models;

import java.util.ArrayList;
import java.util.HashMap;

public class user_model {

    String id;
    String name;
    String username;
    String password;
    String email;
    String userTwitter;
    String userYoutube;
    String profileImageUrl;

    public String getUserTwitter() {
        return userTwitter;
    }

    public void setUserTwitter(String userTwitter) {
        this.userTwitter = userTwitter;
    }

    public String getUserYoutube() {
        return userYoutube;
    }

    public void setUserYoutube(String userYoutube) {
        this.userYoutube = userYoutube;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public user_model(String username, String password, String email, String name, String id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImageUrl ="";
        this.name = name;
        this.userTwitter="";
        this.userYoutube="";
    }


}
