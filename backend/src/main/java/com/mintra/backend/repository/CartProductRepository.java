package com.mintra.backend.repository;

import com.mintra.backend.entities.CartProduct;

import java.util.List;

public interface CartProductRepository {

    List<CartProduct> getCartProductByCartId(long cartId);

    CartProduct getCartProductByCartIdAndProductId(long cartId, long productId);

    CartProduct saveCartProduct(CartProduct cartProduct);

    int deleteCartProduct(long cartId, long productId);

}
