package repository;

import model.*;

import javax.swing.text.Position;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeRepository {
    public List<Employee> findAllEmployee();

//    public void saveEmployee(Employee employee);

    List<PositionEmployee> findAllPositionEmployee();

    List<EducationDegree> findAllEducationDegree();

    List<Division> findAllDivision();

    List<User> findAllUser();

    public boolean deleteEmployee(int employee_id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int employee_id);

    public List<Employee> findByName(String name);

    public Map<String, String> insertEmployee(Employee employee) throws SQLException;
}
