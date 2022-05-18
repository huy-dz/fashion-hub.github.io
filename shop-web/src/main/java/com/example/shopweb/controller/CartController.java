package com.example.shopweb.controller;

import com.example.shopweb.entity.CartItem;
import com.example.shopweb.entity.ProductEntity;
import com.example.shopweb.service.CartService;
import com.example.shopweb.service.CategoryService;
import com.example.shopweb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CategoryService categoryService;
    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("/view")
    public String showCart(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("count", cartService.getCount());
        model.addAttribute("cartItem", cartService.getCartItem());
        model.addAttribute("totalPrice", cartService.getAmount());
        return "cart";
    }

    @GetMapping("/add/{productId}")
    public String add(@PathVariable Long productId) {
        ProductEntity product = productService.findById(productId);

        if(product != null) {
            CartItem item = new CartItem();
            item.setProduct(product);
            item.setQuantity(1L);
            cartService.add(item);
        }
        return "redirect:/cart/view";
    }

    @GetMapping("/remove/{productId}")
    public String remove(@PathVariable Long productId) {
        cartService.remove(productId);
        return "redirect:/cart/view";
    }

    @PostMapping("/update")
    public String update(@RequestParam Long productId, @RequestParam Long quantity) {
        cartService.update(productId, quantity);
        return "redirect:/cart/view";
    }
}
