package com.example.shopweb.controller;


import com.example.shopweb.entity.ProductEntity;
import com.example.shopweb.service.CategoryService;
import com.example.shopweb.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class HomeController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "index";
    }

    @GetMapping("/{categories}")
    public String showCategory(@PathVariable String categories, Model model, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 12);
        Page<ProductEntity> product = productService.findAllByCategory_Code(categories, pageable);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", product);

        return "product";
    }

    @GetMapping("/{categories}/{product}/")
    public String showProductDetail(@PathVariable String product, Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", productService.findByCode(product));
        return "product_detail";
    }

    @GetMapping("/search")
    public String searchView(Model model, @RequestParam("name") String name, @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 12);
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("product", productService.search(name, pageable));
        model.addAttribute("name", name);
        return "product";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
