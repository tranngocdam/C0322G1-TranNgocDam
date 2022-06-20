package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IProductServiceImpl implements IProductService {
    private static final Map<String, Product> products;

    static {
        products=new HashMap<>();
        products.put("1", new Product("1", "cacao", "12000", "usa"));
        products.put("2", new Product("2", "bq ", "342323", "nv"));
        products.put("3", new Product("3", "beer", "345000", "larue"));
        products.put("4", new Product("4", "pepsi", "143420", "pepsi"));
        products.put("5", new Product("5", "coca", "34434", "coca"));
        products.put("6", new Product("6", "rice", "14232", "vn"));
        products.put("7", new Product("7", "cafe", "442422", "trungnguyen"));
        products.put("8", new Product("8", "redbull", "12310", "aqafina"));
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
    public Product findById(String id) {
        return products.get(id);
    }

    @Override
    public void update(String id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(String id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> product=new ArrayList<>();
        for (Product p : products.values()) {
            if(p.getName().contains(name)){
                product.add(p);
            }
        }
        return product;
    }


}
