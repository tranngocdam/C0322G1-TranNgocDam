package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

}
