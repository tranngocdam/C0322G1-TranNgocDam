<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/30/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><b>Danh sách khách hàng</b></h1>
<table border="1">
    <tr>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="temp" items="${listCustomer}">
        <tr>
            <td>${temp.ten}</td>
            <td>${temp.ngaySinh}</td>
            <td>${temp.diaChi}</td>
            <td><img src="${temp.anh}" alt=""></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
