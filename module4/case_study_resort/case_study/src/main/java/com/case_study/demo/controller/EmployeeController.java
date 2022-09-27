package com.case_study.demo.controller;

import com.case_study.demo.dto.CustomerDto;
import com.case_study.demo.model.Customer;
import com.case_study.demo.model.CustomerType;
import com.case_study.demo.model.Employee;
import com.case_study.demo.service.IDivisionService;
import com.case_study.demo.service.IEducationDegreeService;
import com.case_study.demo.service.IEmployeeService;
import com.case_study.demo.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping("")
    public String showEmployee(Pageable pageable, Model model){
        model.addAttribute("employees", iEmployeeService.findAll(pageable));
        return "employee/list";
    }

    @GetMapping("/create")
    public String showCreateCustomer(Model model) {
        model.addAttribute("employees", new Employee());
        model.addAttribute("positions", iPositionService.findAll());
        model.addAttribute("educationDegrees", iEducationDegreeService.findAll());
        model.addAttribute("divisions", iDivisionService.findAll());
        return "customer/create";
    }

    @PostMapping("/createCustomer")
    private String saveCustomer( @ModelAttribute Employee employee) {
    iEmployeeService.save(employee);
        return "redirect:/employee";
    }
}
