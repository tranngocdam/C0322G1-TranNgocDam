package case_study.service.impl;

import case_study.common.exception.FacilityCodeFormatException;
import case_study.common.exception.LimitMenuException;
import case_study.common.math.MathCommon;
import case_study.common.read_writer.Read;
import case_study.common.read_writer.Write;
import case_study.model.Facility;
import case_study.model.House;
import case_study.model.Room;
import case_study.model.Villa;
import case_study.service.FacilityService;

import java.util.*;
import java.util.regex.Pattern;

public class FacilityServiceImpl implements FacilityService {
    private static Scanner scanner = new Scanner(System.in);
    public static Map<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaIntegerLinkedHashMap = new LinkedHashMap<>();
    private static Map<Room, Integer> roomIntegerLinkedHashMap = new LinkedHashMap<>();
    private static Map<House, Integer> houseIntegerLinkedHashMap = new LinkedHashMap<>();


    static {
        linkedHashMap.put(new Room("SVRO-1232", "Thueroom", 34.2, 453.5,
                5, "Day", "coca"), 1);
        roomIntegerLinkedHashMap.put(new Room("SVRO-1232", "Thueroom", 34.2, 453.5,
                5, "Day", "coca"), 1);
        Write.writeToCSVRoom(roomIntegerLinkedHashMap, false);
        //roomIntegerLinkedHashMap = Read.readToCSVRoom();
        linkedHashMap.put(new House("SVHO-2321", "Thuehouse", 123.4, 576.5,
                12, "Month", "3sao", 3), 7);
        houseIntegerLinkedHashMap.put(new House("SVHO-2321", "Thuehouse", 123.4, 576.5,
                12, "Month", "3sao", 3), 7);
        Write.writeToCSVHouse(houseIntegerLinkedHashMap, false);
        //houseIntegerLinkedHashMap = Read.readToCSVHouse();
        linkedHashMap.put(new Villa("SVVL-3483", "Thuevilla", 84.2, 123.3,
                6, "Time", "5sao", 223.2, 5), 9);
        villaIntegerLinkedHashMap.put(new Villa("SVVL-3483", "Thuevilla", 84.2, 123.3,
                6, "Time", "5sao", 223.2, 5), 9);
        Write.writeToCSVVilla(villaIntegerLinkedHashMap, false);
        //villaIntegerLinkedHashMap = Read.readToCSVVilla();
    }

