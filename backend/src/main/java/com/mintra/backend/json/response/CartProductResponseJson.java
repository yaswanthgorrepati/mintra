package com.mintra.backend.json.response;

import com.mintra.backend.json.ProductJson;

public class CartProductResponseJson {

    private ProductJson productJson;
    private int quantity;
    private double price;

    public CartProductResponseJson(ProductJson productJson, int quantity, double price) {
        this.productJson = productJson;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductJson getProductJson() {
        return productJson;
    }

    public void setProductJson(ProductJson productJson) {
        this.productJson = productJson;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
