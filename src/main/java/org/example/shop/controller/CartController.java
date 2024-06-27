package org.example.shop.controller;

import jakarta.servlet.http.HttpSession;
import org.example.shop.model.Cart;
import org.example.shop.model.CartItem;
import org.example.shop.model.Product;
import org.example.shop.repository.CartRepository;
import org.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String viewCart(Model model, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setSessionId(sessionId);
            return newCart;
        });
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/add/{productId}")
    @ResponseBody
    public String addToCart(@PathVariable Long productId, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setSessionId(sessionId);
            return newCart;
        });

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

        return "Item added to cart";
    }

    @PostMapping("/remove/{productId}")
    @ResponseBody
    public String removeFromCart(@PathVariable Long productId, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElse(null);
        if (cart != null && cart.getItems() != null) {
            cart.getItems().removeIf(item -> item.getProduct().getId().equals(productId));
            cartRepository.save(cart);
        }
        return "Item removed from cart";
    }

    @PostMapping("/clear")
    @ResponseBody
    public String clearCart(HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElse(null);
        if (cart != null) {
            cart.getItems().clear();
            cartRepository.save(cart);
        }
        return "Cart cleared";
    }

    @PostMapping("/increase/{productId}")
    @ResponseBody
    public String increaseQuantity(@PathVariable Long productId, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElse(null);
        if (cart != null && cart.getItems() != null) {
            for (CartItem item : cart.getItems()) {
                if (item.getProduct().getId().equals(productId)) {
                    item.setQuantity(item.getQuantity() + 1);
                    break;
                }
            }
            cartRepository.save(cart);
        }
        return "Quantity increased";
    }

    @PostMapping("/decrease/{productId}")
    @ResponseBody
    public String decreaseQuantity(@PathVariable Long productId, HttpSession session) {
        String sessionId = session.getId();
        Cart cart = cartRepository.findBySessionId(sessionId).orElse(null);
        if (cart != null && cart.getItems() != null) {
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
        return "Quantity decreased";
    }
}