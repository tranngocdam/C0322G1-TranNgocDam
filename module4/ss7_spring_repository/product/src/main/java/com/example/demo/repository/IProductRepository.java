package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value="select  * from product where producer like :keyword", nativeQuery=true)
    Page<Product> findAllProduccerContaining(@Param("keyword") String name, Pageable pageable);
    //    List<Product> getAllByProducer(@Param("keyword") String abc);
}
