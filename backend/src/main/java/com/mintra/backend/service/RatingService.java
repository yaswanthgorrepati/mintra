package com.mintra.backend.service;

import com.mintra.backend.entities.Rating;
import com.mintra.backend.json.RatingJson;

public interface RatingService {

    Rating getRatingById(long id);

    Rating getRatingByProductId(long productId);

    Rating saveRating(RatingJson ratingJson, long productId);
}
