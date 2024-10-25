package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PRICE")
@NamedQueries({@NamedQuery(name = "getPriceById", query = "SELECT p FROM Price p WHERE p.id =:id"),
        @NamedQuery(name = "getPriceByProductId", query = "SELECT p FROM Price p WHERE p.productId =:productId")})
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "actualPrice")
    private double actualPrice;
    @Column(name = "discount")
    private double discount;
    @Column(name = "productId")
    private long productId;

    public Price() {
    }

    public Price(double actualPrice, double discount, long productId) {
        this.actualPrice = actualPrice;
        this.discount = discount;
        this.productId = productId;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
