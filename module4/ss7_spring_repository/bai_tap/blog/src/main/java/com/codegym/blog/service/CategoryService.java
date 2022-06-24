package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
     return iCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.iCategoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        this.iCategoryRepository.deleteById(id);
    }
}
