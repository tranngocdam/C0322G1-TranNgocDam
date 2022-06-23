package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("/blog")
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

    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/edit";
    }
    @PostMapping("/blog/edit")
    public String edit(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("blog/{id}/delete")
    public String delete(@PathVariable Integer id){
        iBlogService.delete(id);
        return "redirect:/blog";
    }
}
