package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Cart;
import com.mintra.backend.entities.CartProduct;
import com.mintra.backend.repository.CartRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Cart getCartByUserName(String userName) {
        TypedQuery<Cart> typedQuery = entityManager.createNamedQuery("getCartByUserName", Cart.class);
        typedQuery.setParameter("userName", userName);
        List<Cart> cartList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(cartList) ? null : cartList.get(0);
    }

    @Override
    public Cart saveCart(Cart cart) {
        entityManager.persist(cart);
        return cart;
    }
}
