package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productMap;
    static {
        productMap= new HashMap<>();
        productMap.put(1, new Product(1, "kẹo", 56000.0, "hàng tốt", "Thăng Long"));
        productMap.put(2, new Product(2, "beer", 23400.0, "tốt", "larue"));
        productMap.put(3, new Product(3, "bánh ", 29820.0, "chuẩn", "Ngon Ngon"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