    @Override
    public void add() {
        int choice;
        while (true) {
            System.out.println("1. Add New Villa\n" +
                    "2. Add new House\n" +
                    "3. Add new Room\n" +
                    "4. Back to menu");
            try {
                System.out.println("Nhập lựa chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                }
                break;
            } catch (LimitMenuException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Không nhập kí tự ");
            }
        }
        switch (choice) {
            case 1:
                String maDichVu;
                while (true) {
                    System.out.print("Nhập mã dịch vụ: ");
                    maDichVu = scanner.nextLine();
                    try {
                        if (!maDichVu.matches("^(SVVL)(\\-[0-9]{4})$")) {
                            throw new FacilityCodeFormatException("Mã dịch vụ không hợp lệ, SVVL-YYYY");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
                String tenDichVu;
                while (true) {
                    System.out.print("Nhập tên dịch vụ: ");
                    tenDichVu = scanner.nextLine();
                    try {
                        if (!tenDichVu.matches("^([A-Z][a-z]{2,})$")) {
                            throw new FacilityCodeFormatException("Không hợp lệ,phải viết hoa kí tự đầu các kí tự sau viết thường");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.print("Nhập diện tích sử dụng: ");
                Double dienTichSuDung = MathCommon.getDouble();

                System.out.print("Nhập chi phí thuê: ");
                Double chiPhiThue = MathCommon.getDouble1();

                System.out.print("Nhập số người: ");
                Integer soLuongNguoi = MathCommon.getInteger();

                String kieuThue = null;
                System.out.println("Kiểu thuê\n" +
                        "1. Year\n" +
                        "2. Month\n" +
                        "3. Day\n" +
                        "4. Time");
                int choice1;
                while (true) {
                    try {
                        System.out.print("Chọn kiểu thuê: ");
                        choice1 = Integer.parseInt(scanner.nextLine());
                        if (choice1 < 1 || choice1 > 4) {
                            throw new LimitMenuException("Lựa chọn không hợp lệ");
                        }
                        break;
                    } catch (LimitMenuException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Không nhập kí tự");
                    }
                }
                switch (choice1) {
                    case 1:
                        kieuThue = "Year";
                        break;
                    case 2:
                        kieuThue = "Month";
                        break;
                    case 3:
                        kieuThue = "Day";
                        break;
                    case 4:
                        kieuThue = "Time";
                }

                String tieuChuanPhong;
                while (true) {
                    System.out.print("Nhập tiêu chuẩn phòng: ");
                    tieuChuanPhong = scanner.nextLine();
                    try {
                        if (!tieuChuanPhong.matches("^([1-5])(.[1-9]+)?[a-z]{2,}$")) {
                            throw new FacilityCodeFormatException("Lỗi, tiêu chuẩn từ 0-5 sao(vd 3sao, 5sao)");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("Nhập diện tích hồ bơi: ");
                Double dienTichHoBoi = MathCommon.getDouble();

                System.out.print("Nhập số tầng: ");
                Integer soTang = MathCommon.getInteger1();
                Villa villa = new Villa(maDichVu, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue, tieuChuanPhong, dienTichHoBoi, soTang);
                linkedHashMap.put(villa, 0);
                villaIntegerLinkedHashMap.put(villa, 0);
                for (Map.Entry<Villa, Integer> villaIntegerEntry:villaIntegerLinkedHashMap.entrySet()) {
                    if (maDichVu.equals(villaIntegerEntry.getKey().getMaDichVu())){
                        villaIntegerEntry.setValue(villaIntegerEntry.getValue()+1);
                    }
                }

                Write.writeToCSVVilla(villaIntegerLinkedHashMap, false);
                break;
            case 2:
                String maDichVu1;
                while (true) {
                    System.out.print("Nhập mã dịch vụ: ");
                    maDichVu1 = scanner.nextLine();
                    try {
                        if (!maDichVu1.matches("^SVHO\\-[0-9]{4}$")) {
                            throw new FacilityCodeFormatException("Mã không hợp lệ, SVHO-YYYY");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
                String tenDichVu1;
                while (true) {
                    System.out.print("Nhập tên dịch vụ: ");
                    tenDichVu1 = scanner.nextLine();
                    try {
                        if (!tenDichVu1.matches("^[A-Z][a-z]{2,}$")) {
                            throw new FacilityCodeFormatException("Lỗi, viết hoa chữ cái đầu các kí tự sau viết thường ");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("Nhập diện tích sử dụng: ");
                Double dienTichSuDung1 = MathCommon.getDouble();

                System.out.print("Nhập chi phí thuê: ");
                Double chiPhiThue1 = MathCommon.getDouble1();

                System.out.print("Nhập số người: ");
                Integer soLuongNguoi1 = MathCommon.getInteger();
                int choice2;
                System.out.println("Nhập kiểu thuê\n" +
                        "1. Year\n" +
                        "2. Month\n" +
                        "3. Day\n" +
                        "4. Time");
                while (true) {
                    try {
                        System.out.println("Chọn kiểu thuê: ");
                        choice2 = Integer.parseInt(scanner.nextLine());
                        if (choice2 < 1 || choice > 4) {
                            throw new LimitMenuException("Lựa chọn không hợp lệ");
                        }
                        break;
                    } catch (LimitMenuException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Không nhập kí tự");
                    }
                }
                String kieuThue1 = null;
                switch (choice2) {
                    case 1:
                        kieuThue1 = "Year";
                        break;
                    case 2:
                        kieuThue1 = "Month";
                        break;
                    case 3:
                        kieuThue1 = "Day";
                        break;
                    case 4:
                        kieuThue1 = "Time";
                }

                String tieuChuanPhong1;
                while (true) {
                    System.out.print("Nhập tiêu chuẩn phòng: ");
                    tieuChuanPhong1 = scanner.nextLine();
                    try {
                        if (!tieuChuanPhong1.matches("^[1-5](.[1-9]+)?[a-z]{2,}$")) {
                            throw new FacilityCodeFormatException("Lỗi vd(3sao, 5sao)");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.println("Nhập số tầng: ");
                Integer soTang1 = MathCommon.getInteger1();

                House house = new House(maDichVu1, tenDichVu1, dienTichSuDung1, chiPhiThue1, soLuongNguoi1, kieuThue1, tieuChuanPhong1, soTang1);
                linkedHashMap.put(house, 0);
                houseIntegerLinkedHashMap.put(house, 0);
                Write.writeToCSVHouse(houseIntegerLinkedHashMap, false);
                break;
            case 3:
                String maDichVu2;
                while (true) {
                    System.out.print("Nhập mã dịch vụ: ");
                    maDichVu2 = scanner.nextLine();
                    try {
                        if (!maDichVu2.matches("^SVRO\\-[0-9]{4}$")) {
                            throw new FacilityCodeFormatException("Lỗi, SVRO-YYYY");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }

                String tenDichVu2;
                while (true) {
                    System.out.println("Nhập tên dịch vụ: ");
                    tenDichVu2 = scanner.nextLine();
                    try {
                        if (!tenDichVu2.matches("^[A-Z][a-z]+$")) {
                            throw new FacilityCodeFormatException("Lỗi, viết hoa chữ cái đầu các chữ sau viết thường");
                        }
                        break;
                    } catch (FacilityCodeFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
                System.out.print("Nhập diện tích sử dụng: ");
                Double dienTichSuDung2 = MathCommon.getDouble();

                System.out.print("Nhập chi phí thuê: ");
                Double chiPhiThue2 = MathCommon.getDouble1();

                System.out.print("Nhập số người: ");
                Integer soLuongNguoi2 = MathCommon.getInteger();

                String kieuThue2 = null;
                System.out.print("Kiểu thuê:\n" +
                        "1. Year\n" +
                        "2. Month\n" +
                        "3. Day\n" +
                        "4. Time\n");
                int choice3;
                while (true) {
                    try {
                        System.out.print("Chọn kiểu thuê: ");
                        choice3 = Integer.parseInt(scanner.nextLine());
                        if (choice3 < 1 || choice3 > 4) {
                            throw new LimitMenuException("Lựa chọn quá giới hạn");
                        }
                        break;
                    } catch (LimitMenuException e) {
                        System.out.println(e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Không nhập kí tự");
                    }
                }
                switch (choice3) {
                    case 1:
                        kieuThue2 = "Year";
                        break;
                    case 2:
                        kieuThue2 = "Month";
                        break;
                    case 3:
                        kieuThue2 = "Day";
                        break;
                    case 4:
                        kieuThue2 = "Time";
                }
                System.out.print("Nhập dịch vụ miễn phí: ");
                String dichVuMienPhi2 = scanner.nextLine();

                Room room = new Room(maDichVu2, tenDichVu2, dienTichSuDung2, chiPhiThue2, soLuongNguoi2, kieuThue2, dichVuMienPhi2);
                linkedHashMap.put(room, 0);
                roomIntegerLinkedHashMap.put(room, 0);
                Write.writeToCSVRoom(roomIntegerLinkedHashMap, false);
                break;
        }
    }

    @Override
    public void display() {

        for (Map.Entry<Facility, Integer> mapIntegerMap : linkedHashMap.entrySet()) {
            System.out.println(mapIntegerMap.getKey() + ", " + mapIntegerMap.getValue());
        }
//        Set<Facility> set = linkedHashMap.keySet();
//        for (Facility f : set) {
//            System.out.println(f);
//        }
    }

    @Override
    public void displayMainTenance() {
        for (Map.Entry<Facility, Integer> mapIntegerMap : linkedHashMap.entrySet()) {
            if (mapIntegerMap.getValue() >= 5) {
                System.out.println(mapIntegerMap.getKey() + ", " + mapIntegerMap.getValue());
                mapIntegerMap.setValue(0);
            }

        }
//        Set<Facility> set = linkedHashMap.keySet();
//        for (Facility f : set) {
//            if (linkedHashMap.get(f) >= 5) {
//                System.out.println(f);
//                linkedHashMap.get(0);
//            }
//        }
//        System.out.println("ok");
    }
}
