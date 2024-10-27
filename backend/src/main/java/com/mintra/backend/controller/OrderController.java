package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.json.OrdersJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.mintra.backend.json.error.MessageDescriptions.UPDATE_DID_NOT_HAPPEN;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    private Gson gson = new Gson();

    @PostMapping("")
    public ResponseEntity<String> placeOrder(@RequestBody OrdersJson ordersJson) {
        GenericResponse genericResponse = orderService.placeOrder(ordersJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> getOrders(@RequestBody OrdersJson ordersJson) {
        GenericResponse genericResponse = orderService.getOrdersByUserName(ordersJson.getUserName());
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody OrdersJson ordersJson) {
        GenericResponse genericResponse;
        if (Objects.nonNull(ordersJson.getStatus())) {
            genericResponse = orderService.updateOrderStatus(ordersJson, ordersJson.getStatus());
        } else if (Objects.nonNull(ordersJson.getOrderPaymentStatus())) {
            genericResponse = orderService.updateOrderPaymentStatus(ordersJson, ordersJson.getOrderPaymentStatus());
        } else if (Objects.nonNull(ordersJson.getExpectedDeliveryDate())) {
            genericResponse = orderService.updateOrderDeliveryDate(ordersJson, ordersJson.getExpectedDeliveryDate());
        } else {
            genericResponse = new GenericResponse(UPDATE_DID_NOT_HAPPEN);
        }
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }
}
