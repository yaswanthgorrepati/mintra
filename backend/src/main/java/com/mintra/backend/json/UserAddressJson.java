package com.mintra.backend.json;

import com.mintra.backend.enums.AddressType;

public class UserAddressJson {

    private long addressId;
    private String aliasName;
    private String street1;
    private String street2;
    private String street3;
    private String landMark;
    private String town;
    private String district;
    private String state;
    private String pincode;
    private AddressType addressType;

    public UserAddressJson(long addressId, String aliasName, String street1, String street2, String street3,
                           String landMark, String town, String district, String state, String pincode,
                           AddressType addressType) {
        this.addressId = addressId;
        this.aliasName = aliasName;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.landMark = landMark;
        this.town = town;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
        this.addressType = addressType;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
