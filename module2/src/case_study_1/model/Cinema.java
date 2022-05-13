package case_study_1.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cinema {
    private String maChieuphim;
    private String tenPhim;
    private Integer soLuongVe;
    private String ngayChieu;

    public Cinema() {
    }

    public Cinema(String maChieuphim, String tenPhim, Integer soLuongVe, String ngayChieu) {
        this.maChieuphim = maChieuphim;
        this.tenPhim = tenPhim;
        this.soLuongVe = soLuongVe;
        this.ngayChieu = ngayChieu;
    }

    public String getMaChieuphim() {
        return maChieuphim;
    }

    public void setMaChieuphim(String maChieuphim) {
        this.maChieuphim = maChieuphim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public Integer getSoLuongVe() {
        return soLuongVe;
    }

    public void setSoLuongVe(Integer soLuongVe) {
        this.soLuongVe = soLuongVe;
    }

    public String getNgayChieu() {
        return ngayChieu;
    }

    public void setNgayChieu(String ngayChieu) {
        this.ngayChieu = ngayChieu;
    }

    @Override
    public String toString() {
        String PATTERN_DAY = "dd-MM-yyyy";
        SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DAY);
        return "Cinema{" +
                "maChieuphim='" + maChieuphim + '\'' +
                ", tenPhim='" + tenPhim + '\'' +
                ", soLuongVe=" + soLuongVe +
                ", ngayChieu=" + ngayChieu +
                '}';
    }
}
