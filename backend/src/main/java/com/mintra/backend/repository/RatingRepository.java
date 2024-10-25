package com.mintra.backend.repository;

import com.mintra.backend.entities.Rating;

public interface RatingRepository {

    Rating getRatingById(long id);

    Rating getRatingByProductId(long productId);

    Rating saveRating(Rating rating);
}
