package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryService iCategoryService;
    @Override
    public List<Category> findAll() {
        return iCategoryService.findAll();
    }

    @Override
    public Category findById(Integer id) {
     return   this.iCategoryService.findById(id);
    }

    @Override
    public void save(Category category) {
        this.iCategoryService.save(category);
    }

    @Override
    public void delete(Integer id) {
        this.iCategoryService.delete(id);
    }
}
