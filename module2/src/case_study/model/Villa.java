package case_study.model;

public class Villa extends Facility{
//    Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.
    private String tieuChuanPhong;
    private Double dienTichHoBoi;
    private Integer soTang;

    public Villa() {
    }

    public Villa(String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, Double kieuThue, String tieuChuanPhong, Double dienTichHoBoi, Integer soTang) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public Double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(Double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    public Integer getSoTang() {
        return soTang;
    }

    public void setSoTang(Integer soTang) {
        this.soTang = soTang;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "" + super.toString()+
                ", tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", dienTichHoBoi=" + dienTichHoBoi +
                ", soTang=" + soTang +
                '}';
    }
}
