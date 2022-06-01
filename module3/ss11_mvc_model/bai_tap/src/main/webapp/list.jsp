<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/31/2022
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Producer</th>
        </tr>
        <tbody>
        <c:forEach var="productList" items="${productList}">
            <tr>
                <th>${productList.id}</th>
                <td>${productList.name}</td>
                <td>${productList.price}</td>
                <td>${productList.productDesc}</td>
                <td>${productList.producer}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="products?actionUser=create"><button type="submit">Create New Product</button></a>
    <a href="products?actionUser=edit"><button type="submit">Edit the Product</button></a>
    <a href="products?actionUser=delete"><button type="submit">Delete the Product</button></a>
    <a href="products?actionUser=find"><button type="submit">Find the Product</button></a>
</div>
</body>
</html>
