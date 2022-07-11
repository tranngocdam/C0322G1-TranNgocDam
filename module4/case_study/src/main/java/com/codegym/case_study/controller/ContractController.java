package com.codegym.case_study.controller;

import com.codegym.case_study.dto.ContractDto;
import com.codegym.case_study.model.AttachFacility;
import com.codegym.case_study.model.Contract;
import com.codegym.case_study.model.ContractDetail;
import com.codegym.case_study.model.Facility;
import com.codegym.case_study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @GetMapping
    public String showContract(Model model,@PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("contracts", iContractService.findAll(pageable));
        model.addAttribute("customers", iCustomerService.findAll(pageable));
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("facilitys", iFacilityService.findAll(pageable));
//        model.addAttribute("contractDetai",iContractDetailService.findAll(pageable));
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacilitys", iAttachFacilityService.findAll());
        Page<ContractDto> contractDtoPage=this.iContractService.getContractDto(pageable);
        model.addAttribute("contractDto", contractDtoPage);
        return "contract/list";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model, Pageable pageable){
        model.addAttribute("contract", new Contract());
//        model.addAttribute("contract", iContractService.findAll(pageable));
        model.addAttribute("customers", iCustomerService.findAll(pageable));
        model.addAttribute("employees", iEmployeeService.findAll());
        model.addAttribute("facilitys", iFacilityService.findAll(pageable));
        model.addAttribute("attachDetails", new AttachFacility());
        return "/contract/create";
    }
    @PostMapping(value = "/create")
    public String createContract(@ModelAttribute Contract contract ){
        iContractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping(value = "/createDetail")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail ){
        iContractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
}
