package com.sprint2.service;

import com.sprint2.model.Customer;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    List<Customer> findAllCustomer();

    Customer findByUserId(Integer AppUserId);

    void edit(Integer id, Customer customer);
}
