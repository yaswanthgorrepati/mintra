package com.mintra.backend.service;

import com.mintra.backend.entities.Price;
import com.mintra.backend.json.PriceJson;

public interface PriceService {

    Price getPriceById(long id);

    Price getPriceByProductId(long productId);

    Price savePrive(PriceJson priceJson, long productId);
}
