package com.mintra.backend.json;

import java.util.List;

public class UserDetailsJson {

    private String userName;
    private String email;
    private String mobileNumber;
    private List<UserAddressJson> userAddressList;

    public UserDetailsJson(String userName, String email, String mobileNumber, List<UserAddressJson> userAddressList) {
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
