package com.case_study.demo.controller;

import com.case_study.demo.model.Facility;
import com.case_study.demo.service.IFacilityService;
import com.case_study.demo.service.IFacilityTypeService;
import com.case_study.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showAllFacility(@RequestParam(value = "keyword", defaultValue = "") String name,
                                  Model model, @PageableDefault(value = 4) Pageable pageable){
        Page<Facility> facilities=iFacilityService.findNameFacility(name, pageable);
        model.addAttribute("facilitys", facilities);
        return "facility/list";
    }

    @GetMapping("/villa")
    public String showCreatVilla(Model model){
        model.addAttribute("facilitys", new Facility());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
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
    public String showCreateRoom(Model model){
        model.addAttribute("facilitys", new Facility());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        return "facility/createRoom";
    }
    @PostMapping("/createRoom")
    public String saveCreateRoom(@ModelAttribute Facility facility){
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model){
        model.addAttribute("facilitys", iFacilityService.findById(id));
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        return "facility/edit";
    }
    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute Facility facility){
        iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @GetMapping("/delete/{id}")
    public String deleteFacility(@PathVariable Integer id){
        iFacilityService.delete(id);
        return "redirect:/facility";
    }
}
