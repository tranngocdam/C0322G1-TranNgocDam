package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showAll(Model model,
                          @PageableDefault(value = 3)Pageable pageable){
        model.addAttribute("product", iProductService.findAll(pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String createShow(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveCreate(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult){
        new ProductDto().validate(productDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "create";
        }
        Product product=new Product();
        BeanUtils.copyProperties(productDto, product);
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

//    @GetMapping(value = "/search")
//    public String search(@PageableDefault(value = 2) Pageable pageable,
//                         @RequestParam Optional<String> keyword, Model model){
//        String keywordVal=keyword.orElse("");
//        model.addAttribute("product", iProductService.getAllByProducer(keywordVal, pageable ));
//        model.addAttribute("keywordVal", keywordVal);
//        return "list";
//    }
}
