<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/17/2022
  Time: 5:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>

<%--@elvariable id="music" type=""--%>
<%--@elvariable id="song" type=""--%>
<form:form action="addMusic" method="post" modelAttribute="song">
    <table>
        <tr>
            <td>Tên bài hát: </td>
            <td><form:input path="tenBaiHat"/></td>
        </tr>
        <tr>
            <td>Nghệ sĩ: </td>
            <td><form:input path="ngheSi"/></td>
        </tr>
        <tr>
            <td>Thể loại nhạc: </td>
            <td>
                <form:select path="theLoaiNhac">
                    <form:option value="Rock"> Rock</form:option>
                    <form:option value="TikTok"> TikTok</form:option>
                    <form:option value="Bolero"> Bolero</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Đường dẫn: </td>
            <td>
                <form:select path="duongDan">
                    <form:option value="https://www.youtube.com/watch?v=HELjXqg9Ht0">Rock</form:option>
                    <form:option value="https://www.youtube.com/watch?v=m1sy7kLwez8">TikTok</form:option>
                    <form:option value="https://www.youtube.com/watch?v=DjBB0dGsaDg"> Bolero</form:option>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Update" class="update"/>
                <input type="reset" value="cancel" class="update"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
