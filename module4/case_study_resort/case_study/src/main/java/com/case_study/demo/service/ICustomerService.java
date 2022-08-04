package com.case_study.demo.service;

import com.case_study.demo.model.Customer;
import com.case_study.demo.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void delele(Integer id);

    Page<Customer> searchCustomer(String name, Pageable pageable);
}
