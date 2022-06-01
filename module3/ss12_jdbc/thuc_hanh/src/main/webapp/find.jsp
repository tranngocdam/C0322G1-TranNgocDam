<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/1/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <a href="users?action=users">List All Users</a>
</h2>
<form>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>email</td>
            <td>country</td>
        </tr>
        <c:forEach items="${user}" var="u">
            <tr>
                <td>${u.getId()}</td>
                <td>${u.getName()}</td>
                <td>${u.getEmail()}</td>
                <td>${u.getCountry()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
