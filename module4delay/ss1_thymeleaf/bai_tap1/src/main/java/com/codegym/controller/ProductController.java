package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public String showAll(Model model){
        model.addAttribute("product", iProductService.findAll());
        return "list";
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteProduct( Product product){
        iProductService.remove(product.getId());
        return "redirect:/product";
    }

    @GetMapping("/find")
    public String findByName(@RequestParam String name, Model model){
        model.addAttribute("product", iProductService.findByName(name));
        return "list";
    }
}
