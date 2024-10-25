package com.mintra.backend.service;

import com.mintra.backend.entities.ProductSpecification;
import com.mintra.backend.json.ProductSpecificationJson;

public interface ProductSpecificationService {

    ProductSpecification getProductSpecificationById(long id);

    ProductSpecification getProductSpecificationByProductId(long productId);

    ProductSpecification saveProductSpecification(ProductSpecificationJson productSpecificationJson, long productId);
}
