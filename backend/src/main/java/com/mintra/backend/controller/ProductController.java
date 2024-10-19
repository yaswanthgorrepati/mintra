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

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private Gson gson = new Gson();


    @GetMapping("/{productCategory}/{productId}")
    public ResponseEntity<String> getProductById(@PathVariable("productCategory") String productCategory,
                                                 @PathVariable("productId") String productId){
        Product product = productService.getProductById(Long.parseLong(productId));
        return new ResponseEntity<>(gson.toJson(product), HttpStatus.OK);
    }

    @PostMapping("/{productCategory}")
    public ResponseEntity<String> saveProduct(@RequestBody Product product){
        Product product1 = productService.saveProduct(product);
        return new ResponseEntity<>(gson.toJson(product), HttpStatus.OK);
    }

    @PostMapping("/v2/{productCategory}")
    public ResponseEntity<String> saveProductV2(@RequestParam String productJson, @RequestParam MultipartFile[] images){
        ProductJson productJson1 = gson.fromJson(productJson, ProductJson.class);
        ProductJson product1 = productService.saveProduct(productJson1,  images[0],  images[1],  images[2]);
        return new ResponseEntity<>(gson.toJson(product1), HttpStatus.OK);
    }

}
