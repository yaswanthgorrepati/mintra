package com.mintra.backend.service;

import com.mintra.backend.entities.Cart;
import com.mintra.backend.json.response.CartProductResponseJson;
import com.mintra.backend.json.response.CartResponseJson;

public interface CartService {

    Cart getCartByUserName(String userName);
    Cart saveCart(Cart cart);

    CartResponseJson getCartResponseJsonByUserName(String userName);

    int deleteProductFromCart(String userName, long productId);

    CartProductResponseJson updateCart(String userName, long productId, int quantity);
}
