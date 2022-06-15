package service.impl;

import model.*;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepository iEmployeeRepository=new EmployeeRepositoryImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return iEmployeeRepository.findAllEmployee();
    }

//    @Override
//    public void saveEmployee(Employee employee) {
//        this.iEmployeeRepository.saveEmployee(employee);
//    }

    @Override
    public List<PositionEmployee> findAllPositionEmployee() {
        return iEmployeeRepository.findAllPositionEmployee();

    }
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return iEmployeeRepository.findAllEducationDegree();
    }

    @Override
    public List<Division> findAllDivision() {
        return iEmployeeRepository.findAllDivision();
    }

    @Override
    public List<User> findAllUser() {
        return iEmployeeRepository.findAllUser();
    }

    @Override
    public boolean deleteEmployee(int employee_id) throws SQLException {
        return iEmployeeRepository.deleteEmployee(employee_id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return iEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int employee_id) {
        return iEmployeeRepository.selectEmployee(employee_id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return iEmployeeRepository.findByName(name);
    }

    @Override
    public Map<String, String> insertEmployee(Employee employee) throws SQLException {
        return iEmployeeRepository.insertEmployee(employee);
    }
}
