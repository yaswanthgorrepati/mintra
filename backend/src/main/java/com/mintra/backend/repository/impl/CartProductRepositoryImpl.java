package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.CartProduct;
import com.mintra.backend.repository.CartProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class CartProductRepositoryImpl implements CartProductRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CartProduct> getCartProductByCartId(long cartId) {
        TypedQuery<CartProduct> typedQuery = entityManager.createNamedQuery("getCartProductByCartId", CartProduct.class);
        typedQuery.setParameter("cartId", cartId);
        List<CartProduct> cartProductList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(cartProductList) ? null : cartProductList;
    }

    @Override
    public CartProduct getCartProductByCartIdAndProductId(long cartId, long productId) {
        TypedQuery<CartProduct> typedQuery = entityManager.createNamedQuery("getCartProductByCartIdAndProductId", CartProduct.class);
        typedQuery.setParameter("cartId", cartId);
        typedQuery.setParameter("productId", productId);
        List<CartProduct> cartProductList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(cartProductList) ? null : cartProductList.get(0);
    }

    @Override
    public CartProduct saveCartProduct(CartProduct cartProduct) {
        entityManager.persist(cartProduct);
        return cartProduct;
    }

    @Override
    public int deleteCartProduct(long cartId, long productId) {
        TypedQuery typedQuery = (TypedQuery) entityManager.createNamedQuery("deleteCartProduct");
        typedQuery.setParameter("cartId", cartId);
        typedQuery.setParameter("productId", productId);
        int rows = typedQuery.executeUpdate();
        return rows;
    }
}
