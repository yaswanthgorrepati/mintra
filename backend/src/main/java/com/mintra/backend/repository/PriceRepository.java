package com.mintra.backend.repository;

import com.mintra.backend.entities.Price;

public interface PriceRepository {

    Price getPriceById(long id);

    Price getPriceByProductId(long productId);

    Price savePrive(Price price);
}
