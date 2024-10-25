package com.mintra.backend.service.impl;

import com.mintra.backend.entities.*;
import com.mintra.backend.json.*;
import com.mintra.backend.repository.ProductRepository;
import com.mintra.backend.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private SizeService sizeService;

    @Override
    public ProductJson getProductById(long productId) {
        Product product = productRepository.getProductById(productId);
        Picture picture = pictureService.getPictureByProductId(productId);
        Price price = priceService.getPriceByProductId(productId);
        ProductSpecification productSpecification = productSpecificationService.getProductSpecificationByProductId(productId);
        Rating rating = ratingService.getRatingByProductId(productId);
        List<Review> reviewList = reviewService.getReviewsByProductId(productId);
        List<Size> sizeList = sizeService.getSizeByProductId(productId);

        ProductJson productJson = new ProductJson();
        productJson.setProductId(product.getId());
        productJson.setDescription(product.getDescription());
        productJson.setBrandName(product.getBrandName());

        double finalPrice = (100 - price.getDiscount()) * price.getActualPrice() / 100;
        PriceJson priceJson = new PriceJson(finalPrice, price.getActualPrice(), price.getDiscount());
        PictureJson pictureJson = new PictureJson(picture.getImageUrl_1(), picture.getImageUrl_2(), picture.getImageUrl_3());
        ProductSpecificationJson productSpecificationJson = new ProductSpecificationJson(productSpecification.getFitType(), productSpecification.getFabric(), productSpecification.getNumberOfPockets());
        RatingJson ratingJson = new RatingJson(rating.getStars(), rating.getTotalRatings());
        List<ReviewJson> reviewJsonList = reviewList.stream().map(r -> new ReviewJson(r.getUserName(), r.getDescription())).toList();
        List<SizeJson> sizeJsonList = sizeList.stream().map(size -> new SizeJson(size.getSize())).toList();

        productJson.setPrice(priceJson);
        productJson.setPicture(pictureJson);
        productJson.setProductSpecification(productSpecificationJson);
        productJson.setRating(ratingJson);
        productJson.setReviewList(reviewJsonList);
        productJson.setSizeList(sizeJsonList);

        return productJson;
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
        productJson.setProductId(product.getId());

        Picture picture = pictureService.savePicture(images, product.getId());
        PictureJson pictureJson = new PictureJson(picture.getImageUrl_1(), picture.getImageUrl_2(), picture.getImageUrl_3());
        productJson.setPicture(pictureJson);

        priceService.savePrive(productJson.getPrice(), product.getId());

        productSpecificationService.saveProductSpecification(productJson.getProductSpecification(), product.getId());
        ratingService.saveRating(productJson.getRating(), product.getId());

        reviewService.saveReviewList(productJson.getReviewList(), product.getId());
        sizeService.saveSizes(productJson.getSizeList(), product.getId());

        return productJson;
    }
}
