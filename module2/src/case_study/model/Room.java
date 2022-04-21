package case_study.model;

public class Room extends Facility{
//    Dịch vụ miễn phí đi kèm
    private Double dichVuMienPhi;

    public Room() {
    }

    public Room(String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, Double kieuThue, Double dichVuMienPhi) {
        super(tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.dichVuMienPhi = dichVuMienPhi;
    }

    public Double getDichVuMienPhi() {
        return dichVuMienPhi;
    }

    public void setDichVuMienPhi(Double dichVuMienPhi) {
        this.dichVuMienPhi = dichVuMienPhi;
    }

    @Override
    public String toString() {
        return "Room{" +
                "" + super.toString() +
                "dichVuMienPhi=" + dichVuMienPhi +
                '}';
    }
}
