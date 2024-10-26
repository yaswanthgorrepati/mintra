package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.entities.Cart;
import com.mintra.backend.json.CartProductJson;
import com.mintra.backend.json.response.CartProductResponseJson;
import com.mintra.backend.json.response.CartResponseJson;
import com.mintra.backend.json.response.SuccessResponse;
import com.mintra.backend.repository.CartRepository;
import com.mintra.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.mintra.backend.json.error.MessageDescriptions.PRODUCT_DELETED;

@RestController
@RequestMapping("/cart")
public class CartController {

    //this is for test purpose only
    @Autowired
    CartRepository cartRepository;
    @Autowired
    private CartService cartService;
    private Gson gson = new Gson();

    @GetMapping("")
    public ResponseEntity<String> getCartResponseJson(@RequestBody CartProductJson cartProductJson){
//        createCart(cartProductJson.getUserName());
        CartResponseJson cartResponseJson = cartService.getCartResponseJsonByUserName(cartProductJson.getUserName());
        return new ResponseEntity<>(gson.toJson(cartResponseJson), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> updateCart(@RequestBody CartProductJson cartProductJson){
//        createCart(cartProductJson.getUserName());
        CartProductResponseJson cartProductResponseJson = cartService.updateCart(cartProductJson.getUserName(), cartProductJson.getProductId(), cartProductJson.getQuantity());
        return new ResponseEntity<>(gson.toJson(cartProductResponseJson), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<String> deleteProductFromCart(@RequestBody CartProductJson cartProductJson){
//        createCart(cartProductJson.getUserName());
        int row = cartService.deleteProductFromCart(cartProductJson.getUserName(), cartProductJson.getProductId());
        return new ResponseEntity<>(gson.toJson(new SuccessResponse(row + " " + PRODUCT_DELETED)), HttpStatus.OK);
    }

    private void createCart(String userName){
        if(Objects.isNull(cartRepository.getCartByUserName(userName))) {
            Cart cart = new Cart(userName, 0);
            cartService.saveCart(cart);
        }
    }

}
