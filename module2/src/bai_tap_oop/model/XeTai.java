package bai_tap_oop.model;

public class XeTai extends Xe{
//    Trọng tải
    private Double trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSat, String tenHangSanXuat, Integer namSanXuat, String chuSoHuu, Double trongTai) {
        super(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public Double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(Double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{ " +
                "" + super.toString()+
                "trongTai=" + trongTai +
                '}';
    }
}
