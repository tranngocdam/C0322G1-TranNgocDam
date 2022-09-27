package com.case_study.demo.controller;

import com.case_study.demo.dto.CustomerDto;
import com.case_study.demo.model.Customer;
import com.case_study.demo.model.CustomerType;
import com.case_study.demo.service.ICustomerService;
import com.case_study.demo.service.ICustomerTypeService;
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

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("")
    public String showCustomer(@RequestParam(name = "name", defaultValue = "") String name,
                               @PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Customer> customers = iCustomerService.searchCustomer(name, pageable);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/createCustomer")
    private String saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypes", customerTypeList);
            return "customer/create";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEditCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customerDto", iCustomerService.findById(id));
        model.addAttribute("customerTypes", iCustomerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String saveEditCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                   BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerTypes", customerTypeList);
            return "customer/edit";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        iCustomerService.delele(id);
        return "redirect:/customer";
    }
}
