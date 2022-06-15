<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/6/2022
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <nav class="navbar navbar-expand-sm bg-info navbar-dark sticky-top">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">
                            <a><img src="https://images.vietnamtourism.gov.vn/vn/images/Furama12.jpg" alt="Logo"
                                    style="width:70px;" class="rounded"></a>
                        </a>
                    </div>
                </li>
            </ul>
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <form>
                        <a class="nav-link" href="/home">HOME</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/employee">
                        <a class="nav-link" href="/employee">EMPLOYEE</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/customer">
                        <a class="nav-link" href="/customer">CUSTOMER</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/service">
                        <a class="nav-link" href="/service">SERVICE</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/contract">
                        <a class="nav-link" href="/contract">CONTRACT</a>
                    </form>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link">A VAN NGUYEN</a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="row">
        <h2>CREAT EMPLOYEE</h2>
    </div>
    <div class="row">
        <form action="employee" method="post">
            <input type="hidden" name="action" value="save">
            <div class="mb-3 mt-3">
                <label>employeeId:</label>
                <input type="text" class="form-control" id="employeeId" placeholder="Enter employeeId"
                       name="employeeId">
            </div>
            <div class="mb-3">
                <label>employeeName:</label>
                <input type="text" class="form-control" id="employeeName" placeholder="Enter employeeName"
                       name="employeeName">
            </div>
            <div class="mb-3">
                <label>employeeBirthday:</label>
                <input type="date" class="form-control" id="employeeBirthday" placeholder="employeeBirthday"
                       name="employeeBirthday">
            </div>
            <div class="mb-3">
                <label>employeeIdCard:</label>
                <input type="text" class="form-control" id="employeeIdCard" placeholder="Enter employeeIdCard"
                       name="employeeIdCard" value="${employeeIdCard}">
                <small style="color: red">${errorMap.employeeIdCard}</small>
                <p style="color: red">
            </div>

            <div class="mb-3">
                <label>employeeSalary:</label>
                <input type="text" class="form-control" id="employeeSalary" placeholder="Enter employeeSalary"
                       name="employeeSalary">
            </div>
            <div class="mb-3">
                <label>employeePhone:</label>
                <input type="text" class="form-control" id="employeePhone" placeholder="Enter employeePhone"
                       name="employeePhone" value="${employeePhone}">
                <small style="color: red">${errorMap.employeePhone}</small>
                <p style="color: red">
            </div>
            <div class="mb-3">
                <label>employeeEmail:</label>
                <input type="text" class="form-control" id="employeeEmail" placeholder="Enter employeeEmail"
                       name="employeeEmail" value="${employee.employeeEmail}">
                <small style="color: red">${errorMap.employeeEmail}</small>
                <p style="color: red">
            </div>
            <div class="mb-3">
                <label>employeeAddress:</label>
                <input type="text" class="form-control" id="employeeAddress" placeholder="Enter employeeAddress"
                       name="employeeAddress">
            </div>

            <div class="mb-3">
                <label>positionId:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio1" name="positionId" value="1">Quản lí
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio2" name="positionId" value="2">Nhân viên
                    <label class="form-check-label" for="radio1"></label>
                </div>
            </div>
            <div class="mb-3">
                <label>educationDegreeId:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio3" name="educationDegreeId" value="1">Quản lí
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio4" name="educationDegreeId" value="2">Nhân
                    viên
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio5" name="educationDegreeId" value="3">Quản lí
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio6" name="educationDegreeId" value="4">Nhân
                    viên
                    <label class="form-check-label" for="radio1"></label>
                </div>
            </div>
            <div class="mb-3">
                <label>divisionId:</label>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio7" name="divisionId" value="1">Sale-Marketing
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio8" name="divisionId" value="2">Hành chính
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio9" name="divisionId" value="3">Phục vụ
                    <label class="form-check-label" for="radio1"></label>
                </div>
                <div class="form-check">
                    <input type="radio" class="form-check-input" id="radio10" name="divisionId" value="4">Quản lý
                    <label class="form-check-label" for="radio1"></label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a class="btn btn-primary" href="/employee">back</a>
        </form>
    </div>

</div>
</body>
</html>
