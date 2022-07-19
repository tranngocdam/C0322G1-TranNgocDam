package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void remove (Integer id);

    List<Product> findByName(String name);

}
