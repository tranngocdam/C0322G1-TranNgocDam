<%--
  Created by IntelliJ IDEA.
  User: Dam BKDN
  Date: 6/19/2022
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<div>--%>
<%--    <legend>Box Music</legend>--%>
<%--    <div>Tên bài hát : }</div>--%>
<%--    <div>Nghệ sĩ : ${song.ngheSi}</div>--%>
<%--    <div>Thể loại nhạc : </div>--%>
<%--    <div>Đường dẫn : <iframe width="200px" height="auto" title="the song" src="${song.duongDan}" allowfullscreen> </iframe> </div>--%>
<%--</div>--%>
<table>
    <tr>
        <td>Tên bài hát</td>
        <td>${song.tenBaiHat}</td>
    </tr>
    <tr>
        <td>Nghệ sĩ</td>
        <td>${song.ngheSi}</td>
    </tr>
    <tr>
        <td>Thể loại nhạc</td>
        <td>${song.theLoaiNhac}</td>
    </tr>
    <td>Đường dẫn</td>
    <td>${song.duongDan}</td>
</table>
</body>
</html>
