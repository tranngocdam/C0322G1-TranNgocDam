package bai_tap_oop.model;

public class XeTai extends Xe{
    private int trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSat, String tenHangSanXuat, int namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public void add() {

    }

    @Override
    public String toString() {
        return "XeTai{" +
                "bienKiemSat='" + bienKiemSat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                ", trongTai=" + trongTai +
                '}';
    }
}
