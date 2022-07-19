package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "coca", 56000.0, "loai1", "coca"));
        products.put(2, new Product(2, "beer", 34500.0, "loai3", "larue"));
        products.put(3, new Product(3, "laptop", 98000.0, "loai2", "intel"));
        products.put(4, new Product(4, "tiger", 76333.0, "loai1", "tiger"));
        products.put(5, new Product(5, "pepsi", 56400.0, "loai4", "pepsi"));
        products.put(6, new Product(6, "volka", 67643.0, "loai2", "hanoi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getNameProduct().contains(name)){
                productList.add(product);
            }
        }
        return productList;
    }
}
