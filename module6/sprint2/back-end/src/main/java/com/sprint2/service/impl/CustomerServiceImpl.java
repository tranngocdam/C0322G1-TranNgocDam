package com.sprint2.service.impl;

import com.sprint2.model.Customer;
import com.sprint2.repository.ICustomerRepository;
import com.sprint2.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findByUserId(Integer AppUserId) {
        return iCustomerRepository.findByUserId(AppUserId);
    }


    @Override
    public void edit(Integer id, Customer customer) {
        iCustomerRepository.editCustomer(customer.getAddress(), customer.getDayOfBirth(),
                customer.getEmail(), customer.getName(), customer.getPhone(), customer.getId());
    }
}
