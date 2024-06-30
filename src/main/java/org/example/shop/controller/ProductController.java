package org.example.shop.controller;

import org.example.shop.model.Product;
import org.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String listProducts(Model model,
                               @RequestParam(required = false) String gender,
                               @RequestParam(required = false) String season,
                               @RequestParam(required = false) String type) {
        List<Product> products = productRepository.findAll();

        if (gender != null) {
            products = products.stream()
                    .filter(product -> product.getType().equalsIgnoreCase(gender))
                    .toList();
        }

        if (season != null) {
            products = products.stream()
                    .filter(product -> product.getSeason().equalsIgnoreCase(season))
                    .toList();
        }

        if (type != null) {
            products = products.stream()
                    .filter(product -> product.getType2().equalsIgnoreCase(type))
                    .toList();
        }

        model.addAttribute("products", products);
        return "products";
    }
}
