package com.codegym.case_study.service;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.model.Facility;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    void delete(Integer id);
}
