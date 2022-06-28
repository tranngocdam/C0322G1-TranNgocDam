package com.form.controller;

import com.form.dto.UserDto;
import com.form.model.User;
import com.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("/user")
    public ModelAndView findAll(){
        ModelAndView modelAndView=new ModelAndView("/user/list");
        modelAndView.addObject("userList", iUserService.findAll());
        return modelAndView;
    }
    @GetMapping("/user/create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }
    @PostMapping("/user/create")
    public String create(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.saveOrUpdate(user);
        redirectAttributes.addFlashAttribute("SaveSC","Add or Update Successfully!");
        return "redirect:/user";
    }
}
