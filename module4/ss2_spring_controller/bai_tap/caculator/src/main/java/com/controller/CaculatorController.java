package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/home")
    public String goHome(){
        return "result";
    }
    @GetMapping("/result")
    public String caculator(@RequestParam double number1, double number2, String formula, Model model){
        double result1=0;
        switch (formula){
            case "+":
                result1=number1+number2;
                break;
            case "-":
                result1=number1-number2;
                break;
            case "*":
                result1=number1*number2;
                break;
            case "/":
                result1=number1/number2;
        }
        model.addAttribute("result1", result1);
        return "result";
    }
}
