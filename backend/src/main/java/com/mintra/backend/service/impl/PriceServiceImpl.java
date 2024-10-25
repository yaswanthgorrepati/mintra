package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Price;
import com.mintra.backend.json.PriceJson;
import com.mintra.backend.repository.PriceRepository;
import com.mintra.backend.service.PriceService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price getPriceById(long id) {
        return priceRepository.getPriceById(id);
    }

    @Override
    public Price getPriceByProductId(long productId) {
        return priceRepository.getPriceByProductId(productId);
    }

    @Override
    @Transactional
    public Price savePrive(PriceJson priceJson, long productId) {
        Price price = new Price(priceJson.getActualPrice(), priceJson.getDiscount(), productId);
        return priceRepository.savePrive(price);
    }
}
