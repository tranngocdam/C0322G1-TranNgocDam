package bai_tap_oop.model;

public class Oto extends Xe{
//    Số chỗ ngồi, kiểu xe (du lịch, xe khách).
    private Integer soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(Integer soChoNgoi, String kieuXe) {
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Oto(String bienKiemSat, String tenHangSanXuat, Integer namSanXuat, String chuSoHuu, Integer soChoNgoi, String kieuXe) {
        super(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public Integer getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(Integer soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{ " +
                "" + super.toString() +
                "soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }
}
