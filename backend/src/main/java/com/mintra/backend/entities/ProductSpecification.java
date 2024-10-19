package com.mintra.backend.entities;

public class ProductSpecification {
    private long id;
    //slim fit, regular fit, relaxed fir
    private String fitType;
    //cotton, polyester
    private String fabric;

    private int numberOfPockets;
    private long prodctId;

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
