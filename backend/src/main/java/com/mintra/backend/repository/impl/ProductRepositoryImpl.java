package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Product;
import com.mintra.backend.repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Product getProductById(long id) {
        TypedQuery<Product> typedQuery = entityManager.createNamedQuery("getProductById", Product.class);
        typedQuery.setParameter("productId", id);
        List<Product> productList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(productList) ? null : productList.get(0);
    }

    @Override
    public Product saveProduct(Product product) {
        entityManager.persist(product);
        return product;
    }
}
