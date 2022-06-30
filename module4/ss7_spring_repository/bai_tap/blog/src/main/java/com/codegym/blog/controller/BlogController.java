package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping("/blog")
    public String showHomepage(Optional<String> keyword, Optional<Long> category, Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogList = iBlogService.findAll(pageable);
        model.addAttribute("categoryList", iCategoryService.findAll());
        if (!keyword.isPresent() || keyword.get().equals("")) {
            if (!category.isPresent()) {
                model.addAttribute("blogList", iBlogService.findAll(pageable));
            } else {
                model.addAttribute("blogList", iCategoryService.searchById(category.get(), pageable));
                model.addAttribute("category", category.get());
            }
        } else if (!category.isPresent()) {
            model.addAttribute("keyword", keyword.get());
            model.addAttribute("blogList", iBlogService.findAllByAuthorContaining(keyword.get(), pageable));
        } else {
            model.addAttribute("blogList", iBlogService.searchByAuthorAndType(keyword.get(), category.get(), pageable));
        }
        return "/blog/list";
    }

    @GetMapping("/blog/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/blog/create";
    }

    @PostMapping("/blog/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.saveOrUpdate(blog);
        redirectAttributes.addFlashAttribute("createMsg", "Create or Update Successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit/{id}")
    public String showEdit(@PathVariable Integer id, Model model) {
        Optional<Blog> blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Delete Successfully!");
        return "redirect:/blog";
    }
}
