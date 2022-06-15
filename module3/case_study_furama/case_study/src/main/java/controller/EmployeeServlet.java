package controller;

import model.*;
import service.IEmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "save":
                    showCreate(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "edit":
                   showEdit(request, response);
                    break;
                default:
                    findAllEmployee(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "save":
                    saveEmployee(request, response);
                    break;
                case "edit":
                    updateEmployee(request, response);
                    break;
                case "search":
                   findEmployeeName(request, response);
                    break;
                default:
                    findAllEmployee(request, response);
                    break;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    private void findAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = iEmployeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
//        String employeeName = request.getParameter("employeeName");
//        String employeeBirthday = request.getParameter("employeeBirthday");
//        String employeeIdCard = request.getParameter("employeeIdCard");
//        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
//        String employeePhone = request.getParameter("employeePhone");
//        String employeeEmail = request.getParameter("employeeEmail");
//        String employeeAddress = request.getParameter("employeeAddress");
//        int positionId = Integer.parseInt(request.getParameter("positionId"));
//        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
//        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
//        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
//        iEmployeeService.saveEmployee(employee);
//        response.sendRedirect("employee");
//    }

    public void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<PositionEmployee> positionEmployees = iEmployeeService.findAllPositionEmployee();
        List<EducationDegree> educationDegrees = iEmployeeService.findAllEducationDegree();
        List<Division> divisions = iEmployeeService.findAllDivision();
        List<User> users = iEmployeeService.findAllUser();
        request.setAttribute("positionEmployees", positionEmployees);
        request.setAttribute("educationDegrees", educationDegrees);
        request.setAttribute("divisions", divisions);
        request.setAttribute("users", users);
        try {
            request.getRequestDispatcher("employee/save.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        iEmployeeService.deleteEmployee(employeeId);
        List<Employee> employeeList = iEmployeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("employee/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee=new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary,
                employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
        iEmployeeService.updateEmployee(employee);
        List<Employee> employeeList=iEmployeeService.findAllEmployee();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }
    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee existingEmployee= iEmployeeService.selectEmployee(employeeId);
        request.setAttribute("employee", existingEmployee);
        request.getRequestDispatcher("employee/edit.jsp").forward(request,response);
    }
    private void findEmployeeName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("employeeName");
        name="%" + name+"%";
        List<Employee> employeeList= iEmployeeService.findByName(name);
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("employee/list.jsp");
        requestDispatcher.forward(request, response);
    }
    private void saveEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeeBirthday = request.getParameter("employeeBirthday");
        String employeeIdCard = request.getParameter("employeeIdCard");
        double employeeSalary = Double.parseDouble(request.getParameter("employeeSalary"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeEmail = request.getParameter("employeeEmail");
        String employeeAddress = request.getParameter("employeeAddress");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard,
                employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId);
        Map<String, String> errorMap=iEmployeeService.insertEmployee(employee);
        try{
            if (errorMap.isEmpty()){
                response.sendRedirect("employee");
            }else {
                request.setAttribute("errorMap", errorMap);
                request.setAttribute("employee", employee);
                request.setAttribute("positionEmployee", iEmployeeService.findAllEmployee());
                request.setAttribute("EducationDegree", iEmployeeService.findAllEmployee());
                request.setAttribute("Division", iEmployeeService.findAllEmployee());
                request.getRequestDispatcher("employee/save.jsp").forward(request, response);
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ServletException e){
            e.printStackTrace();
        }
    }
}
