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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String findAll(Model model){
       model.addAttribute("userList",iUserService.findAll());
        return "user/list";
    }
    @GetMapping("create")
    public String showCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "user/create";
    }
    @PostMapping("/create")
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
