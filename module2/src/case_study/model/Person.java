package case_study.model;

public abstract class Person {
//     Họ tên, Ngày sinh, Giới tính, Số CMND, Số Điện Thoại, Email
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;
    private Integer soCMND;
    private Integer soDienThoai;
    private String email;

    public abstract void display();

    public Person() {
    }

    public Person(String hoTen, String ngaySinh, String gioiTinh, Integer soCMND, Integer soDienThoai, String email) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soCMND = soCMND;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(Integer soCMND) {
        this.soCMND = soCMND;
    }

    public Integer getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(Integer soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "hoTen='" + hoTen +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh +
                ", soCMND=" + soCMND +
                ", soDienThoai=" + soDienThoai +
                ", email=" + email ;
    }
}
