package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.deleteById(id);
    }

//    @Override
//    public Page<Product> getAllByProducer(String producer, Pageable pageable) {
//        return iProductRepository.findAllProduccerContaining(producer, pageable);
//    }


}
