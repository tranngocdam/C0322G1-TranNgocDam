package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    public Page<Category> findAll(Pageable pageable);

    public void saveOrUpdate(Category category);

    public void delete(Integer id);

    public Optional<Category> findById(Integer id);

    public List<Category> findAll();

    public Page<Category> searchById(Long id, Pageable pageable);

    public Page<Category> foundById(Integer id, Pageable pageable);

}
