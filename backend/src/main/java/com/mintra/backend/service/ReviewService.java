package com.mintra.backend.service;

import com.mintra.backend.entities.Review;
import com.mintra.backend.json.ReviewJson;
import com.mintra.backend.json.response.ReviewResponseJson;

import java.util.List;

public interface ReviewService {

    Review getReviewById(long id);

    List<ReviewResponseJson> getReviewsByUserName(String userName);

    ReviewResponseJson getReviewByProductIdAndUserName(String userName, long productId);

    List<Review> getReviewsByProductId(long productId);

    Review saveReview(ReviewJson reviewJson, long productId);

    List<Review> saveReviewList(List<ReviewJson> reviewJsonList, long productId);

    int deleteReview(String userName, long productId);
}
