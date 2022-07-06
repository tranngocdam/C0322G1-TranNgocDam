package com.codegym.case_study.repository;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="select * from customer", nativeQuery=true)
    public List<Customer> findAll();
}
