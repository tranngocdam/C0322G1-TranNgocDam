package com.codegym.demo.repository;

import com.codegym.demo.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
