package com.mintra.backend.service;

import com.mintra.backend.entities.Review;
import com.mintra.backend.json.ReviewJson;

import java.util.List;

public interface ReviewService {

    Review getReviewById(long id);

    List<Review> getReviewsByProductId(long productId);

    Review saveReview(ReviewJson reviewJson, long productId);

    List<Review> saveReviewList(List<ReviewJson> reviewJsonList, long productId);
}
