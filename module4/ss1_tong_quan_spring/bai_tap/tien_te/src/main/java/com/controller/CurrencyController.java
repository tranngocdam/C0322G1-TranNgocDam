package com.controller;

import com.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    private IService iService;
    @GetMapping(value = "/kq")

    public String goConvert() {
        return "result";
    }
    @GetMapping(value = "/result")
    public String Convert(@RequestParam double usd, @RequestParam double price, Model model) {
        double result1 = this.iService.currency(usd, price);
        model.addAttribute("result1", result1);
        return "result";
    }
}
