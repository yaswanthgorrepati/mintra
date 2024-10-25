package com.mintra.backend.repository;

import com.mintra.backend.entities.ProductSpecification;

public interface ProductSpecificationRepository {

    ProductSpecification getProductSpecificationById(long id);

    ProductSpecification getProductSpecificationByProductId(long productId);

    ProductSpecification saveProductSpecification(ProductSpecification productSpecification);
}
