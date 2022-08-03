package com.case_study.demo.controller;

import com.case_study.demo.model.Customer;
import com.case_study.demo.service.ICustomerService;
import com.case_study.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showCustomer(
//            @RequestParam(name = "name") String name,
//                               @RequestParam(name = "customerType", defaultValue = "") String customerType,
                               @PageableDefault(value = 3) Pageable pageable, Model model){

//        Page<Customer>customers=iCustomerService.searchCustomer(name, customerType, pageable);
//        model.addAttribute("name", name);
//        model.addAttribute("customerType", customerType);
        model.addAttribute("customers", iCustomerService.findAll(pageable));
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model){
        model.addAttribute("customers", new Customer());
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/create";
    }
    @PostMapping("/createCustomer")
    private String saveCustomer(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customers", iCustomerService.findById(id));
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String saveEditCustomer(@ModelAttribute Customer customer){
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        iCustomerService.delele(id);
        return "redirect:/customer";
    }
}
