package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Rating;
import com.mintra.backend.json.RatingJson;
import com.mintra.backend.repository.RatingRepository;
import com.mintra.backend.service.RatingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating getRatingById(long id) {
        return ratingRepository.getRatingById(id);
    }

    @Override
    public Rating getRatingByProductId(long productId) {
        return ratingRepository.getRatingByProductId(productId);
    }

    @Override
    @Transactional
    public Rating saveRating(RatingJson ratingJson, long productId) {
        Rating rating = new Rating(ratingJson.getStars(), ratingJson.getTotalRatings(), productId);
        ratingRepository.saveRating(rating);
        return rating;
    }
}
