package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Orders;
import com.mintra.backend.repository.OrdersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Orders> createOrders(List<Orders> ordersList) {
        for(Orders orders: ordersList){
            entityManager.persist(orders);
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrdersByUserName(String userName) {
        TypedQuery<Orders> typedQuery = entityManager.createNamedQuery("getOrdersByUserName", Orders.class);
        typedQuery.setParameter("userName", userName);
        List<Orders> ordersList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(ordersList) ? null : ordersList;
    }

    @Override
    public Orders getOrdersById(long orderId) {
        TypedQuery<Orders> typedQuery = entityManager.createNamedQuery("getOrdersById", Orders.class);
        typedQuery.setParameter("id", orderId);
        List<Orders> ordersList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(ordersList) ? null : ordersList.get(0);
    }

    @Override
    public Orders getOrdersByIdAndUserName(long orderId, String userName) {
        TypedQuery<Orders> typedQuery = entityManager.createNamedQuery("getOrdersByIdAndUserName", Orders.class);
        typedQuery.setParameter("id", orderId);
        typedQuery.setParameter("userName", userName);
        List<Orders> ordersList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(ordersList) ? null : ordersList.get(0);
    }

    @Override
    public Orders updateOrder(Orders orders) {
        entityManager.persist(orders);
        return orders;
    }
}
