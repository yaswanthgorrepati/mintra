package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "REVIEW")
@NamedQueries({@NamedQuery(name = "getReviewById", query = "SELECT r FROM Review r WHERE r.id =:id"),
        @NamedQuery(name = "getReviewsByProductId", query = "SELECT r FROM Review r WHERE r.productId =:productId")})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "description")
    private String description;
    @Column(name = "productId")
    private long productId;

    public Review() {
    }

    public Review(String userName, String description, long productId) {
        this.userName = userName;
        this.description = description;
        this.productId = productId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
