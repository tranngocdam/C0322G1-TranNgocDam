<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/15/2022
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Tra từ điển</h2>
<form action="/result" method="get">
    <div>
        <input type="text" name="name1">
    </div>
    <div>
        <button>found</button>
    </div>

</form>
<div>
    <h2>Tiếng việt: ${result1}</h2>
</div>
</body>
</html>
