package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    public List<Category> findAll();

    public Category findById(Integer id);

    void save(Category category);

    public void delete(Integer id);
}
