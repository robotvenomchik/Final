// src/main/java/com/example/shop/repository/CartRepository.java
package org.example.shop.repository;

import org.example.shop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}