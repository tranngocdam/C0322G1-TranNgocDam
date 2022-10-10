package com.sprint2.repository;

import com.sprint2.model.Company;
import com.sprint2.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDiscountRepository extends JpaRepository<Discount, Integer> {
    @Query(value = "select * from discount where status=0", nativeQuery = true)
    List<Discount> findAllDiscount();

    @Query(value = "select * from discount where id = :id", nativeQuery = true)
    Discount findByIdDiscount(@Param("id") Integer id);
}
