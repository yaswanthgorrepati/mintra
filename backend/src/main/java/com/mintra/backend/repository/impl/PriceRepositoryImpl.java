package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Price;
import com.mintra.backend.repository.PriceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Price getPriceById(long id) {
        TypedQuery<Price> typedQuery = entityManager.createNamedQuery("getPriceById", Price.class);
        typedQuery.setParameter("id", id);
        List<Price> priceList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(priceList) ? null : priceList.get(0);
    }

    @Override
    public Price getPriceByProductId(long productId) {
        TypedQuery<Price> typedQuery = entityManager.createNamedQuery("getPriceByProductId", Price.class);
        typedQuery.setParameter("productId", productId);
        List<Price> priceList = typedQuery.getResultList();;
        return CollectionUtils.isEmpty(priceList) ? null : priceList.get(0);
    }

    @Override
    public Price savePrive(Price price) {
        entityManager.persist(price);
        return price;
    }
}
