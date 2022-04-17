package bai_tap_oop.model;

public abstract class Xe {
    protected String bienKiemSat;
    protected String tenHangSanXuat;
    protected int namSanXuat;
    protected String chuSoHuu;

    public Xe() {
    }

    public Xe(String bienKiemSat, String tenHangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSat = bienKiemSat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSat() {
        return bienKiemSat;
    }

    public void setBienKiemSat(String bienKiemSat) {
        this.bienKiemSat = bienKiemSat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
    public abstract void add();

    public String toString() {
        return "Xe{" +
                "bienKiemSat='" + bienKiemSat + '\'' +
                ", hangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }
}
