package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Rating;
import com.mintra.backend.repository.RatingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Rating getRatingById(long id) {
        TypedQuery<Rating> typedQuery = entityManager.createNamedQuery("getRatingById", Rating.class);
        typedQuery.setParameter("id", id);
        List<Rating> ratingList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(ratingList) ? null : ratingList.get(0);
    }

    @Override
    public Rating getRatingByProductId(long productId) {
        TypedQuery<Rating> typedQuery = entityManager.createNamedQuery("getRatingByProductId", Rating.class);
        typedQuery.setParameter("productId", productId);
        List<Rating> ratingList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(ratingList) ? null : ratingList.get(0);
    }

    @Override
    public Rating saveRating(Rating rating) {
        entityManager.persist(rating);
        return rating;
    }
}
