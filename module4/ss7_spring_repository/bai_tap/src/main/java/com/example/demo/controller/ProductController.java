package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public String showAll(@RequestParam Optional<String> name,
                          @PageableDefault(value = 3)Pageable pageable, Model model){
        String nameVal=name.orElse("");
//        Page<Product> product=iProductService.getAllByProducer(producer, pageable);
        model.addAttribute("product", this.iProductService.findAll(pageable));
        model.addAttribute("nameVal", nameVal);
        return "list";
    }

    @GetMapping(value = "/create")
    public String createShow(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveCreate(@ModelAttribute Product product){
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable Integer id,Model model){
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Product product){
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        iProductService.delete(id);
        return "redirect:/product";
    }
}
