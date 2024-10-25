package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Review;
import com.mintra.backend.repository.ReviewRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Review getReviewById(long id) {
        TypedQuery<Review> typedQuery = entityManager.createNamedQuery("getReviewById", Review.class);
        typedQuery.setParameter("id", id);
        List<Review> reviewList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(reviewList) ? null : reviewList.get(0);
    }

    @Override
    public List<Review> getReviewsByProductId(long productId) {
        TypedQuery<Review> typedQuery = entityManager.createNamedQuery("getReviewsByProductId", Review.class);
        typedQuery.setParameter("productId", productId);
        List<Review> reviewList = typedQuery.getResultList();
        return reviewList;
    }

    @Override
    public Review saveReview(Review review) {
        entityManager.persist(review);
        return review;
    }

    @Override
    public List<Review> saveReviewList(List<Review> reviewList) {
        for(Review review : reviewList){
            entityManager.persist(review);
        }
        return reviewList;
    }
}
