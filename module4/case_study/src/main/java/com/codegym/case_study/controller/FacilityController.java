package com.codegym.case_study.controller;

import com.codegym.case_study.model.Facility;
import com.codegym.case_study.service.IFacilityService;
import com.codegym.case_study.service.IFacilityTypeService;
import com.codegym.case_study.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping
    public String showFacility(Model model) {
        model.addAttribute("iFacilityService", iFacilityService.findAll());
        model.addAttribute("iFacilityTypeService", iFacilityTypeService.findAll());
        model.addAttribute("iRentTypeService", iRentTypeService.findAll());
        return "facility/list";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("facilitys", new Facility());
        model.addAttribute("iFacilityTypeService", iFacilityTypeService.findAll());
        model.addAttribute("iRentTypeService", iRentTypeService.findAll());
        return "facility/create";
    }
}
