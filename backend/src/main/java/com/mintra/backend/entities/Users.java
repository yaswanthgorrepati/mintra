package com.mintra.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
@NamedQueries({@NamedQuery(name = "getUserByUserName", query = "SELECT u FROM Users u WHERE u.userName =:userName"),
        @NamedQuery(name = "getUserByUserId", query = "SELECT u FROM Users u WHERE u.id =:id")})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
