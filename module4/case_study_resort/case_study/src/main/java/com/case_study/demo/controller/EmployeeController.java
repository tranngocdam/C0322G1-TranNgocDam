package com.case_study.demo.controller;

import com.case_study.demo.service.IDivisionService;
import com.case_study.demo.service.IEducationDegreeService;
import com.case_study.demo.service.IEmployeeService;
import com.case_study.demo.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
