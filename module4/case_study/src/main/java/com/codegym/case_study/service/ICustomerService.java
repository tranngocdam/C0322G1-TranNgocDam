package com.codegym.case_study.service;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);

    Page<Customer> findCustomerByName(String keyword, Pageable pageable);

    Page<Customer> findAllByDate( Pageable pageable);
}
