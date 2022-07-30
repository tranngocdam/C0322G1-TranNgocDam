package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showAll( @PageableDefault(value = 4) @SortDefault(value = "day_start", direction = Sort.Direction.ASC)
                            Pageable pageable,
                           @RequestParam(name = "name", defaultValue = "") String title,Model model){
//        Page<Blog> blogs=iBlogService.findTitle(title, pageable);
        model.addAttribute("blog", iBlogService.findAll(pageable));
        model.addAttribute("category", iCategoryService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categorys", iCategoryService.findAll());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveCreate(@ModelAttribute Blog blog){
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id){
        iBlogService.delete(id);
        return "redirect:/blog";
    }
}
