package case_study.model;

public class House extends Facility{
//    Tiêu chuẩn phòng, Số tầng.
    private String tieuChuanPhong;
    private Integer soTang;

    public House() {
    }

    public House(String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, Double kieuThue, String tieuChuanPhong, Integer soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public Integer getSoTang() {
        return soTang;
    }

    public void setSoTang(Integer soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "House{" +
                "" + super.toString() +
                ", tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", soTang=" + soTang +
                '}';
    }
}
