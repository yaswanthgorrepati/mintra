package com.mintra.backend.json.response;

import com.mintra.backend.enums.OrderPaymentStatus;
import com.mintra.backend.enums.Status;
import com.mintra.backend.json.ProductJson;

import java.util.Date;

public class OrderResponseJson {

    private long orderId;
    private ProductJson productJson;
    private OrderPaymentStatus orderPaymentStatus;
    private Status status;
    private Date expectedDeliveryDate;

    public OrderResponseJson(long orderId, ProductJson productJson, OrderPaymentStatus orderPaymentStatus, Status status, Date expectedDeliveryDate) {
        this.orderId = orderId;
        this.productJson = productJson;
        this.orderPaymentStatus = orderPaymentStatus;
        this.status = status;
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public ProductJson getProductJson() {
        return productJson;
    }

    public void setProductJson(ProductJson productJson) {
        this.productJson = productJson;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}
