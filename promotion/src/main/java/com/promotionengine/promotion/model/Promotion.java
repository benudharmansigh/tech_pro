package com.promotionengine.promotion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Entity
@Component
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "type")
    private String type;
    @Column(name = "discount_price")
    private int discountPrice;

    @Override
    public String toString() {
        return "Promotion{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                ", items=" + items +
                ", discountPrice=" + discountPrice +
                '}';
    }

    public Promotion() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Promotion(Long id, String type, Map<String, Integer> items, int discountPrice) {
        Id = id;
        this.type = type;
        this.items = items;
        this.discountPrice = discountPrice;
    }

    @ElementCollection
    private Map<String,Integer> items;

}
