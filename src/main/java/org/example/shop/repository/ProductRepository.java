// src/main/java/com/example/shop/repository/ProductRepository.java
package org.example.shop.repository;

import org.example.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
