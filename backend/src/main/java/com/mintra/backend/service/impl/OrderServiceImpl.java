package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Orders;
import com.mintra.backend.enums.OrderPaymentStatus;
import com.mintra.backend.enums.Status;
import com.mintra.backend.json.OrdersJson;
import com.mintra.backend.json.ProductJson;
import com.mintra.backend.json.response.*;
import com.mintra.backend.repository.OrdersRepository;
import com.mintra.backend.service.OrderService;
import com.mintra.backend.service.ProductService;
import com.mintra.backend.service.UserService;
import com.mintra.backend.util.PaymentGateway;
import com.razorpay.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mintra.backend.json.error.MessageDescriptions.PAYMENT_SUCCESS;
import static com.mintra.backend.json.error.MessageDescriptions.SUCCESS;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;
    @Autowired
    PaymentGateway paymentGateway;

    public Order makePayment(OrdersJson ordersJson) {
        //payment gate way code goes here.
         Order order = paymentGateway.makeOrder();
        System.out.println(order);
        return order;
    }



    @Override
    @Transactional
    public GenericResponse placeOrder(OrdersJson ordersJson) {
        //get these from Razor Pay
        Order order = makePayment(ordersJson);
//        OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.SUCCESSFULL;
//        Status status =  Status.ORDER_PLACED;
//        Date deliveryDate = new Date();
//        List<Orders> ordersList = ordersJson.getOrdersList().stream().map(orderJson ->
//                new Orders(orderJson.getProductId(), orderJson.getQuantity(), ordersJson.getUserName(),ordersJson.getDeliveryAddressId(),
//                        orderPaymentStatus,status, deliveryDate))
//                .toList();
//        ordersRepository.createOrders(ordersList);
//
//        UserDetailsResponseJson userDetailsResponseJson = (UserDetailsResponseJson) userService.getUserDetails(ordersJson.getUserName(), true);
//        List<OrderResponseJson> orderResponseJsonList  = ordersList.stream().map(orders -> {
//            ProductJson productJson = productService.getProductById(orders.getProductId());
//            return new OrderResponseJson(orders.getId(), productJson,orders.getOrderPaymentStatus(), orders.getStatus(), orders.getExpectedDeliveryDate());
//        }).toList();
//        OrdersResponseJson ordersResponseJson = new OrdersResponseJson(SUCCESS, orderResponseJsonList, userDetailsResponseJson.getUserAddressList().get(0));
//        return ordersResponseJson;
//    }
//
//
//    @Override
//    @Transactional
//    public GenericResponse placeOrderV2(OrdersJson ordersJson) {
//        //get these from Razor Pay
//        makePayment(ordersJson);
//        OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.PENDING;
//        Status status =  Status.ORDER_PENDING;
//        Date deliveryDate = new Date();
//        List<Orders> ordersList = ordersJson.getOrdersList().stream().map(orderJson ->
//                        new Orders(orderJson.getProductId(), orderJson.getQuantity(), ordersJson.getUserName(),ordersJson.getDeliveryAddressId(),
//                                orderPaymentStatus,status, deliveryDate))
//                .toList();
//        ordersRepository.createOrders(ordersList);
//
//        UserDetailsResponseJson userDetailsResponseJson = (UserDetailsResponseJson) userService.getUserDetails(ordersJson.getUserName(), true);
//        List<OrderResponseJson> orderResponseJsonList  = ordersList.stream().map(orders -> {
//            ProductJson productJson = productService.getProductById(orders.getProductId());
//            return new OrderResponseJson(orders.getId(), productJson,orders.getOrderPaymentStatus(), orders.getStatus(), orders.getExpectedDeliveryDate());
//        }).toList();
//        OrdersResponseJson ordersResponseJson = new OrdersResponseJson(SUCCESS, orderResponseJsonList, userDetailsResponseJson.getUserAddressList().get(0));
        OrdersResponseJson ordersResponseJson = new OrdersResponseJson(SUCCESS);
        ordersResponseJson.setOrder(order);
        return ordersResponseJson;
    }

    @Override
    public GenericResponse getOrdersByUserName(String userName) {
        List<Orders> ordersList = ordersRepository.getOrdersByUserName(userName);
        List<OrderResponseJson> orderResponseJsonList  = ordersList.stream().map(orders -> {
            ProductJson productJson = productService.getProductById(orders.getProductId());
            return new OrderResponseJson(orders.getId(), productJson,orders.getOrderPaymentStatus(), orders.getStatus(), orders.getExpectedDeliveryDate());
        }).toList();
        OrdersResponseJson ordersResponseJson = new OrdersResponseJson(SUCCESS, orderResponseJsonList, null);
        return ordersResponseJson;
    }

    @Override
    public GenericResponse getOrdersById(long orderId) {
        Orders orders = ordersRepository.getOrdersById(orderId);
        ProductJson productJson = productService.getProductById(orders.getProductId());
        UserDetailsResponseJson userDetailsResponseJson = (UserDetailsResponseJson) userService.getUserDetails(orders.getUserName(), true);
        OrderResponseJson orderResponseJson= new OrderResponseJson(orders.getId(), productJson,orders.getOrderPaymentStatus(), orders.getStatus(), orders.getExpectedDeliveryDate());
        OrdersResponseJson ordersResponseJson = new OrdersResponseJson(SUCCESS, Arrays.asList(orderResponseJson), userDetailsResponseJson.getUserAddressList().get(0));
        return ordersResponseJson;
    }

    @Override
    @Transactional
    public GenericResponse updateOrderStatus(OrdersJson ordersJson, Status status) {
     Orders orders = ordersRepository.getOrdersByIdAndUserName(ordersJson.getOrdersList().get(0).getOrderId(), ordersJson.getUserName());
     orders.setStatus(status);
     ordersRepository.updateOrder(orders);
     return new OrdersResponseJson(SUCCESS);
    }

    @Override
    @Transactional
    public GenericResponse updateOrderPaymentStatus(OrdersJson ordersJson, OrderPaymentStatus orderPaymentStatus) {
        Orders orders = ordersRepository.getOrdersByIdAndUserName(ordersJson.getOrdersList().get(0).getOrderId(), ordersJson.getUserName());
        orders.setOrderPaymentStatus(orderPaymentStatus);
        ordersRepository.updateOrder(orders);
        return new OrdersResponseJson(SUCCESS);
    }

    @Override
    @Transactional
    public GenericResponse updateOrderDeliveryDate(OrdersJson ordersJson, Date date) {
        Orders orders = ordersRepository.getOrdersByIdAndUserName(ordersJson.getOrdersList().get(0).getOrderId(), ordersJson.getUserName());
        orders.setExpectedDeliveryDate(date);
        ordersRepository.updateOrder(orders);
        return new OrdersResponseJson(SUCCESS);
    }
}
