package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CART")
@NamedQueries({@NamedQuery(name = "getCartByUserName", query = "SELECT c FROM Cart c WHERE c.userName =:userName")})
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "cartValue")
    private double cartValue;

    public Cart() {
    }

    public Cart(String userName, double cartValue) {
        this.userName = userName;
        this.cartValue = cartValue;
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

    public double getCartValue() {
        return cartValue;
    }

    public void setCartValue(double cartValue) {
        this.cartValue = cartValue;
    }
}
