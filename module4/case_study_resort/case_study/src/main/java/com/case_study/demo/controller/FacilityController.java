package com.case_study.demo.controller;

import com.case_study.demo.model.Facility;
import com.case_study.demo.service.IFacilityService;
import com.case_study.demo.service.IFacilityTypeService;
import com.case_study.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String showAllFacility(Model model, @PageableDefault(value = 2) Pageable pageable){
        model.addAttribute("facilitys", iFacilityService.findAll(pageable));
        return "facility/list";
    }

    @GetMapping("/villa")
    public String showCreatVilla(){
        return "facility/createVilla";
    }
    @PostMapping("/createVilla")
    public String saveCreateVilla(@ModelAttribute Facility facility){
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/house")
    public String showCreateHouse(Model model){
        model.addAttribute("facilitys", new Facility());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        return "facility/createHouse";
    }
    @PostMapping("/createHouse")
    private String savaCreateHouse(@ModelAttribute Facility facility){
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/room")
    public String showCreateRoom(){
        return "facility/createRoom";
    }
    @PostMapping("/createRoom")
    public String saveCreateRoom(@ModelAttribute Facility facility){
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(){
        return "facility/edit";
    }
}
