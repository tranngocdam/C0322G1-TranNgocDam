package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository iCustomerRepository = new CustomerRepository();

    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
    public void save(Customer customer){
        this.iCustomerRepository.save(customer);
    }
    public Customer findById(int id) {
        return this.iCustomerRepository.findById(id);
    }
    public void update(int id, Customer customer){
        this.iCustomerRepository.update(id, customer);
    }
    public void remove(int id){
        this.iCustomerRepository.remove(id);
    }
}
