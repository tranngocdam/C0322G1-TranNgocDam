package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.IProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/product/create")
    public String save(@ModelAttribute Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("product/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "/edit";
    }

    @PostMapping("product/edit")
    public String edit(@ModelAttribute Product product){
        iProductService.edit(product);
        return "redirect:/product";
    }

    @GetMapping("product/{id}/delete")
    public String delete(@PathVariable Integer id){
        iProductService.delete(id);
        return "redirect:/product";
    }

}
