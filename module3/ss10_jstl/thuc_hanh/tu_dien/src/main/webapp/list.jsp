<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/30/2022
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h2>Input Word: <%=request.getAttribute("search")%></h2>--%>
<%--<h2>In Vietnamese: <%=request.getAttribute("result")%></h2>--%>
<table border="1">
    <tr>
        <th>eng</th>
        <th>vn</th>
    </tr>
    <tr>
        <th>${search}</th>
        <th>${result}</th>
    </tr>
</table>
</body>
</html>
