package com.mintra.backend.json;

public class UserJson {

    private String userName;

    public UserJson(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
