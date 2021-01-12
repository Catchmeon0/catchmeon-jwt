package com.catchmeon.catchmeonjwt.models.request;
import java.io.Serializable;

public class SignUpRequest implements Serializable {

    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public SignUpRequest()
    {

    }

    public SignUpRequest(String email, String username, String password) {
        this.setEmail(email);
        this.setUsername(username);
        this.setPassword(password);
    }
}