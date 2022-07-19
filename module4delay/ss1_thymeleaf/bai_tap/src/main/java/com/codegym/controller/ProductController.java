package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("products", iProductService.findAll());
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model) {
        model.addAttribute("products", new Product());
        return "/create";
    }

    @PostMapping(value = "/save")
    public String saveCreate(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(Product product) {
        iProductService.remove(product.getId());
        return "redirect:/product";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/found")
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("products", iProductService.findByName(name));
        return "list";
    }

    @GetMapping(value = "/{id}/view")
    public String display(@PathVariable Integer id, Model model){
        model.addAttribute("products", iProductService.findById(id));
        return "/view";
    }
}
