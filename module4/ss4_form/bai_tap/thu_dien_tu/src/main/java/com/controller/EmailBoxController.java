package com.controller;

import com.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("email/")
public class EmailBoxController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm (ModelMap model){
        model.addAttribute("email", new Email());
        return "email/save";
    }
    @RequestMapping(value = "addEmail", method = RequestMethod.POST)
    public String update(@ModelAttribute("email") Email email, ModelMap model){
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pagesize", email.getPageSize());
        model.addAttribute("spamsfilter", email.getSpamsFilter());
        model.addAttribute("singnature", email.getSignature());
        return "email/info";
    }
}
