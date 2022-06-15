<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/2/2022
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-expand-sm bg-warning navbar-dark sticky-top">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">
                            <a><img src="https://images.vietnamtourism.gov.vn/vn/images/Furama12.jpg" alt="Logo"
                                    style="width:60px;" class="rounded"></a>
                        </a>
                    </div>
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
        <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/home">HOME</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/employee">EMPLOYEE</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/customer">CUSTOMER</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/service">SERVICE</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/contract">CONTRACT</a>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <input class="form-control me-2" type="text" placeholder="Search">
                        <button class="btn btn-primary" type="button">Search</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-6 col-lg-4">
                    <ul class="navbar-nav border white">
                        <li class="nav-item">
                            <a><img src="https://furamavietnam.com/wp-content/uploads/2018/10/Vietnam_Danang_Furama_Resort_Exterior_Courtyard-1.jpg"
                                    style="width:410px; height: 300px" class="rounded"></a>
                        </li>
                        <li class="nav-item">
                            <a><img src="https://danangfantasticity.com/wp-content/uploads/2021/02/Furama-resort-danang-103-105-vo-nguyen-giap-da-nang-fly-cam.jpg"
                                    style="width:410px; height: 300px" class="rounded"></a>
                        </li>
                    </ul>
                </div>
                <div class="col-sm-9 col-md-6 col-lg-8 bg-white border 1px">
                    <div style="height: 400px; width: 50%">
                        <a><img src="https://images.vietnamtourism.gov.vn/vn/images/Furama12.jpg"
                                style="width:200%; height:600px" class="rounded"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="bg-white border 3px">
            <div style="height: 200px">
                <nav class="navbar navbar-expand-sm bg-light justify-content-center">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">103 - 105 Vo Nguyen Giap Street, Khue My Ward, Ngu Hanh Son
                                District, Danang City, Vietnam
                                7,0 km from Danang Airport</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                84-236-3847 333/888
                                reservation@furamavietnam.com</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</body>
<link rel="stylesheet" href="/bootstrap-5.0.2-dist/js/bootstrap.min.js">
</html>
