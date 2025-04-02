package com.promotionengine.promotion.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @Column(name = "product_sku")
    private Product product;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartItem(Long id, Product product, int quantity) {
        Id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public CartItem() {
    }



    @Override
    public String toString() {
        return "CartItem{" +
                "Id=" + Id +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }


}
