<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/28/2022
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><%=request.getAttribute("productDescription")%> discounted <%=request.getAttribute("productDiscount")%>% is:</h2>
<h3>Discount Amount: <%=request.getAttribute("productPromotion")%> VND</h3>
<h3 style="color:blue">The price after discount: <%=request.getAttribute("productDiscountPrice")%> VND</h3>
</body>
</html>
