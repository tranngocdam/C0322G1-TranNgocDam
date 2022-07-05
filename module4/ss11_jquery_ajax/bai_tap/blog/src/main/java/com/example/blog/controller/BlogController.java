package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value="/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlog(Model model,
                           @PageableDefault(value = 2) Pageable pageable,
                           @RequestParam(name = "keyword") Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        model.addAttribute("listBlog", this.blogService.findAllByName(keywordVal, pageable));
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "/list";
    }
    @GetMapping("/create")
    public String showCreate(Blog blog, Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "create";
    }
    @PostMapping("/create")
    public String getCreate(Blog blog){
        this.blogService.save(blog);
        return "redirect:/blog";
    }
    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id, Model model){
        model.addAttribute("blog",this.blogService.getBlog(id));
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "/edit";
    }
    @PostMapping("/edit")
    public String getEdit(Blog blog){
        this.blogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("{id}/delete")
    public String showDelete(@PathVariable int id){
        blogService.delete(id);
        return "redirect:/blog";
    }
}
