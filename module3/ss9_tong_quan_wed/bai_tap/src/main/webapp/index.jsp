<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 5/28/2022
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
 <h1>Product Discount Calculator</h1>
  <form action="/discount" method="post">

      <label>Product Description: </label>
      <input type="text" name="description" placeholder="description">
      <br>
      <br>
      <label>List Price: </label>
      <input type="text" name="price" placeholder="price">
      <br>
      <br>
      <label>Discount Rate: </label>
      <input type="text" name="discount" placeholder="discount rate">
      <br>
      <br>
      <input type="submit" id="submit" value="Calculate">
  </form>
  </body>
</html>
