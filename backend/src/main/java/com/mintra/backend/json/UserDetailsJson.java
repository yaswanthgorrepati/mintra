package com.mintra.backend.json;

public class UserDetailsJson {

    private String userName;
    private String password;

    public UserDetailsJson(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
