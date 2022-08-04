package com.case_study.demo.controller;

import com.case_study.demo.model.AttachFacility;
import com.case_study.demo.model.Contract;
import com.case_study.demo.model.ContractDetail;
import com.case_study.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;
    @GetMapping("")
    public String showContract(Model model, Pageable pageable){
        model.addAttribute("contracts", iContractService.findAll(pageable));
        model.addAttribute("contractDetails", new ContractDetail());
        model.addAttribute("attachFacilitys", iAttachFacilityService.findAll());
        return "contract/list";
    }

    @GetMapping("/createContract")
    public String createContract(Model model, Pageable pageable){
        model.addAttribute("contracts", new Contract());
        model.addAttribute("employees", iEmployeeService.findAll(pageable));
        model.addAttribute("customers", iCustomerService.findAll(pageable));
        model.addAttribute("contractDetails", new ContractDetail());
        model.addAttribute("facilitys",iFacilityService.findAll(pageable));
        model.addAttribute("attachFacilitys", iAttachFacilityService.findAll());
        return "contract/create";
    }
    @PostMapping("/create")
    public String saveCreateContract(@ModelAttribute Contract contract){
        iContractService.save(contract);
        return "redirect:/contract";
    }

    @PostMapping("/contractDetail")
    public String createContractDetail(@ModelAttribute ContractDetail contractDetail){
        iContractDetailService.save(contractDetail);
        return "redirect:/contract";
    }
//    @PostMapping(value = "/createDetail")
//    public String createContractDetails(@ModelAttribute ContractDetail contractDetail ){
//        iContractDetailService.save(contractDetail);
//        return "redirect:/contract/list";
//    }
}
