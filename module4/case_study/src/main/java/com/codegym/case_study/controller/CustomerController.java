package com.codegym.case_study.controller;

import com.codegym.case_study.model.Facility;
import com.codegym.case_study.service.ICustomerService;
import com.codegym.case_study.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @GetMapping
    public String showCustomer(Model model) {
            model.addAttribute("iCustomerService", iCustomerService.findAll());
            model.addAttribute("iCustomerTypeService", iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model){

        return "/customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {

        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {

        return "customer/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
            iCustomerService.delete(id);
        return "redirect:customer";
    }

}
