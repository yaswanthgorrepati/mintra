package com.mintra.backend.json.response;

import java.util.List;

public class CartResponseJson {

    private List<CartProductResponseJson> cartProductResponseJsonList;
    private double cartValue;

    public CartResponseJson(List<CartProductResponseJson> cartProductResponseJsonList, double cartValue) {
        this.cartProductResponseJsonList = cartProductResponseJsonList;
        this.cartValue = cartValue;
    }

    public List<CartProductResponseJson> getCartProductResponseJsonList() {
        return cartProductResponseJsonList;
    }

    public void setCartProductResponseJsonList(List<CartProductResponseJson> cartProductResponseJsonList) {
        this.cartProductResponseJsonList = cartProductResponseJsonList;
    }

    public double getCartValue() {
        return cartValue;
    }

    public void setCartValue(double cartValue) {
        this.cartValue = cartValue;
    }
}
