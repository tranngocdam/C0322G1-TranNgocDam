package com.codegym.case_study.controller;

import com.codegym.case_study.model.Facility;
import com.codegym.case_study.service.IDivisionService;
import com.codegym.case_study.service.IEducationDegreeService;
import com.codegym.case_study.service.IEmployeeService;
import com.codegym.case_study.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IDivisionService iDivisionService;

    @GetMapping
    public String showCustomer(Model model) {
        model.addAttribute("iEmployeeService", iEmployeeService.findAll());
        model.addAttribute("iPositionService", iPositionService.findAll());
        model.addAttribute("iEducationDegreeService", iEducationDegreeService.findAll());
        model.addAttribute("iDivisionService", iDivisionService.findAll());
        return "employee/list";
    }

    @GetMapping(value = "/create")
    public String showCreateHouse(Model model){
        return "/employee/create";
    }

    @PostMapping("/create")
    public String createHouse(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {

        return "redirect:/employee";
    }
}
