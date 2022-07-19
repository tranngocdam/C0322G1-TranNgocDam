package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productMap;
//    private static List<Product> products;
    static {
        productMap=new HashMap<>();
        productMap.put(1, new Product(1, "ip4", 454000.44, "apple"));
        productMap.put(2, new Product(2, "beer", 120000.0, "larue"));
        productMap.put(3, new Product(3, "ip12", 3456700.0, "apple"));
        productMap.put(4, new Product(4, "laptop", 5445400.0, "dell"));
        productMap.put(5, new Product(5, "ip5", 546456.0, "ip"));
        productMap.put(6, new Product(6, "laptop hp", 587400.0, "hp"));
        productMap.put(7, new Product(7, "ip7", 98900.0, "ip"));
        productMap.put(8, new Product(8, "laptop g4", 5445400.0, "intel"));
        productMap.put(9, new Product(9, "tiger", 8788400.0, "tiger"));
        productMap.put(10, new Product(10, "laptop dell 87", 5445400.0, "dell"));
//        products=new ArrayList<>();
//        products.add(new Product(1, "ip2", 32332.0, "apple"));
//        products.add(new Product(2, "ip12", 65332.0, "apple"));
//        products.add(new Product(3, "laptop dell", 5632.0, "dell"));
//        products.add(new Product(4, "tiger", 32332.0, "tiger"));
//        products.add(new Product(5, "ip6", 32332.0, "apple"));
//        products.add(new Product(6, "ip7", 32332.0, "apple"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList=new ArrayList<>();
        for (Product p: productMap.values()) {
            if(p.getName().contains(name)){
                productList.add(p);
            }
        }
        return productList;
    }

}
