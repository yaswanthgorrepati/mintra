package com.mintra.backend.json;

public class OrderJson {

    private long orderId;
    private long productId;
    private int quantity;

    public OrderJson() {
    }

    public OrderJson(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderJson(long orderId, long productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
