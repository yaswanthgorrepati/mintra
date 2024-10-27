package com.mintra.backend.json;

import com.mintra.backend.enums.OrderPaymentStatus;
import com.mintra.backend.enums.Status;

import java.util.Date;
import java.util.List;

public class OrdersJson {

    private String userName;
    private long deliveryAddressId;
    List<OrderJson> ordersList;
    private Status status;
    private OrderPaymentStatus orderPaymentStatus;
    private Date expectedDeliveryDate;

    public OrdersJson(String userName, long deliveryAddressId, List<OrderJson> ordersList) {
        this.userName = userName;
        this.deliveryAddressId = deliveryAddressId;
        this.ordersList = ordersList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(long deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public List<OrderJson> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderJson> ordersList) {
        this.ordersList = ordersList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public Date getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }
}
