package com.codegym.case_study.service.impl;

import com.codegym.case_study.model.Customer;
import com.codegym.case_study.repository.ICustomerRepository;
import com.codegym.case_study.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findCustomerByName(String keyword, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(keyword, pageable);
    }

    @Override
    public Page<Customer> findAllByDate( Pageable pageable) {
        return iCustomerRepository.findAllByDate( pageable);
    }
}
