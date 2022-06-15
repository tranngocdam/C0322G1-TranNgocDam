package com.controller;

import com.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Distionary {
    @Autowired
    private IService iService;

    @GetMapping("/dis")
    public String goCheck() {
        return "result";
    }
    @GetMapping("/result")
public String distionary( @RequestParam String name1, Model model){
        String result1=this.iService.checkWord(name1);
        model.addAttribute("result1", result1);
        return "result";
    }
}
