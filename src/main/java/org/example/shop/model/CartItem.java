// src/main/java/com/example/shop/model/CartItem.java
package org.example.shop.model;

import jakarta.persistence.*;
import org.example.shop.model.Product;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private org.example.shop.model.Cart cart;

    // Getters Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public org.example.shop.model.Cart getCart() {
        return cart;
    }

    public void setCart(org.example.shop.model.Cart cart) {
        this.cart = cart;
    }
}
