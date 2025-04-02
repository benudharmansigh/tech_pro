package com.promotionengine.promotion.controller;

import com.promotionengine.promotion.model.CartItem;
import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.promotion.repository.CartRepository;
import com.promotionengine.promotion.repository.PromotionRepository;
import com.promotionengine.promotion.service.PromotionEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartRepository cartRepository;
    private final PromotionRepository promotionRepository;

    private final PromotionEngineService promotionEngineService;


    public CartController(CartRepository cartRepository, PromotionRepository promotionRepository, PromotionEngineService promotionEngineService) {
        this.cartRepository = cartRepository;
        this.promotionRepository = promotionRepository;
        this.promotionEngineService = promotionEngineService;
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem cartItem) {

        return cartRepository.save(cartItem);
    }
    @GetMapping
    public List<CartItem> getCart(){

        return cartRepository.findAll();
    }
@PostMapping("/apply")
    public int applyPromotions(){
        List<CartItem> cart=cartRepository.findAll();
        List<Promotion> promotions=promotionRepository.findAll();

        return promotionEngineService.applyPromotions(cart,promotions);
    }
}
