<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/17/2022
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/bootstrap-5.0.2-dist/css/bootstrap.min.css">
</head>
<body>
<h1>Settings</h1>
<%--@elvariable id="email" type=""--%>
<form:form method="post" action="addEmail" modelAttribute="email">
    <table>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language">
                <option value="English">English</option>
                <option value="Vietnamese">Vietnamese</option>
                <option value="Japanese">Japanese</option>
                <option value="Chinese">Chinese</option>
            </form:select>
            </td>
        </tr>

        <tr>
            <td><form:label path="pageSize">Page size</form:label></td>
            <td><form:select path="pageSize">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
                <option value="25">25</option>
                <option value="50">50</option>
                <option value="100">100</option>
                  </form:select>mail per page
            </td>

        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams filter</form:label></td>
            <td><form:checkbox path="spamsFilter" value="spamsFilter"/>enable spams filter</td>
        </tr>
        <tr>
            <td><form:label path="signature">Singature</form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td>
                <button type="submit" class="btn btn-primary">Submit</button>
            </td>
            <td>
                <button type="submit" class="btn btn-primary">Cancel</button>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
