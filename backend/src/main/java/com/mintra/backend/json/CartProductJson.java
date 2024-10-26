package com.mintra.backend.json;

public class CartProductJson {

    private String userName;
    private long productId;
    private int quantity;

    public CartProductJson(String userName, long productId, int quantity) {
        this.userName = userName;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
