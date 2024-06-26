package org.example.shop.controller;

import org.example.shop.model.Cart;
import org.example.shop.model.CartItem;
import org.example.shop.model.Product;
import org.example.shop.repository.CartRepository;
import org.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        Cart cart = cartRepository.findById(1L).orElse(new Cart());
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId) {
        Cart cart = cartRepository.findById(1L).orElse(new Cart());
        if (cart.getItems() == null) {
            cart.setItems(new ArrayList<>());
        }

        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isPresent()) {
            Product product = productOpt.get();
            boolean productExistsInCart = false;

            for (CartItem item : cart.getItems()) {
                if (item.getProduct().getId().equals(product.getId())) {
                    item.setQuantity(item.getQuantity() + 1);
                    productExistsInCart = true;
                    break;
                }
            }

            if (!productExistsInCart) {
                CartItem cartItem = new CartItem();
                cartItem.setProduct(product);
                cartItem.setQuantity(1);
                cartItem.setCart(cart);
                cart.getItems().add(cartItem);
            }

            cartRepository.save(cart);
        }

        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        Cart cart = cartRepository.findById(1L).orElse(new Cart());
        if (cart.getItems() != null) {
            cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/increase/{productId}")
    public String increaseQuantity(@PathVariable Long productId) {
        Cart cart = cartRepository.findById(1L).orElse(new Cart());
        if (cart.getItems() != null) {
            for (CartItem item : cart.getItems()) {
                if (item.getProduct().getId().equals(productId)) {
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }

    @PostMapping("/cart/decrease/{productId}")
    public String decreaseQuantity(@PathVariable Long productId) {
        Cart cart = cartRepository.findById(1L).orElse(new Cart());
        if (cart.getItems() != null) {
            for (CartItem item : cart.getItems()) {
                if (item.getProduct().getId().equals(productId)) {
                    if (item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - 1);
                    } else {
                        cart.getItems().remove(item);
                    }
                    break;
                }
            }
            cartRepository.save(cart);
        }
        return "redirect:/cart";
    }
}