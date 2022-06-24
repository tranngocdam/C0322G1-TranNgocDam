package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/blog")
    public String showHome(Model model){
        List<Blog> blogList=iBlogService.findAll();
        List<Category> categoryList=iCategoryService.findAll();
        model.addAttribute("blogList", new Blog());
        model.addAttribute("categoryList", categoryList);
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
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
