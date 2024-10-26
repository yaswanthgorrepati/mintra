package com.mintra.backend.repository;

import com.mintra.backend.entities.Review;

import java.util.List;

public interface ReviewRepository {

    Review getReviewById(long id);

    List<Review> getReviewsByProductId(long productId);

    Review getReviewsByProductIdAndUserName(long productId, String userName);

    Review saveReview(Review review);

    List<Review> saveReviewList(List<Review> reviewList);

    int deleteReview(long productId, String userName);

    int deleteReview(long id);

    List<Review> getReviewsByUserName(String userName);
}
