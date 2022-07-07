package com.codegym.case_study.controller;

import com.codegym.case_study.service.IContractService;
import com.codegym.case_study.service.ICustomerService;
import com.codegym.case_study.service.IEmployeeService;
import com.codegym.case_study.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping
    public String showCustomer(Model model) {
        model.addAttribute("iContractService", iContractService.findAll());
        model.addAttribute("iCustomerService", iCustomerService.findAll());
        model.addAttribute("iEmployeeService", iEmployeeService.findAll());
        model.addAttribute("iFacilityService", iFacilityService.findAll());
        return "contract/list";
    }
    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model){

        return "/contract/create";
    }
}
