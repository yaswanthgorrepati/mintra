package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Cart;
import com.mintra.backend.entities.CartProduct;
import com.mintra.backend.json.ProductJson;
import com.mintra.backend.json.response.CartProductResponseJson;
import com.mintra.backend.json.response.CartResponseJson;
import com.mintra.backend.repository.CartProductRepository;
import com.mintra.backend.repository.CartRepository;
import com.mintra.backend.service.CartService;
import com.mintra.backend.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Cart getCartByUserName(String userName) {
        return cartRepository.getCartByUserName(userName);
    }

    @Override
    @Transactional
    public Cart saveCart(Cart cart) {
        return cartRepository.saveCart(cart);
    }

    @Override
    public CartResponseJson getCartResponseJsonByUserName(String userName) {
        Cart cart = cartRepository.getCartByUserName(userName);
        List<CartProduct> cartProductList = cartProductRepository.getCartProductByCartId(cart.getId());
        List<CartProductResponseJson> cartProductResponseJsonList =
                cartProductList.stream().map(cartProduct -> {
                    long productId =  cartProduct.getProductId();
                    ProductJson productJson = productService.getProductById(productId);
                    return new CartProductResponseJson(productJson, cartProduct.getQuantity(), productJson.getPrice().getFinalPrice()*cartProduct.getQuantity());
                }).toList();
        double totalPrice = cartProductResponseJsonList.stream().mapToDouble(cartProductResponseJson -> cartProductResponseJson.getPrice()).sum();
        CartResponseJson cartResponseJson = new CartResponseJson(cartProductResponseJsonList, totalPrice);
        return cartResponseJson;
    }

    @Override
    @Transactional
    public int deleteProductFromCart(String userName, long productId) {
        Cart cart = cartRepository.getCartByUserName(userName);
        int rows = cartProductRepository.deleteCartProduct(cart.getId(), productId);
        return rows;
    }

    @Override
    @Transactional
    public CartProductResponseJson updateCart(String userName, long productId, int quantity) {
        Cart cart = cartRepository.getCartByUserName(userName);

        CartProduct cartProduct = cartProductRepository.getCartProductByCartIdAndProductId(cart.getId(), productId);
        if(Objects.nonNull(cartProduct)){
            cartProduct.setQuantity(quantity);
        }else {
            cartProduct = new CartProduct(cart.getId(), productId, quantity);
        }

        cartProductRepository.saveCartProduct(cartProduct);
        ProductJson productJson = productService.getProductById(productId);
        CartProductResponseJson cartProductResponseJson = new CartProductResponseJson(productJson, quantity, productJson.getPrice().getFinalPrice()*quantity);
        return cartProductResponseJson;
    }
}
