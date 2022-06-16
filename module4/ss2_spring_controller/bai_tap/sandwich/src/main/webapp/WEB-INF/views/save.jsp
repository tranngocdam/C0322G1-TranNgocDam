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
<h1>Sandwich Condiments</h1>
<form action="/save" method="get">
    <input type="checkbox" name="condiment" value="lettuce">Lecttuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <input type="submit" value="Save">
</form>
<div>
    <h1>Condiments add into sandwich are:<c:forEach items="condiment">${condiment}</c:forEach> </h1>

</div>
</body>
</html>
