package com.promotionengine.promotion.repository;

import com.promotionengine.promotion.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartItem,Long> {
}
