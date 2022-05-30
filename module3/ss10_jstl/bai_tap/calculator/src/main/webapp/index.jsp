<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/30/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/CalculateServlet" method="post">
    <label>First operand</label>
    <input type="text" name="first" placeholder="number" >
    <br>
    <label>operator:</label>
    <select name="operator">
        <option value="+">add</option>
        <option value="-">minus</option>
        <option value="*">multiple</option>
        <option value="/">devide</option>
    </select>
    <br>
    <label>Second operand</label>
    <input type="text" name="second" placeholder="number">
    <br>
    <input type="submit" id="submit" value="Calculate" >
</form>
</body>
</html>
