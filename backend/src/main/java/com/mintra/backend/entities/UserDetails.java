package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "USERDETAILS")
//@NamedQueries({@NamedQuery(name = "", query = "")})
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userId")
    private long userId;
    @Column(name = "email")
    private String email;
    @Column(name = "mobileNumber")
    private String mobileNumber;

    public UserDetails() {
    }

    public UserDetails(long userId, String email, String mobileNumber) {
        this.userId = userId;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
