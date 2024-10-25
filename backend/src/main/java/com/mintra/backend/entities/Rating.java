package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "RATING")
@NamedQueries({@NamedQuery(name = "getRatingById", query = "SELECT r FROM Rating r WHERE r.id =:id"),
        @NamedQuery(name = "getRatingByProductId", query = "SELECT r FROM Rating r WHERE r.productId =:productId")})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "stars")
    private double stars;
    @Column(name = "totalRatings")
    private int totalRatings;
    @Column(name = "productId")
    private long productId;

    public Rating() {
    }

    public Rating(double stars, int totalRatings, long productId) {
        this.stars = stars;
        this.totalRatings = totalRatings;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
