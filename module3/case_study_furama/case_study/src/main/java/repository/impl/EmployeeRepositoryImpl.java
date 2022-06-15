package repository.impl;

import model.*;
import repository.IEmployeeRepository;
import validate.Validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    public static final String SELECT_FROM_EMPLOYEE = "select * from employee";
    public static final String INSERT_INTO_EMPLOYEE = "insert into employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id) value(?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_FROM_POSITION_EMPLOYEE = "select * from position_employee";
    public static final String SELECT_FROM_EDUCATION_DEGREE = "select * from education_degree";
    public static final String SELECT_FROM_DIVISION = "select * from division";
    public static final String SELECT_FROM_USER = "select * from user";
    public static final String DELETE_FROM_EMPLOYEE_BY_ID = "delete from employee where employee_id=?;";
    public static final String UPDATE_EMPLOYEE_BY_ID = "update employee set " +
            " employee_name=?, employee_birthday=?, employee_id_card=?, " +
            " employee_salary=?, employee_phone=?, employee_email=?," +
            " employee_address=?, position_id=?, education_degree_id=?, " +
            " division_id=? where employee_id=?; ";
    public static final String SELECT_EMPLOYEE_BY_EMPLOYEE_ID = "select * from employee where employee_id=?";
    public static final String INSER_EMPLOYEE = "insert into employee( " +
            "employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, " +
            "employee_phone, employee_email, employee_address, position_id, education_degree_id, " +
            "division_id) value(?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employee_id = resultSet.getInt("employee_id");
                String employee_name = resultSet.getString("employee_name");
                String employee_birthday = resultSet.getString("employee_birthday");
                String employee_id_card = resultSet.getString("employee_id_card");
                Double employee_salary = resultSet.getDouble("employee_salary");
                String employee_phone = resultSet.getString("employee_phone");
                String employee_email = resultSet.getString("employee_email");
                String employee_address = resultSet.getString("employee_address");
                int position_id = resultSet.getInt("position_id");
                int education_degree_id = resultSet.getInt("education_degree_id");
                int division_id = resultSet.getInt("division_id");
//                String username = resultSet.getString("username");
                Employee employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


//    @Override
//    public void saveEmployee(Employee employee) {
//        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_EMPLOYEE);
//            preparedStatement.setInt(1, employee.getEmployeeId());
//            preparedStatement.setString(2, employee.getEmployeeName());
//            preparedStatement.setString(3, employee.getEmployeeBirthday());
//            preparedStatement.setString(4, employee.getEmployeeIdCard());
//            preparedStatement.setDouble(5, employee.getEmployeeSalary());
//            preparedStatement.setString(6, employee.getEmployeePhone());
//            preparedStatement.setString(7, employee.getEmployeeEmail());
//            preparedStatement.setString(8, employee.getEmployeeAddress());
//            preparedStatement.setInt(9, employee.getPositionId());
//            preparedStatement.setInt(10, employee.getEducationDegreeId());
//            preparedStatement.setInt(11, employee.getDivisionId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//            e.printStackTrace();
//        }
//    }

    @Override
    public List<PositionEmployee> findAllPositionEmployee() {
        List<PositionEmployee> positionEmployees = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_POSITION_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                PositionEmployee positionEmployee = new PositionEmployee(positionId, positionName);
                positionEmployees.add(positionEmployee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionEmployees;
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
                educationDegrees.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegrees;
    }

    @Override
    public List<Division> findAllDivision() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId, divisionName);
                divisions.add(division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisions;
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                String passwordUser = resultSet.getString("password_user");
                User user = new User(userName, passwordUser);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteEmployee(int employee_id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, employee_id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdate;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setInt(11, employee.getEmployeeId());
            System.out.println(preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } finally {
            ConnectionDataBase.close();
        }
        return rowUpdate;
    }

    @Override
    public Employee selectEmployee(int employee_id) {
        Employee employee = null;
        try (Connection connection = new ConnectionDataBase().getConnectionJavaToDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_EMPLOYEE_ID);
            preparedStatement.setInt(1, employee_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employee = new Employee(employee_id, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                        employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return employee;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = new ConnectionDataBase().getConnectionJavaToDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee where employee_name like ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                employeeList.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                        employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId,
                        educationDegreeId, divisionId));
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDataBase.close();
        }
        return employeeList;
    }

    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException {
        Map<String, String> errorMap=new HashMap<>();
        if ((Validate.idCard(employee.getEmployeeIdCard()))){
            errorMap.put("employeeIdCard", "employeeIdCard bị lỗi gồm 9 số[0-9]");
        }
        if (Validate.phone(employee.getEmployeePhone())){
            errorMap.put("employeePhone", "employeePhone bị lỗi [090+ 7số 0-9] or [091+ 7số 0-9]");
        }
        if (Validate.email(employee.getEmployeeEmail())){
            errorMap.put("employeeEmail", "employeeEmail bị lỗi hoa@gmail.com or hoa12@gmail.com");
        }
//        if ((Validate.salary(employee.getEmployeeSalary()))){
//            errorMap.put("employeeSalary", "EmployeeSalary bị lỗi, phải nhập số dương");
//        }
        if(errorMap.isEmpty()){
            try (Connection connection=new ConnectionDataBase().getConnectionJavaToDB()){
              PreparedStatement preparedStatement=connection.prepareStatement(INSER_EMPLOYEE);
                preparedStatement.setInt(1, employee.getEmployeeId());
                preparedStatement.setString(2, employee.getEmployeeName());
                preparedStatement.setString(3, employee.getEmployeeBirthday());
                preparedStatement.setString(4, employee.getEmployeeIdCard());
                preparedStatement.setDouble(5, employee.getEmployeeSalary());
                preparedStatement.setString(6, employee.getEmployeePhone());
                preparedStatement.setString(7, employee.getEmployeeEmail());
                preparedStatement.setString(8, employee.getEmployeeAddress());
                preparedStatement.setInt(9, employee.getPositionId());
                preparedStatement.setInt(10, employee.getEducationDegreeId());
                preparedStatement.setInt(11, employee.getPositionId());
                preparedStatement.executeUpdate();
            }catch (SQLException e) {
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
