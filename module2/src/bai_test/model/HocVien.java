package bai_test.model;

public class HocVien extends Person{
    private String lop;
    private Double diemSo;

    public HocVien() {
    }

    public HocVien(String ma, String ten, String ngaySinh, Integer gioiTinh, String lop, Double diemSo) {
        super(ma, ten, ngaySinh, gioiTinh);
        this.lop = lop;
        this.diemSo = diemSo;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Double getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(Double diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "HocVien{" + super.toString()+
                ", lop=" + lop +
                ", diemSo=" + diemSo +
                '}';
    }
}
