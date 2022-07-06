package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.repository.ICustomerRepository;
import com.codegym.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }
}
