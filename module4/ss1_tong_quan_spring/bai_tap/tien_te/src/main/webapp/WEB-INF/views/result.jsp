<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/15/2022
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chuyển đổi tiền tệ</h2>
<form action="/result" method="get">
    <div>
        <input type="text" name="usd" placeholder="Enter number USD">
    </div>
    <div>
        <input type="text" name="price" placeholder="Enter price">
    </div>
    <div>
        <button>result</button>
    </div>

</form>
<div>
    <h2>Tiền VND: ${result1}</h2>
</div>
</body>
</html>
