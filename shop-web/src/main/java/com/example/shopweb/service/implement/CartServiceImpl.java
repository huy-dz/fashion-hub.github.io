package com.example.shopweb.service.implement;

import com.example.shopweb.entity.CartItem;
import com.example.shopweb.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    private Map<Long, CartItem> map = new HashMap<>();

    @Override
    public void add(CartItem item) {
        CartItem existedItem = map.get(item.getProduct().getId());
        if(existedItem != null) {
            existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
        } else {
            map.put(item.getProduct().getId(), item);
        }
    }

    @Override
    public void remove(Long productId) {
        map.remove(productId);
    }

    @Override
    public Collection<CartItem> getCartItem() {
        return map.values();
    }

    @Override
    public void update(Long productId, Long quantity) {
        CartItem item = map.get(productId);

        item.setQuantity(quantity + item.getQuantity());

        if(item.getQuantity() <= 0) {
            map.remove(productId);
        }
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Long getAmount() {
        return map.values().stream().mapToLong(item->item.getQuantity() * item.getProduct().getPrice()).sum();
    }
}
