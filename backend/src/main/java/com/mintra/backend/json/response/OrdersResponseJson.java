package com.mintra.backend.json.response;

import com.mintra.backend.json.UserAddressJson;
import com.razorpay.Order;

import java.util.List;

public class OrdersResponseJson extends GenericResponse {

    Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    List<OrderResponseJson> orderResponseJsonList;
    private UserAddressJson userAddressJson;

    public OrdersResponseJson(String message) {
        super(message);
    }

    public OrdersResponseJson(String message, List<OrderResponseJson> orderResponseJsonList, UserAddressJson userAddressJson) {
        super(message);
        this.orderResponseJsonList = orderResponseJsonList;
        this.userAddressJson = userAddressJson;
    }

    public List<OrderResponseJson> getOrderResponseJsonList() {
        return orderResponseJsonList;
    }

    public void setOrderResponseJsonList(List<OrderResponseJson> orderResponseJsonList) {
        this.orderResponseJsonList = orderResponseJsonList;
    }

    public UserAddressJson getUserAddressJson() {
        return userAddressJson;
    }

    public void setUserAddressJson(UserAddressJson userAddressJson) {
        this.userAddressJson = userAddressJson;
    }
}
