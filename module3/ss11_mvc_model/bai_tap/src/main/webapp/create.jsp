<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/31/2022
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap-5.0.2-dist">
</head>
<body>
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
        <label>Product Name</label>
        <input type="text" name="name" placeholder="Enter Product Name">
    </div>
    <div class="form-group">
        <label>Product Price</label>
        <input type="text" name="price" placeholder="Enter Product Price">
    </div>
    <div class="form-group">
        <label>Product Description</label>
        <input type="text" name="productDesc" placeholder="Enter Product Description">
    </div>
    <div class="form-group">
        <label>Producer</label>
        <input type="text" name="producer" placeholder="Enter producer">
    </div>

    <button type="submit">Submit</button>
</form>
</body>
</html>
