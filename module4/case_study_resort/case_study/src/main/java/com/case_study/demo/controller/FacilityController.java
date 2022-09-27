package com.case_study.demo.controller;

import com.case_study.demo.dto.FacilityDto;
import com.case_study.demo.model.Facility;
import com.case_study.demo.model.FacilityType;
import com.case_study.demo.model.RentType;
import com.case_study.demo.service.IFacilityService;
import com.case_study.demo.service.IFacilityTypeService;
import com.case_study.demo.service.IRentTypeService;
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

import javax.validation.Valid;
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

    @GetMapping("")
    public String showAllFacility(@RequestParam(value = "keyword", defaultValue = "") String name,
                                  Model model, @PageableDefault(value = 4) Pageable pageable){
        Page<Facility> facilities=iFacilityService.findNameFacility(name, pageable);
        model.addAttribute("facilitys", facilities);
        return "facility/list";
    }

    @GetMapping("/create")
    public String showCreatFacility(Model model){
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("rentTypes", iRentTypeService.findAll());
        model.addAttribute("facilityTypes", iFacilityTypeService.findAll());
        return "facility/create";
    }
    @PostMapping("/create")
    public String saveCreateFacility(@Validated @ModelAttribute FacilityDto facilityDto,BindingResult bindingResult,
                                      Model model){
        new FacilityDto().validate(facilityDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            List<RentType> rentTypes=iRentTypeService.findAll();
            model.addAttribute("rentTypes", rentTypes);
            List<FacilityType> facilityTypes=iFacilityTypeService.findAll();
            model.addAttribute("facilityTypes", facilityTypes);
            return "facility/create";
        }
        Facility facility=new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
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
