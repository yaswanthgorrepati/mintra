package com.mintra.backend.repository;

import com.mintra.backend.entities.Product;

public interface ProductRepository {

    Product getProductById(long id);

    Product saveProduct(Product product);
}
