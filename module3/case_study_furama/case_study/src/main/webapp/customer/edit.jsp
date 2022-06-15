<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/7/2022
  Time: 10:57 AM
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
                        <a class="btn btn-primary" href="/home">HOME</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/employee">
                        <a class="btn btn-primary" href="/employee">EMPLOYEE</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/customer">
                        <a class="btn btn-primary" href="/customer">CUSTOMER</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/service">
                        <a class="btn btn-primary" href="/service">SERVICE</a>
                    </form>
                </li>
                <li class="nav-item">
                    <form action="/contract">
                        <a class="btn btn-primary" href="/contract">CONTRACT</a>
                    </form>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="btn btn-primary">A VAN NGUYEN</a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="row">
        <form action="customer" method="post">
            <input type="hidden" name="action" value="edit">
            <c:if test="${customer != null}">
                <input type="hidden" name="customerId" value="<c:out value='${customer.customerId}' />"/>
            </c:if>
<%--            <div class="mt-3">--%>
<%--                <label for="sel1" class="form-label">customer_type_id:</label>--%>
<%--                <select class="form-select" id="sel1" name="customerTypeId">--%>
<%--                    <option value="1">Diamond</option>--%>
<%--                    <option value="2">Platinium</option>--%>
<%--                    <option value="3">Gold</option>--%>
<%--                    <option value="4">Sliver</option>--%>
<%--                    <option value="5">Member</option>--%>
<%--                </select>--%>
<%--            </div>--%>

            <div class="mb-3">
                <label for="sel1" class="form-label">customer_type_id:</label>
                <select class="form-select" name="customerTypeId" id="sel1">
                    <c:forEach items="${customerList}" var="i">
                        <c:if test="${i.customerTypeId == customer.customerTypeId}">
                            <option selected value="${i.customerTypeId}">${i.customerTypeName}</option>
                        </c:if>
                        <c:if test="${i.customerTypeId != customer.customerTypeId}">
                            <option value="${i.customerTypeId}"> ${i.customerTypeName} </option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label>customer_name:</label>
                <input type="text" class="form-control" id="customerName" placeholder="Enter customerName"
                       name="customerName" value="<c:out value='${customer.customerName}' />">
            </div>
            <div class="mb-3">
                <label>customer_birthday:</label>
                <input type="date" class="form-control" id="customerBirthday" placeholder="Enter customerBirthday"
                       name="customerBirthday" value="<c:out value='${customer.customerBirthday}' />">
            </div>
            <div class="mb-3">
                                <label>customer_gender:</label>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="radio1"  name="customerGender" ${customer.customerGender==1 ? 'checked' : ''} >Nam
                                    <label class="form-check-label" for="radio1"></label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="radio2" name="customerGender" ${customer.customerGender== 0 ? 'checked' : ''} >Nữ
                                    <label class="form-check-label" for="radio2"></label>
                                </div>
<%--                <label>customer_gender:</label>--%>
<%--                <select name="customerGender" class="form-select" aria-label="Default select example">--%>
<%--                    <option value="${customer.customerGender}">--%>
<%--                        <c:choose>--%>
<%--                            <c:when test="${customer.customerGender==1}">Nam</c:when>--%>
<%--                            <c:when test="${customer.customerGender==0}">Nữ</c:when>--%>
<%--                        </c:choose>--%>
<%--                    </option>--%>
<%--                    <option value="1">Nam</option>--%>
<%--                    <option value="0">Nữ</option>--%>
<%--                </select>--%>
            </div>
            <div class="mb-3">
                <label>customer_id_card:</label>
                <input type="text" class="form-control" id="customerIdCard" placeholder="Enter customerIdCard"
                       name="customerIdCard" value="<c:out value='${customer.customerIdCard}' />">
            </div>
            <div class="mb-3">
                <label>customer_phone:</label>
                <input type="text" class="form-control" id="customerPhone" placeholder="Enter customerPhone"
                       name="customerPhone" value="<c:out value='${customer.customerPhone}' />">
            </div>
            <div class="mb-3">
                <label>customer_email:</label>
                <input type="text" class="form-control" id="customerEmail" placeholder="Enter customerEmail"
                       name="customerEmail" value="<c:out value='${customer.customerEmail}' />">
            </div>
            <div class="mb-3">
                <label>customer_address:</label>
                <input type="text" class="form-control" id="customerAddress" placeholder="Enter customerAddress"
                       name="customerAddress" value="<c:out value='${customer.customerAddress}' />">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <a class="btn btn-primary" href="/customer">back</a>
        </form>
    </div>
</div>
</body>
</html>
