package com.example.shopweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code", insertable = false, updatable = false)
    private String code;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private Long price;

    @Column(name = "image")
    private String img;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems;
}
