package com.sprint2.service;

import com.sprint2.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAllCategory();

    Category findById(Integer id);
}
