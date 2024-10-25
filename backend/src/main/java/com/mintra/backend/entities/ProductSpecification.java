package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTSPECIFICATION")
@NamedQueries({@NamedQuery(name = "getProductSpecificationById", query = "SELECT p FROM ProductSpecification p WHERE p.id =:id"),
        @NamedQuery(name = "getProductSpecificationByProductId", query = "SELECT p FROM ProductSpecification p WHERE p.prodctId =:productId")})
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //slim fit, regular fit, relaxed fir
    @Column(name = "fitType")
    private String fitType;
    //cotton, polyester
    @Column(name = "fabric")
    private String fabric;
    @Column(name = "numberOfPockets")
    private int numberOfPockets;
    @Column(name = "prodctId")
    private long prodctId;

    public ProductSpecification() {
    }

    public ProductSpecification(String fitType, String fabric, int numberOfPockets, long prodctId) {
        this.fitType = fitType;
        this.fabric = fabric;
        this.numberOfPockets = numberOfPockets;
        this.prodctId = prodctId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFitType() {
        return fitType;
    }

    public void setFitType(String fitType) {
        this.fitType = fitType;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public int getNumberOfPockets() {
        return numberOfPockets;
    }

    public void setNumberOfPockets(int numberOfPockets) {
        this.numberOfPockets = numberOfPockets;
    }

    public long getProdctId() {
        return prodctId;
    }

    public void setProdctId(long prodctId) {
        this.prodctId = prodctId;
    }
}
