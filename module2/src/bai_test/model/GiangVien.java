package bai_test.model;

public class GiangVien extends Person{
    private String chuyenMon;

    public GiangVien() {
    }

    @Override
    public void display() {
        System.out.println("GiangVien{" + super.toString()+
                ", chuyenMon=" + chuyenMon +
                '}');
    }

    public GiangVien(String ma, String ten, String ngaySinh, Integer gioiTinh, String chuyenMon) {
        super(ma, ten, ngaySinh, gioiTinh);
        this.chuyenMon = chuyenMon;
    }

    @Override
    public String toString() {
        return "GiangVien{" + super.toString()+
                ", chuyenMon=" + chuyenMon +
                '}';
    }
}
