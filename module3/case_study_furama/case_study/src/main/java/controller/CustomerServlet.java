package controller;

import model.Customer;
import model.CustomerType;
import model.User;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerServiceImpl();


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
                    deleteCustomer(request, response);
                    break;
                case "edit":
                    showEdit(request, response);
                    break;
                default:
                    findAllCustomer(request, response);
                    break;
            }
        }catch (SQLException e){
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
                    saveCustomer(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "search":
                    findCustomerName(request, response);
                    break;
                default:
                    findAllCustomer(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = iCustomerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



//    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int customerId = Integer.parseInt(request.getParameter("customerId"));
//        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
//        String customerName = request.getParameter("customerName");
//        String customerBirthday = request.getParameter("customerBirthday");
//        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
//        String customerIdCard = request.getParameter("customerIdCard");
//        String customerPhone = request.getParameter("customerPhone");
//        String customerEmail = request.getParameter("customerEmail");
//        String customerAddress = request.getParameter("customerAddress");
//        Customer customer = new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
//        iCustomerService.saveCustomer(customer);
//        response.sendRedirect("customer");
//    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday= request.getParameter("customerBirthday");
        int customerGender=Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard=request.getParameter("customerIdCard");
        String customerPhone=request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer=new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        iCustomerService.updateCustomer(customer);
        List<Customer> customerList = iCustomerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }
    public void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerService.findAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("customer/save.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        iCustomerService.deleteCustomer(customerId);
        List<Customer> customerList = iCustomerService.findAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);

    }
    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
//        Customer existingCustomer= iCustomerService.selectCustomer(customerId);
//        request.setAttribute("customer", existingCustomer);
//        request.getRequestDispatcher("customer/edit.jsp").forward(request,response);
//        iCustomerService.selectCustomer(customerId);
        Customer customer=iCustomerService.selectCustomer(customerId);
        List<CustomerType> customerList=iCustomerService.findAllCustomerType();
        request.setAttribute("customer", customer);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void findCustomerName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("customerName");
        name="%" + name+"%";
        List<Customer> customerList= iCustomerService.findByName(name);
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);

    }
        private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String customerName = request.getParameter("customerName");
        String customerBirthday = request.getParameter("customerBirthday");
        int customerGender = Integer.parseInt(request.getParameter("customerGender"));
        String customerIdCard = request.getParameter("customerIdCard");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String customerAddress = request.getParameter("customerAddress");
        Customer customer = new Customer(customerTypeId, customerName, customerBirthday,
                customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            Map<String, String> errorMap=iCustomerService.insertCustomer(customer);
            try {
                if(errorMap.isEmpty()){
                    response.sendRedirect("customer");
                }else {
                    request.setAttribute("errorMap", errorMap);
                    request.setAttribute("customer", customer);
                    request.setAttribute("customerType", iCustomerService.findAllCustomer());
                    request.getRequestDispatcher("customer/save.jsp").forward(request, response);
                }
            }catch (IOException e){
                e.printStackTrace();
            }catch (ServletException e){
                e.printStackTrace();
            }
    }
}
