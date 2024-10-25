package com.mintra.backend.json;

public class ReviewJson {

    private String userName;
    private String description;

    public ReviewJson(String userName, String description) {
        this.userName = userName;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
