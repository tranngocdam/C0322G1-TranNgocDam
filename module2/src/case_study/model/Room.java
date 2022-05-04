package case_study.model;

import java.util.Objects;

public class Room extends Facility{
//    Dịch vụ miễn phí đi kèm
    private String dichVuMienPhi;

    public Room() {
    }

    public Room(String maDichVu, String tenDichVu, Double dienTichSuDung, Double chiPhiThue, Integer soLuongNguoi, String kieuThue, String dichVuMienPhi) {
        super(maDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.dichVuMienPhi = dichVuMienPhi;
    }

    public String getDichVuMienPhi() {
        return dichVuMienPhi;
    }

    public void setDichVuMienPhi(String dichVuMienPhi) {
        this.dichVuMienPhi = dichVuMienPhi;
    }

    @Override
    public String toString() {
        return "Room{" +
                "" + super.toString() +
                ", dichVuMienPhi=" + dichVuMienPhi +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return dichVuMienPhi.equals(room.dichVuMienPhi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dichVuMienPhi);
    }
}
