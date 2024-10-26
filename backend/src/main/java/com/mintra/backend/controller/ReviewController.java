package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.entities.Review;
import com.mintra.backend.json.ProductJson;
import com.mintra.backend.json.ReviewJson;
import com.mintra.backend.json.error.ProductErrorResponse;
import com.mintra.backend.json.response.ReviewResponseJson;
import com.mintra.backend.json.response.SuccessResponse;
import com.mintra.backend.service.ProductService;
import com.mintra.backend.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.mintra.backend.json.error.MessageDescriptions.NO_PRODUCT_FOUND;
import static com.mintra.backend.json.error.MessageDescriptions.REVIEW_DELETED;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProductService productService;

    private Gson gson = new Gson();

    @PostMapping("/{productId}")
    public ResponseEntity<String> saveorUpdateReview(@PathVariable("productId") String productId,
                                                     @RequestBody ReviewJson reviewJson) {
        ProductJson productJson = productService.getMinProductById(Long.parseLong(productId));
        if (Objects.nonNull(productJson)) {
            Review review = reviewService.saveReview(reviewJson, Long.parseLong(productId));
            ReviewResponseJson reviewResponseJson = new ReviewResponseJson(reviewJson.getUserName(), reviewJson.getDescription(), reviewJson.getStars(), Long.parseLong(productId));
            return new ResponseEntity<>(gson.toJson(reviewResponseJson), HttpStatus.OK);
        }
        return new ResponseEntity<>(gson.toJson(new ProductErrorResponse(NO_PRODUCT_FOUND)), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteReview(@PathVariable("productId") String productId,
                                               @RequestBody ReviewJson reviewJson) {
        ProductJson productJson = productService.getMinProductById(Long.parseLong(productId));
        if (Objects.nonNull(productJson)) {
            int rows = reviewService.deleteReview(reviewJson.getUserName(), Long.parseLong(productId));
            return new ResponseEntity<>(gson.toJson(new SuccessResponse(rows + " " + REVIEW_DELETED)), HttpStatus.OK);
        }
        return new ResponseEntity<>(gson.toJson(new ProductErrorResponse(NO_PRODUCT_FOUND)), HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<String> getReview(@PathVariable("productId") String productId,
                                            @RequestBody ReviewJson reviewJson) {
        ProductJson productJson = productService.getMinProductById(Long.parseLong(productId));
        if (Objects.nonNull(productJson)) {
            ReviewResponseJson reviewResponseJson = reviewService.getReviewByProductIdAndUserName(reviewJson.getUserName(), Long.parseLong(productId));
            return new ResponseEntity<>(gson.toJson(reviewResponseJson), HttpStatus.OK);
        }
        return new ResponseEntity<>(gson.toJson(new ProductErrorResponse(NO_PRODUCT_FOUND)), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("")
    public ResponseEntity<String> getReview(@RequestBody ReviewJson reviewJson) {
        List<ReviewResponseJson> reviewResponseJsonList = reviewService.getReviewsByUserName(reviewJson.getUserName());
        return new ResponseEntity<>(gson.toJson(reviewResponseJsonList), HttpStatus.OK);
    }
}
