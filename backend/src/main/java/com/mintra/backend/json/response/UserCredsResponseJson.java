package com.mintra.backend.json.response;

public class UserCredsResponseJson extends GenericResponse{

    private long userId;
    private String userName;
    private String jwtToken;


    public UserCredsResponseJson(String message, String userName) {
        super(message);
        this.userName = userName;
    }

    public UserCredsResponseJson(String message, long userId, String userName) {
        super(message);
        this.userId = userId;
        this.userName = userName;
    }

    public UserCredsResponseJson(String message, long userId, String userName, String jwtToken) {
        super(message);
        this.userId = userId;
        this.userName = userName;
        this.jwtToken = jwtToken;
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

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
