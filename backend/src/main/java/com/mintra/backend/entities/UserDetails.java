package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USERDETAILS")
@NamedQueries({@NamedQuery(name = "getUserDetailsByuserName", query = "SELECT u FROM UserDetails u WHERE u.userName =:userName")})
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String  userName;
    @Column(name = "email")
    private String email;
    @Column(name = "mobileNumber")
    private String mobileNumber;

    public UserDetails() {
    }

    public UserDetails(String userName, String email, String mobileNumber) {
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
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
}
