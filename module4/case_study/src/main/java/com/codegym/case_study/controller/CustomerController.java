package com.codegym.case_study.controller;

import com.codegym.case_study.dto.CustomerDto;
import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.CustomerType;
import com.codegym.case_study.model.Facility;
import com.codegym.case_study.service.ICustomerService;
import com.codegym.case_study.service.ICustomerTypeService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @GetMapping
    public String showCustomer(@RequestParam Optional<String>keyword, @PageableDefault(value = 5) Pageable pageable, Model model) {
        String keywordVal=keyword.orElse("");
            model.addAttribute("customers",this.iCustomerService.findCustomerByName(keywordVal, pageable) );
            model.addAttribute("iCustomerTypeService", iCustomerTypeService.findAll());
            model.addAttribute("keywordVal", keywordVal);
        return "customer/list";
    }

    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model){
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", customerTypeList);
        return "/customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes,
                                 Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
            model.addAttribute("customerType", customerTypeList);
            return "customer/create";
        }
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("createSC",  "Create Sucessfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        Customer customer=iCustomerService.findById(id);
        model.addAttribute("customer",customer);
//        model.addAttribute("customerType", iCustomerTypeService);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String Edit(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("editSE","Edit Sucessfully!");
        return "redirect:/customer";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("deleteSD","Delete Sucessfully!");
        return "redirect:/customer";
    }
}
