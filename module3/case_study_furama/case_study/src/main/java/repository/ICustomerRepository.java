package repository;

import model.Customer;
import model.CustomerType;
import model.Employee;
import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICustomerRepository {
    public List<Customer> findAllCustomer();

    List<CustomerType> findAllCustomerType();

//    public void saveCustomer(Customer customer);

    public boolean deleteCustomer(int customer_id) throws SQLException;

    public boolean updateCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int customer_id);

    public List<Customer> findByName(String name);

    public Map<String, String> insertCustomer(Customer customer);
}
