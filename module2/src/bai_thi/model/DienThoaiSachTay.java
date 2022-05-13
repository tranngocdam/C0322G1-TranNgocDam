package bai_thi.model;

public class DienThoaiSachTay extends DienThoai{
    private String quocGiaSachTay;
    private Integer trangThai;//1-đã sửa chửa, 2- chưa sửa chữa

    public DienThoaiSachTay() {
    }

    @Override
    public void Display() {
        System.out.println("DienThoaiSachTay{" + super.toString()+
                ", quocGiaSachTay='" + quocGiaSachTay + '\'' +
                ", trangThai=" + trangThai +
                '}');
    }

    public DienThoaiSachTay(String ID, String tenDienThoai, Double giaBan, Integer soLuong, String nhaSanXuat, String quocGiaSachTay, Integer trangThai) {
        super(ID, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.quocGiaSachTay = quocGiaSachTay;
        this.trangThai = trangThai;
    }

    public String getQuocGiaSachTay() {
        return quocGiaSachTay;
    }

    public void setQuocGiaSachTay(String quocGiaSachTay) {
        this.quocGiaSachTay = quocGiaSachTay;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DienThoaiSachTay{" + super.toString()+
                ", quocGiaSachTay='" + quocGiaSachTay + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
