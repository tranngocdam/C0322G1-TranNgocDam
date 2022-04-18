package bai_tap_oop.model;

public class XeMay extends Xe{
//    Công suất.
    private Double congSuat;

    public XeMay() {
    }

    public XeMay(Double congSuat) {
        this.congSuat = congSuat;
    }

    public XeMay(String bienKiemSat, String tenHangSanXuat, Integer namSanXuat, String chuSoHuu, Double congSuat) {
        super(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public Double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(Double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{ " +
                "" + super.toString()+
                "congSuat=" + congSuat +
                '}';
    }
}
