package com.mintra.backend.repository;

import com.mintra.backend.entities.Orders;

import java.util.List;

public interface OrdersRepository {

    List<Orders> createOrders(List<Orders> ordersList);

    List<Orders> getOrdersByUserName(String userName);

    Orders getOrdersById(long orderId);

    Orders getOrdersByIdAndUserName(long orderId, String userName);

    Orders updateOrder(Orders orders);
}
