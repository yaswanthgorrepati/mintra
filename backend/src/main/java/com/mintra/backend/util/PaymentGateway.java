package com.mintra.backend.util;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class PaymentGateway {
    private static final Logger logger= Logger.getLogger(PaymentGateway.class.getName());

    private static final String key_id = "1111";
    private static final String  key_secret ="111";

    public Order makeOrder() {
        try {
        RazorpayClient razorpay = new RazorpayClient(key_id, key_secret);

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",50000);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        notes.put("notes_key_1","Tea, Earl Grey, Hot");
        orderRequest.put("notes",notes);


            Order order = razorpay.orders.create(orderRequest);
            return order;
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
        return null;
    }

}
