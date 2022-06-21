package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.IProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private final IProductService iProductService=new IProductServiceImpl();
    @GetMapping("/product")
    public String findAll(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }
    @GetMapping("/product/create")
    public String showCreate(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }
    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }
//@GetMapping("/product/create")
//public String create(Model model) {
//    model.addAttribute("products", new Product());
//    return "/create";
//}
//
//    @PostMapping("/product/save")
//    public String save(Product product) {
//        iProductService.save(product);
//        return "redirect:/product";
//    }
}
