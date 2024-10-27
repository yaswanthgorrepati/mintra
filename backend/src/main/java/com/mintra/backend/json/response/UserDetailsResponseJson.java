package com.mintra.backend.json.response;

public class UserDetailsResponseJson extends GenericResponse{

    private String userName;
    private String email;
    private String mobileNumber;

    public UserDetailsResponseJson(String message, String userName) {
        super(message);
        this.userName = userName;
    }

    public UserDetailsResponseJson(String message, String userName, String email, String mobileNumber) {
        super(message);
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
