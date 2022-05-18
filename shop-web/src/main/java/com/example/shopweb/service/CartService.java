package com.example.shopweb.service;

import com.example.shopweb.entity.CartItem;

import java.util.Collection;

public interface CartService {

    void add(CartItem item);

    void remove(Long productId);

    Collection<CartItem> getCartItem();

    void update(Long productId, Long quantity);

    int getCount();

    Long getAmount();


}
