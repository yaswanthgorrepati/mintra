package com.mintra.backend.repository;

import com.mintra.backend.entities.Review;

import java.util.List;

public interface ReviewRepository {

    Review getReviewById(long id);

    List<Review> getReviewsByProductId(long productId);

    Review saveReview(Review review);

    List<Review> saveReviewList(List<Review> reviewList);
}
