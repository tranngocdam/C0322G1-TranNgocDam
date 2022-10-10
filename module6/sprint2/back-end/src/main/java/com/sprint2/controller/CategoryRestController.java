package com.sprint2.controller;

import com.sprint2.model.Category;
import com.sprint2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryRestController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/list")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categoryList = iCategoryService.findAllCategory();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        Category category = this.iCategoryService.findById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
