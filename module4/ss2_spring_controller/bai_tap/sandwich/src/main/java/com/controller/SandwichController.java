package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    @GetMapping("/home")
    public String home(){
        return "save";
    }
    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model){
        List<String> stringList=new ArrayList<>();
        for (String s: condiment) {
            stringList.add(s);
        }
        model.addAttribute("condiment", stringList);
        return "save";
    }
}
