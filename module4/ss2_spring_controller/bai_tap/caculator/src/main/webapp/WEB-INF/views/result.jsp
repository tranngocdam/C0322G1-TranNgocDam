<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/15/2022
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/result">
    <input type="text" name="number1" placeholder="Enter Number1" value="${input1}">
    <input type="text" name="number2" placeholder="Enter Number2" value="${input2}">
    <button name="formula" value="+">Addition(+)</button>
    <button name="formula" value="-">Subtraction(-)</button >
    <button name="formula" value="*">Multiplication(*)</button>
    <button name="formula" value="/">Division(/)</button>
</form>
<h3>The result is: ${result1}</h3>

</body>
</html>
