package com.mintra.backend.json;

public class ProductSpecificationJson {

    //slim fit, regular fit, relaxed fir
    private String fitType;
    //cotton, polyester
    private String fabric;
    private int numberOfPockets;

    public ProductSpecificationJson(String fitType, String fabric, int numberOfPockets) {
        this.fitType = fitType;
        this.fabric = fabric;
        this.numberOfPockets = numberOfPockets;
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
}
