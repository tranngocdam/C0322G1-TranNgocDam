package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;
//    @GetMapping
//    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value=3) Pageable pageable){
//        Page<Blog> page=this.iBlogService.findAll(pageable);
//        if(!page.hasContent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(page, HttpStatus.OK);
//    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id){
//        Optional<Blog> blogOptional=iBlogService.findById(id);
//        if(!blogOptional.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
//    }
}
