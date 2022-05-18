package com.example.shopweb.controller;

import com.example.shopweb.entity.BillEntity;
import com.example.shopweb.entity.CartItem;
import com.example.shopweb.repository.BillRepo;
import com.example.shopweb.service.CartService;
import com.example.shopweb.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
@AllArgsConstructor
public class CheckoutController {
    private final BillRepo billRepo;
    private final CartService cartService;
    private final CategoryService categoryService;

    @GetMapping("/checkout")
    public String viewCheckout(Model model) {
        BillEntity bill = new BillEntity();
        Collection<CartItem> list = cartService.getCartItem();
        model.addAttribute("listCart", list);
        model.addAttribute("order", bill);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("cartItem", cartService.getCartItem());
        model.addAttribute("totalPrice", cartService.getAmount());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String checkout(@ModelAttribute("order") BillEntity bill) {
        Collection<CartItem> list = cartService.getCartItem();
        String temp="";
        Long totalPrice = 0L;
        for (CartItem i:list) {
            temp += (i.toString() + "\n");
            totalPrice += i.getProduct().getPrice();
        }
        bill.setItem(temp);
        bill.setTotalPrice(totalPrice);
        billRepo.save(bill);
        list.removeAll(list);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String orderSuccess(Model model) {
        model.addAttribute("category", categoryService.findAll());

        return "thanks";
    }
}
