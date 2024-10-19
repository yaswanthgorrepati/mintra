package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Picture;
import com.mintra.backend.entities.Product;
import com.mintra.backend.json.PictureJson;
import com.mintra.backend.json.ProductJson;
import com.mintra.backend.repository.ProductRepository;
import com.mintra.backend.service.PictureService;
import com.mintra.backend.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PictureService pictureService;

    @Override
    public Product getProductById(long id) {
        return productRepository.getProductById(id);
    }

    @Override
    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.saveProduct(product);
    }

    @Override
    @Transactional
    public ProductJson saveProduct(ProductJson productJson, MultipartFile[] images) {
        Product product = new Product(productJson.getBrandName(), productJson.getDescription());
        saveProduct(product);
        Picture picture = pictureService.savePicture(images, product.getId());
        PictureJson pictureJson = new PictureJson(picture.getImageUrl_1(), picture.getImageUrl_2(), picture.getImageUrl_3());
        productJson.setPicture(pictureJson);
        return productJson;
    }
}
