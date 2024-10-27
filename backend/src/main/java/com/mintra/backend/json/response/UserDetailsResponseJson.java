package com.mintra.backend.json.response;

import com.mintra.backend.json.UserAddressJson;

import java.util.List;

public class UserDetailsResponseJson extends GenericResponse{

    private String userName;
    private String email;
    private String mobileNumber;
    private List<UserAddressJson> userAddressList;

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

    public UserDetailsResponseJson(String message, String userName, String email, String mobileNumber, List<UserAddressJson> userAddressList) {
        super(message);
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userAddressList = userAddressList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<UserAddressJson> getUserAddressList() {
        return userAddressList;
    }

    public void setUserAddressList(List<UserAddressJson> userAddressList) {
        this.userAddressList = userAddressList;
    }
}
