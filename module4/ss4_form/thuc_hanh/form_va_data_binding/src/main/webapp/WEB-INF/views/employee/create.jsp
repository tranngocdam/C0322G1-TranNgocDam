<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/17/2022
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new employee</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<%--@elvariable id="employee" type=""--%>
<form:form method="post" action="addEmployee" modelAttribute="employee">
<table>
    <tr>
        <td><form:label path="id">EmployeeId:</form:label></td>
        <td><form:input path="id"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="name">EmployeeName:</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="contactNumber">Contact is number:</form:label></td>
        <td><form:input path="contactNumber"></form:input></td>
    </tr>
    <tr>
        <td><input type="submit" value="submit"/></td>
    </tr>
</table>
</form:form>
</body>
</html>
