package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
@NamedQueries({@NamedQuery(name = "getProductById", query = "SELECT p FROM Product p WHERE p.id =:productId")})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "brandName")
    private String brandName;
    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Product(String brandName, String description) {
        this.brandName = brandName;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
