package com.promotionengine.promotion.repository;

import com.promotionengine.promotion.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion,Long> { }
