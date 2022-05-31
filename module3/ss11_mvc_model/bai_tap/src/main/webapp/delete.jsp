<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/31/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/products">Back to Products list</a>
</p>
<form method="post">
    <div>
        <label>Product ID</label>
        <input type="text" name="id" placeholder="Enter Product ID">
    </div>
    <button type="submit">Submit</button>

</form>
</body>
</html>
