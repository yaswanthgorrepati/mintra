package com.mintra.backend.service.impl;

import com.mintra.backend.entities.ProductSpecification;
import com.mintra.backend.json.ProductSpecificationJson;
import com.mintra.backend.repository.ProductSpecificationRepository;
import com.mintra.backend.service.ProductSpecificationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    @Autowired
    private ProductSpecificationRepository productSpecificationRepository;

    @Override
    public ProductSpecification getProductSpecificationById(long id) {
        return productSpecificationRepository.getProductSpecificationById(id);
    }

    @Override
    public ProductSpecification getProductSpecificationByProductId(long productId) {
        return productSpecificationRepository.getProductSpecificationByProductId(productId);
    }

    @Override
    @Transactional
    public ProductSpecification saveProductSpecification(ProductSpecificationJson productSpecificationJson, long productId) {
        ProductSpecification productSpecification = new ProductSpecification(productSpecificationJson.getFitType(),
                productSpecificationJson.getFabric(), productSpecificationJson.getNumberOfPockets(), productId);
        return productSpecificationRepository.saveProductSpecification(productSpecification);
    }
}
