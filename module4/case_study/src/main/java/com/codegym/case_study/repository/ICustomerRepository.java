package com.codegym.case_study.repository;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer where name like :keyword", nativeQuery=true)
    List<Customer> findCustomerByName(@Param("keyword") String nameCustomer);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    @Query(value="select * from customer", nativeQuery=true)
    public Page<Customer> findAll(Pageable pageable);
}
