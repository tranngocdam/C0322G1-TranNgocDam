package bai_tap_oop.model;

public abstract class Xe {
//    Biển kiểm soát , tên hãng sản xuất, năm sản xuất, chủ sở hữu.
    private String bienKiemSat;
    private String tenHangSanXuat;
    private Integer namSanXuat;
    private String chuSoHuu;

    public Xe() {
    }

    public Xe(String bienKiemSat, String tenHangSanXuat, Integer namSanXuat, String chuSoHuu) {
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

    public Integer getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(Integer namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "bienKiemSat='" + bienKiemSat + '\'' +
                ", tenHangSanXuat='" + tenHangSanXuat + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'';
    }
}
