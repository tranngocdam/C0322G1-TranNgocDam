package com.case_study.demo.service.impl;

import com.case_study.demo.model.Customer;
import com.case_study.demo.model.CustomerType;
import com.case_study.demo.repository.ICustomerRepository;
import com.case_study.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAllCustomer(pageable);
    }

//    @Override
//    public void save(Customer customer) {
//        iCustomerRepository.save(customer);
//    }
    @Override
    public void save(Customer customer) {
        iCustomerRepository.saveCustomer(customer.getAddress(), customer.getDayOfBirth(),customer.getEmail(),
                customer.getGender(), customer.getIdCard(), customer.getName(), customer.getPhoneNumber(), customer.getCustomerType());
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findByIdCustomer(id);
    }

    @Override
    public void delele(Integer id) {
        this.iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public Page<Customer> searchCustomer(String name, Pageable pageable) {
        return iCustomerRepository.findCustomerByName("%"+ name + "%", pageable);
    }
}
