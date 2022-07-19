package com.codegym.controller;

import com.codegym.model.Declaration;
import com.codegym.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/declaration")
public class DeclarationController {
    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("declarations", iDeclarationService.findAll());
        return "/list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("declaration", new Declaration());
        return "/create";
    }

    @PostMapping(value = "/save")
    public String saveCreate(Declaration declaration){
        iDeclarationService.save(declaration);
        return "redirect:/declaration";
    }
    @GetMapping(value = "/edit/{id}")
    public String showEdit(@PathVariable("id") Integer id, Model model) {
        Declaration declaration = iDeclarationService.findById(id);
        model.addAttribute("declaration", declaration);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Declaration declaration) {
        iDeclarationService.save(declaration);
        return "redirect:/declaration";
    }
}
