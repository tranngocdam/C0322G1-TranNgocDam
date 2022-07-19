package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void remove (Integer id);

    List<Product> findByName(String name);

}
