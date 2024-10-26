package com.mintra.backend.repository;

import com.mintra.backend.entities.Cart;

public interface CartRepository {

    Cart getCartByUserName(String userName);
    Cart saveCart(Cart cart);
}
