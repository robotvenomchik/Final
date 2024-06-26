// src/main/java/com/example/shop/repository/CartItemRepository.java
package org.example.shop.repository;

import org.example.shop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}