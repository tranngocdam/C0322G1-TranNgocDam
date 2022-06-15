package service.impl;

import model.Customer;
import model.CustomerType;
import repository.ICustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerRepository iCustomerRepository=new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAllCustomer() {
        return iCustomerRepository.findAllCustomer();
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return iCustomerRepository.findAllCustomerType();
    }

//    @Override
//    public void saveCustomer(Customer customer){
//        this.iCustomerRepository.saveCustomer(customer);
//    }

    @Override
    public boolean deleteCustomer(int customer_id) throws SQLException {
      return   this.iCustomerRepository.deleteCustomer(customer_id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return iCustomerRepository.updateCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int customer_id) {
        return iCustomerRepository.selectCustomer(customer_id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return iCustomerRepository.findByName(name);
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) throws SQLException {
        return iCustomerRepository.insertCustomer(customer);
    }

}
