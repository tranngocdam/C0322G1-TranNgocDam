package com.codegym.case_study.controller;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
@Controller
@RequestMapping(value = "customerFacility")
public class CustomerFacilityController {
    @Autowired
    private ICustomerService iCustomerService;
    @GetMapping
    public String  showListCustomerFacility(@PageableDefault(value = 3) Pageable pageable, Model model ) {
        Page<Customer> customerList = iCustomerService.findAllByDate(pageable);
        model.addAttribute("customerList", customerList);
        return "customerFacility";
    }
}
