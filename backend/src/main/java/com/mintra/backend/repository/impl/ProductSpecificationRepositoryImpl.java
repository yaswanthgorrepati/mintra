package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.ProductSpecification;
import com.mintra.backend.repository.ProductSpecificationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class ProductSpecificationRepositoryImpl implements ProductSpecificationRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public ProductSpecification getProductSpecificationById(long id) {
        TypedQuery<ProductSpecification> typedQuery = entityManager.createNamedQuery("getProductSpecificationById", ProductSpecification.class);
        typedQuery.setParameter("id", id);
        List<ProductSpecification> productSpecificationList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(productSpecificationList) ? null : productSpecificationList.get(0);
    }

    @Override
    public ProductSpecification getProductSpecificationByProductId(long productId) {
        TypedQuery<ProductSpecification> typedQuery = entityManager.createNamedQuery("getProductSpecificationByProductId", ProductSpecification.class);
        typedQuery.setParameter("productId", productId);
        List<ProductSpecification> productSpecificationList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(productSpecificationList) ? null : productSpecificationList.get(0);
    }

    @Override
    public ProductSpecification saveProductSpecification(ProductSpecification productSpecification) {
        entityManager.persist(productSpecification);
        return productSpecification;
    }
}
