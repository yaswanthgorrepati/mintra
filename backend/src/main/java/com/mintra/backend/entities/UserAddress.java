package com.mintra.backend.entities;

import com.mintra.backend.enums.AddressType;
import jakarta.persistence.*;

@Entity
@Table(name = "USERADDRESS")
@NamedQueries({@NamedQuery(name = "getUserAddressByUserName", query = "SELECT u FROM UserAddress u WHERE u.userName =:userName"),
        @NamedQuery(name = "deleteUserAddressByIdAndUserName", query = "DELETE FROM UserAddress u WHERE u.id =:id AND u.userName=:userName")})
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "aliasName")
    private String aliasName;
    @Column(name = "street1")
    private String street1;
    @Column(name = "street2")
    private String street2;
    @Column(name = "street3")
    private String street3;
    @Column(name = "landMark")
    private String landMark;
    @Column(name = "town")
    private String town;
    @Column(name = "district")
    private String district;
    @Column(name = "state")
    private String state;
    @Column(name = "pincode")
    private String pincode;
    @Column(name = "addressType")
    private AddressType addressType;

    public UserAddress() {
    }

    public UserAddress(String userName, String aliasName, String street1, String street2, String street3,
                       String landMark, String town, String district, String state, String pincode,
                       AddressType addressType) {
        this.userName = userName;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
