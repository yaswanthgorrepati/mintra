package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.entities.Product;
import com.mintra.backend.json.ProductJson;
import com.mintra.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private Gson gson = new Gson();

    private static final Logger logger = Logger.getLogger(ProductController.class.getName());



    @GetMapping("/{productCategory}/{productId}")
    public ResponseEntity<String> getProductById(@PathVariable("productCategory") String productCategory,
                                                 @PathVariable("productId") String productId){
        ProductJson productJson = productService.getProductById(Long.parseLong(productId));
        return new ResponseEntity<>(gson.toJson(productJson), HttpStatus.OK);
    }

    @PostMapping("/{productCategory}")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        logger.info("test i save product");
        logger.info("test i save product {}" + product);
        Product product1 = productService.saveProduct(product);
        return new ResponseEntity<>(gson.toJson(product), HttpStatus.OK);
    }

    @PostMapping("/v2/{productCategory}")
    public ResponseEntity<String> saveProductV2(@RequestParam String productJson, @RequestParam MultipartFile[] images){
        ProductJson productJson1 = gson.fromJson(productJson, ProductJson.class);
        ProductJson product1 = productService.saveProduct(productJson1,  images);
        return new ResponseEntity<>(gson.toJson(product1), HttpStatus.OK);
    }

}
