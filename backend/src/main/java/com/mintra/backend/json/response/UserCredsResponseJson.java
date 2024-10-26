package com.mintra.backend.json.response;

public class UserCredsResponseJson extends GenericResponse{

    private long userId;
    private String userName;


    public UserCredsResponseJson(String message, long userId, String userName) {
        super(message);
        this.userId = userId;
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
