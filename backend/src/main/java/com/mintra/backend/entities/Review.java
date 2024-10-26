package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "REVIEW")
@NamedQueries({@NamedQuery(name = "getReviewById", query = "SELECT r FROM Review r WHERE r.id =:id"),
        @NamedQuery(name = "getReviewsByProductId", query = "SELECT r FROM Review r WHERE r.productId =:productId"),
        @NamedQuery(name = "getReviewsByProductIdAndUserName", query = "SELECT r FROM Review r WHERE r.productId =:productId AND r.userName =:userName"),
        @NamedQuery(name = "deleteReviewByProductIdAndUserName", query = "DELETE FROM Review r WHERE r.productId =:productId AND r.userName =:userName"),
        @NamedQuery(name = "deleteReviewById", query = "DELETE FROM Review r WHERE r.id =:id"),
        @NamedQuery(name = "getReviewsByUserName", query = "SELECT r FROM Review r WHERE r.userName =:userName")})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "description")
    private String description;
    @Column(name = "stars")
    private double stars;
    @Column(name = "productId")
    private long productId;

    public Review() {
    }

    public Review(String userName, String description, double stars, long productId) {
        this.userName = userName;
        this.description = description;
        this.stars = stars;
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

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
