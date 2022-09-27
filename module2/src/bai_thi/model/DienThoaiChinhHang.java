package bai_thi.model;

public class DienThoaiChinhHang extends DienThoai {
    private String thoiGianBaoHanh;
    private Integer phamViBaoHanh;//1-trong nước, 2-quốc tế

    public DienThoaiChinhHang() {
    }

    public  void Display() {
        System.out.println("DienThoaiChinhHang{" + super.toString() +
                ", thoiGianBaoHanh='" + thoiGianBaoHanh + '\'' +
                ", phamViBaoHanh=" + phamViBaoHanh +
                '}');
    }

//    public DienThoaiChinhHang(String ID, String tenDienThoai, Double giaBan, Integer soLuong, String nhaSanXuat, String thoiGianBaoHanh, Integer phamViBaoHanh) {
//        super(ID, tenDienThoai, giaBan, soLuong, nhaSanXuat);
//        this.thoiGianBaoHanh = thoiGianBaoHanh;
//        this.phamViBaoHanh = phamViBaoHanh;
//    }


    public DienThoaiChinhHang(String ID, String tenDienThoai, Double giaBan, Integer soLuong, String nhaSanXuat, String thoiGianBaoHanh, Integer phamViBaoHanh) {
        super(ID, tenDienThoai, giaBan, soLuong, nhaSanXuat);
        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.phamViBaoHanh = phamViBaoHanh;
    }

    public String getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public void setThoiGianBaoHanh(String thoiGianBaoHanh) {
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }

    public Integer getPhamViBaoHanh() {
        return phamViBaoHanh;
    }

    public void setPhamViBaoHanh(Integer phamViBaoHanh) {
        this.phamViBaoHanh = phamViBaoHanh;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang{" + super.toString() +
                ", thoiGianBaoHanh='" + thoiGianBaoHanh + '\'' +
                ", phamViBaoHanh=" + phamViBaoHanh +
                '}';
    }
}
