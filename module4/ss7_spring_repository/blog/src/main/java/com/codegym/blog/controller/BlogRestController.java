package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/blog/api/v1")
@CrossOrigin
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getBlogId(@PathVariable Integer id) {
        Blog blogs = iBlogService.findById(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Blog>> searchTitle(@PathVariable Optional<String> title){
        String searchTitle=title.orElse("");
        List<Blog> blog = iBlogService.findTitle("%"+searchTitle+"%");
        if (blog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
