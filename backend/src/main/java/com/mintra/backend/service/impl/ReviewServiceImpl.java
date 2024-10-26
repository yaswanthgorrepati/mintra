package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Rating;
import com.mintra.backend.entities.Review;
import com.mintra.backend.json.ReviewJson;
import com.mintra.backend.json.response.ReviewResponseJson;
import com.mintra.backend.repository.ProductRepository;
import com.mintra.backend.repository.ReviewRepository;
import com.mintra.backend.service.RatingService;
import com.mintra.backend.service.ReviewService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public Review getReviewById(long id) {
        return reviewRepository.getReviewById(id);
    }

    @Override
    public List<ReviewResponseJson> getReviewsByUserName(String userName) {
        List<Review> reviewList = reviewRepository.getReviewsByUserName(userName);
        List<ReviewResponseJson> reviewResponseJsonList = reviewList.stream().map(review -> new ReviewResponseJson(review.getUserName(), review.getDescription(), review.getStars(), review.getProductId())).toList();
        return reviewResponseJsonList;
    }

    @Override
    public ReviewResponseJson getReviewByProductIdAndUserName(String userName, long productId) {
        Review review = reviewRepository.getReviewsByProductIdAndUserName(productId, userName);
        return new ReviewResponseJson(review.getUserName(), review.getDescription(), review.getStars(), productId);
    }

    @Override
    public List<Review> getReviewsByProductId(long productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    @Override
    @Transactional
    public Review saveReview(ReviewJson reviewJson, long productId) {
        Review review = reviewRepository.getReviewsByProductIdAndUserName(productId, reviewJson.getUserName());
        if(review != null){
            review.setDescription(reviewJson.getDescription());
            review.setStars(reviewJson.getStars());
        }else{
            review = new Review(reviewJson.getUserName(), reviewJson.getDescription(), reviewJson.getStars(), productId);
        }
        //calculate rating

        Rating rating = ratingService.getRatingByProductId(productId);
        double finalrating = ((rating.getStars()* rating.getTotalRatings()) + review.getStars())/(rating.getTotalRatings()+1);
        rating.setTotalRatings(rating.getTotalRatings()+1);
        rating.setStars(finalrating);

        reviewRepository.saveReview(review);
        ratingService.saveRating(rating);
        return review;
    }

    @Override
    @Transactional
    public List<Review> saveReviewList(List<ReviewJson> reviewJsonList, long productId) {
        List<Review> reviewList = reviewJsonList.stream().map(reviewJson -> new Review(reviewJson.getUserName(), reviewJson.getDescription(),reviewJson.getStars(), productId)).toList();
        reviewRepository.saveReviewList(reviewList);
        return reviewList;
    }

    @Override
    @Transactional
    public int deleteReview(String userName, long productId) {
        Review review = reviewRepository.getReviewsByProductIdAndUserName(productId, userName);
        //calculate the rating
        Rating rating = ratingService.getRatingByProductId(productId);
        double totalStars = rating.getStars()* rating.getTotalRatings();
        double finalrating = (totalStars - review.getStars())/(rating.getTotalRatings()-1);
        rating.setTotalRatings(rating.getTotalRatings()-1);
        rating.setStars(finalrating);

        ratingService.saveRating(rating);
        return reviewRepository.deleteReview(productId, userName);
    }
}
