package com.code.blog.controller;

import com.code.blog.model.Blog;
import com.code.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String showHome(Model model){
        List<Blog> blogList=iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        iBlogService.delete(id);
        return "redirect:/blog";
    }
}
