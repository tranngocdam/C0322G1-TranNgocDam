package bai_test.model;

public abstract class Person {
    private String ma;
    private String ten;
    private String ngaySinh;
    private Integer gioiTinh;//1-nam, 2-nữ, 3-khác

    public Person() {
    }

    public void display() {
    }

    public Person(String ma, String ten, String ngaySinh, Integer gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return " ma=" + ma +
                ", ten=" + ten +
                ", ngaySinh=" + ngaySinh +
                ", gioiTinh=" + gioiTinh;
    }
}
