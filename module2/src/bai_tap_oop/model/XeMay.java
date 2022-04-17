package bai_tap_oop.model;

public class XeMay extends Xe{
    private double congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, double congSuat) {
        super(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public void add() {

    }

    @Override
    public String toString() {
        return "XeMay{" +
                "bienKiemSat='" + bienKiemSat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                ", congSuat=" + congSuat +
                '}';
    }
}
