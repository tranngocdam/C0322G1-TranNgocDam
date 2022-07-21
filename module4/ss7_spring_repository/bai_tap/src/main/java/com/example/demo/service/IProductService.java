package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Product findById(Integer id);

    void delete(Integer id);

//    Page<Product> getAllByProducer(String producer, Pageable pageable);
}
