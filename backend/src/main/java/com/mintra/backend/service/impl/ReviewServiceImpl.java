package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Review;
import com.mintra.backend.json.ReviewJson;
import com.mintra.backend.repository.ReviewRepository;
import com.mintra.backend.service.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.getReviewById(id);
    }

    @Override
    public List<Review> getReviewsByProductId(long productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    @Override
    @Transactional
    public Review saveReview(ReviewJson reviewJson, long productId) {
        Review review = new Review(reviewJson.getUserName(), reviewJson.getDescription(), productId);
        reviewRepository.saveReview(review);
        return review;
    }

    @Override
    @Transactional
    public List<Review> saveReviewList(List<ReviewJson> reviewJsonList, long productId) {
        List<Review> reviewList = reviewJsonList.stream().map(reviewJson -> new Review(reviewJson.getUserName(), reviewJson.getDescription(), productId)).toList();
        reviewRepository.saveReviewList(reviewList);
        return reviewList;
    }
}
