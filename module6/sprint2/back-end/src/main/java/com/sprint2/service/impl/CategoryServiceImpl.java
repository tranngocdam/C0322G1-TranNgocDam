package com.sprint2.service.impl;

import com.sprint2.model.Category;
import com.sprint2.repository.ICategotyRepository;
import com.sprint2.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategotyRepository iCategotyRepository;

    @Override
    public List<Category> findAllCategory() {
        return iCategotyRepository.findAllCategory();
    }

    @Override
    public Category findById(Integer id) {
        return iCategotyRepository.findById(id).orElse(null);
    }
}
