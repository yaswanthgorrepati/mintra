package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CARTPRODUCT")
@NamedQueries({@NamedQuery(name = "getCartProductByCartId", query = "SELECT c FROM CartProduct c WHERE c.cartId =:cartId"),
        @NamedQuery(name = "getCartProductByCartIdAndProductId", query = "SELECT c FROM CartProduct c WHERE c.cartId =:cartId AND c.productId =:productId"),
        @NamedQuery(name = "deleteCartProduct", query = "DELETE FROM CartProduct c WHERE c.cartId =:cartId AND c.productId =:productId")})
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cartId")
    private long cartId;
    @Column(name = "productId")
    private long productId;
    @Column(name = "quantity")
    private int quantity;

    public CartProduct() {
    }

    public CartProduct(long cartId, long productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
