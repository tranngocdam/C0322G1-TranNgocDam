package case_study.model;

public abstract class Facility {
//    Tên dịch vụ, Diện tích sử dụng, Chi phí thuê, Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ.
    private String tenDichVu;
    private Double dienTichSuDung;
    private Double chiPhiThue;
    private Integer soLuongNguoi;
    private Double kieuThue;

    public Facility() {
    }

    public Facility(String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, Double kieuThue) {
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoi = soLuongNguoi;
        this.kieuThue = kieuThue;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public Double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(Double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public Double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(Double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public Integer getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(Integer soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public Double getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(Double kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Override
    public String toString() {
        return  "tenDichVu='" + tenDichVu + '\'' +
                ", dienTichSuDung=" + dienTichSuDung +
                ", chiPhiThue=" + chiPhiThue +
                ", soLuongNguoi=" + soLuongNguoi +
                ", kieuThue=" + kieuThue +
                '}';
    }
}
