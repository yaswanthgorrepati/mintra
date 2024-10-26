package com.mintra.backend.service;

import com.mintra.backend.entities.Product;
import com.mintra.backend.json.ProductJson;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    ProductJson getMinProductById(long productId);

    ProductJson getProductById(long productId);

    Product saveProduct(Product product);

    ProductJson saveProduct(ProductJson productJson, MultipartFile[] images);
}
