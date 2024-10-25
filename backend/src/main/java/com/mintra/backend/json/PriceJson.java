package com.mintra.backend.json;

public class PriceJson {
    private double finalPrice;
    private double actualPrice;
    private double discount;

    public PriceJson(double finalPrice, double actualPrice, double discount) {
        this.finalPrice = finalPrice;
        this.actualPrice = actualPrice;
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
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
}
