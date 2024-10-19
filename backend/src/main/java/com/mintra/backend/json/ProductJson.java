package com.mintra.backend.json;

import java.util.List;

public class ProductJson {

    private String brandName;
    private String description;
    private PriceJson price;
    private RatingJson rating;
    private PictureJson picture;
    private SizeJson size;
    private ProductSpecificationJson productSpecification;
    private List<ReviewJson> reviewList;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriceJson getPrice() {
        return price;
    }

    public void setPrice(PriceJson price) {
        this.price = price;
    }

    public RatingJson getRating() {
        return rating;
    }

    public void setRating(RatingJson rating) {
        this.rating = rating;
    }

    public PictureJson getPicture() {
        return picture;
    }

    public void setPicture(PictureJson picture) {
        this.picture = picture;
    }

    public SizeJson getSize() {
        return size;
    }

    public void setSize(SizeJson size) {
        this.size = size;
    }

    public ProductSpecificationJson getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(ProductSpecificationJson productSpecification) {
        this.productSpecification = productSpecification;
    }

    public List<ReviewJson> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<ReviewJson> reviewList) {
        this.reviewList = reviewList;
    }
}
