package com.mintra.backend.service;

import com.mintra.backend.entities.Orders;
import com.mintra.backend.enums.OrderPaymentStatus;
import com.mintra.backend.enums.Status;
import com.mintra.backend.json.OrdersJson;
import com.mintra.backend.json.response.GenericResponse;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public interface OrderService {

    GenericResponse placeOrder(OrdersJson ordersJson);

    GenericResponse getOrdersByUserName(String userName);

    GenericResponse getOrdersById(long orderId);

    GenericResponse updateOrderStatus(OrdersJson ordersJson, Status status);

    GenericResponse updateOrderPaymentStatus(OrdersJson ordersJson, OrderPaymentStatus orderPaymentStatus);

    GenericResponse updateOrderDeliveryDate(OrdersJson ordersJson, Date date);
}
