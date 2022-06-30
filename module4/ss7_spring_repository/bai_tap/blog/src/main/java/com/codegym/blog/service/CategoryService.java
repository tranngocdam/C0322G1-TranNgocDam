package com.codegym.blog.service;

import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public void saveOrUpdate(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> searchById(Long id, Pageable pageable) {
        return iCategoryRepository.searchById(id, pageable);
    }

    @Override
    public Page<Category> foundById(Integer id, Pageable pageable) {
        return iCategoryRepository.foundById(id, pageable);
    }
}
