package com.example.shopweb.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Override
    public String toString() {
        return product.getName() + "/" + product.getId() + "/" + quantity + "/" + quantity * product.getPrice();
    }
}
