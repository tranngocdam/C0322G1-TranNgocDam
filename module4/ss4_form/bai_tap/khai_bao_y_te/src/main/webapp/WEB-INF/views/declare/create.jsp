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
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <h3 class="text-center">TỜ KHAI Y TẾ</h3>
    <h5 class="text-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
        THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
    <h5 class="text-center" style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm luật pháp Việt Nam và có
        thể xử lý hình sự</h5>
</header>
<div class="container">
    <form:form modelAttribute="declare" action="addDeclare" method="post">
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Họ tên (ghi chữ IN HOA) </label>
                <form:input cssClass="form-control" path="hoTen"></form:input>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <label class="fw-bold">Năm sinh<em style="color: red">(*)</em> </label>
                <form:select path="namSinh">
                    <option value="1980">1980</option>
                    <option value="1981">1981</option>
                    <option value="1982">1982</option>
                    <option value="1983">1983</option>
                    <option value="1984">1984</option>
                    <option value="1985">1985</option>
                    <option value="1986">1986</option>
                    <option value="1987">1987</option>
                    <option value="1988">1988</option>
                    <option value="1989">1989</option>
                    <option value="1990">1990</option>
                    <option value="1991">1991</option>
                    <option value="1992">1992</option>
                    <option value="1993">1993</option>
                    <option value="1994">1994</option>
                    <option value="1995">1995</option>
                    <option value="1996">1996</option>
                    <option value="1997">1997</option>
                    <option value="1998">1998</option>
                    <option value="1999">1999</option>
                    <option value="khac">khác</option>
                </form:select>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Giới tính </label>
                <form:select path="gioiTinh">
                    <option value="nam">nam</option>
                    <option value="nữ">nữ</option>
                    <option value="khac">khác</option>
                </form:select>
            </div>
            <div class="col-lg-4">
                <label class="fw-bold">Quốc tịch </label>
               <form:select path="quocTich">
                   <option value="vietnam">việt nam</option>
                   <option value="usa">usa</option>
                   <option value="china">Trung quốc</option>
                   <option value="lao">Lào</option>
                   <option value="japan">Nhật bản</option>
                   <option value="campuchia">Campuchia</option>
                   <option value="khac">khác</option>
               </form:select>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khách </label>
                <form:input cssClass="form-control" path="soCMND"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <label class="fw-bold">Thông tin đi lại</label>
                <br>
                <form:radiobutton value="TauBay" path="thongTinDiLai"></form:radiobutton> Tàu bay
                <form:radiobutton value="TauThuyen" path="thongTinDiLai"></form:radiobutton> Tàu thuyền
                <form:radiobutton value="Oto" path="thongTinDiLai"></form:radiobutton> Ô tô
                <form:radiobutton value="Khac" path="thongTinDiLai"></form:radiobutton> Khác (Ghi rõ)
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label class="fw-bold">Số hiệu phương tiện</label>
                <form:input cssClass="form-control" path="soHieuPhuongTien"></form:input>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Số ghế</label>
                <form:input cssClass="form-control" path="soGhe"></form:input>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label class="fw-bold">Ngày khởi hành</label>
                <form:input path="ngayKhoiHanh" cssClass="form-control" type="date"></form:input>
            </div>
            <div class="col-lg-6">
                <label class="fw-bold">Ngày kết thúc</label>
                <form:input path="ngayKetThuc" cssClass="form-control" type="date"></form:input>
            </div>
        </div>
        <div class="row">
            <label class="fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</label>
            <div class="col-lg-12">
                <form:textarea path="thongTinDiChuyen" cssClass="form-control"></form:textarea>
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Gửi</button>
        </div>
    </form:form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
