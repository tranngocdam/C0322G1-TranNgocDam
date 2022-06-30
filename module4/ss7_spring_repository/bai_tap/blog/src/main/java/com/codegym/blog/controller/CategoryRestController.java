package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
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

import java.util.Optional;

@RequestMapping(value = "/categoryRest")
@RestController
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    public ResponseEntity<Page<Category>> getPageCategory(@PageableDefault(value=2) Pageable pageable){
        Page<Category> page=this.iCategoryService.findAll(pageable);
        if(!page.hasContent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Integer id){
        Optional<Category> categoryOptional=iCategoryService.findById(id);
        if(!categoryOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }
}
