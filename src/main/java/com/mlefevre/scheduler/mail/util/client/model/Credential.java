package com.mlefevre.scheduler.mail.util.client.model;

public class Credential {

    protected String username;

    protected String password;


    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
