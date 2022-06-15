package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.ICustomerRepository;
import validate.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements ICustomerRepository {
    public static final String SELECT_FROM_CUSTOMER = "select * from customer";
    public static final String INSERT_INTO_CUSTOMER = "insert into customer(customer_type_id, customer_name, " +
            " customer_birthday, customer_gender, customer_id_card, customer_phone, " +
            " customer_email, customer_address) value (?,?,?,?,?,?,?,?)";
    public static final String SELECT_FROM_CUSTOMER_TYPE = "select * from customer_type";
    public static final String DELETE_FROM_CUSTOMER = "delete from customer where customer_id=?;";
    public static final String UPDATE_CUSTOMER_BY_ID = "update customer set" +
            " customer_type_id=?, customer_name=?, customer_birthday=?, " +
            " customer_gender=?, customer_id_card=?, customer_phone=?, " +
            " customer_email=?, customer_address=? where customer_id=?;";
    public static final String SELECT_FROM_CUSTOMER_WHERE_CUSTOMER_ID = "select * from customer where customer_id=?;";
    public static final String SELECT_CUSTOMER_BY_NAME = "select * from customer " +
            " where customer_name like ?";

    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday,
                        customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
                customers.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> customerTypes = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(customerTypeId, customerTypeName);
                customerTypes.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypes;
    }

//    @Override
//    public void saveCustomer(Customer customer) {
//        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
//            preparedStatement.setInt(1, customer.getCustomerId());
//            preparedStatement.setInt(2, customer.getCustomerTypeId());
//            preparedStatement.setString(3, customer.getCustomerName());
//            preparedStatement.setString(4, customer.getCustomerBirthday());
//            preparedStatement.setInt(5, customer.getCustomerGender());
//            preparedStatement.setString(6, customer.getCustomerIdCard());
//            preparedStatement.setString(7, customer.getCustomerPhone());
//            preparedStatement.setString(8, customer.getCustomerEmail());
//            preparedStatement.setString(9, customer.getCustomerAddress());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//            e.printStackTrace();
//        }
//    }

    @Override
    public boolean deleteCustomer(int customer_id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_CUSTOMER);) {
            preparedStatement.setInt(1, customer_id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } finally {
            ConnectionDataBase.close();
        }
        return rowUpdate;
    }

    @Override
    public Customer selectCustomer(int customer_id) {
        Customer customer = null;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CUSTOMER_WHERE_CUSTOMER_ID)) {
            preparedStatement.setInt(1, customer_id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(customer_id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customerList.add(new Customer(customerId, customerTypeId, customerBirthday,
                        customerName, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDataBase.close();
        }
        return customerList;
    }

    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if (Validate.idCard(customer.getCustomerIdCard())) {
            errorMap.put("customerIdCard", "customerIdCard bị lỗi [0-9 gồm 9số]");
        }

        if (Validate.phone(customer.getCustomerPhone())) {
            errorMap.put("customerPhone", "customerPhone bị lỗi[090{0-9 7số} or 091{0-9 7số}]");
        }

        if (Validate.email(customer.getCustomerEmail())) {
            errorMap.put("customerEmail", "customerEmail bị lỗi[min123@gmail.com]");
        }

        if (errorMap.isEmpty()) {
            try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER);
//                preparedStatement.setInt(1, customer.getCustomerId());
                preparedStatement.setInt(1, customer.getCustomerTypeId());
                preparedStatement.setString(2, customer.getCustomerName());
                preparedStatement.setString(3, customer.getCustomerBirthday());
                preparedStatement.setInt(4, customer.getCustomerGender());
                preparedStatement.setString(5, customer.getCustomerIdCard());
                preparedStatement.setString(6, customer.getCustomerPhone());
                preparedStatement.setString(7, customer.getCustomerEmail());
                preparedStatement.setString(8, customer.getCustomerAddress());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }finally {
                ConnectionDataBase.close();
            }
        }
        return errorMap;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
