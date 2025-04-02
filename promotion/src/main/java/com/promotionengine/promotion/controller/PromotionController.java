package com.promotionengine.promotion.controller;

import com.promotionengine.promotion.model.Promotion;
import com.promotionengine.promotion.repository.PromotionRepository;
import com.promotionengine.promotion.service.PromotionEngineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionRepository promotionRepository;

    public PromotionController( PromotionRepository promotionRepository){
        this.promotionRepository=promotionRepository;
    }
    @PostMapping("/add")
    public Promotion addPromotion(@RequestBody Promotion promotion){

        return promotionRepository.save(promotion);
    }
    @GetMapping
    public List<Promotion> getPromotions(){

        return promotionRepository.findAll();
    }
    }
