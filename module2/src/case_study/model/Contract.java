package case_study.model;

public class Contract {
//    Số hợp đồng, mã booking, Số tiền cọc trước, Tổng số tiền thanh toán, mã khách hàng.
    private String soHopDong;
    private String maBooking;
    private Integer tienCocTruoc;
    private Double tongTienThanhToan;
    private String maKhachHang;

    public Contract() {
    }

    public Contract(String soHopDong, String maBooking, Integer tienCocTruoc, Double tongTienThanhToan, String maKhachHang) {
        this.soHopDong = soHopDong;
        this.maBooking = maBooking;
        this.tienCocTruoc = tienCocTruoc;
        this.tongTienThanhToan = tongTienThanhToan;
        this.maKhachHang = maKhachHang;
    }

    public String getSoHopDong() {
        return soHopDong;
    }

    public void setSoHopDong(String soHopDong) {
        this.soHopDong = soHopDong;
    }

    public String getMaBooking() {
        return maBooking;
    }

    public void setMaBooking(String maBooking) {
        this.maBooking = maBooking;
    }

    public Integer getTienCocTruoc() {
        return tienCocTruoc;
    }

    public void setTienCocTruoc(Integer tienCocTruoc) {
        this.tienCocTruoc = tienCocTruoc;
    }

    public Double getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(Double tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
