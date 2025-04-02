package com.promotionengine.promotion.service;

import com.promotionengine.promotion.model.CartItem;
import com.promotionengine.promotion.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PromotionEngineService {
    public int applyPromotions(List<CartItem> cart, List<Promotion> promotions) {
        Map<String, Integer> cartItems = new HashMap<>();
        int totalPrice = 0;

        for (CartItem item : cart) {
            cartItems.put(item.getProduct().getSku(), item.getQuantity());
            totalPrice += item.getProduct().getPrice() * item.getQuantity();
        }
        for (Promotion promo : promotions) {
            while (isApplicable(cartItems, promo)) {
                for (String sku : promo.getItems().keySet()) {
                    cartItems.put(sku, cartItems.get(sku) - promo.getItems().get(sku));
                }
                totalPrice -= calculateDiscount(cart, promo);
            }
        }
        return totalPrice;
    }


    private boolean isApplicable(Map<String, Integer> cartItems, Promotion promo) {
        for (Map.Entry<String, Integer> entry : promo.getItems().entrySet()) {
            if (cartItems.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private int calculateDiscount(List<CartItem> cart, Promotion promo) {
        int originalPrice = 0;

        for (CartItem item : cart) {
            if (promo.getItems().containsKey(item.getProduct().getSku())) {
                originalPrice += item.getProduct().getPrice() * promo.getItems().get(item.getProduct().getSku());
            }
        }
        return originalPrice - promo.getDiscountPrice();
    }

}
