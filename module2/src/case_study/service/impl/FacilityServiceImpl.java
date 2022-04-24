package case_study.service.impl;

import case_study.model.Facility;
import case_study.model.House;
import case_study.model.Room;
import case_study.model.Villa;
import case_study.service.FacilityService;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private static Scanner scanner=new Scanner(System.in);
    public static LinkedHashMap<Facility,Integer>linkedHashMap=new LinkedHashMap<>();
    static {
        linkedHashMap.put(new Room("RoomM1","Thuê room", 234.2, 45533.5, 5, "day","coca"),1);
        linkedHashMap.put(new House("HouseH1","Thuê house", 123.4, 576.5, 12, "day","5 sao",3),7);
        linkedHashMap.put(new Villa("VillaV1","Thuê villla", 784.2, 123.3, 6, "day","6 sao",223.2,5),9);

    }
    @Override
    public void add() {
        System.out.println("Mời chọn dịch vụ\n" +
                "1. Add New Villa\n" +
                "2. Add new House\n" +
                "3. Add new Room\n" +
                "4. Back to menu\n");
        int choice=Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Nhập mã dịch vụ: ");
                String maDichVu=scanner.nextLine();
                System.out.print("Nhập tên dịch vụ: ");
                String tenDichVu=scanner.nextLine();
                System.out.println("Nhập diện tích sử dụng: ");
                Double dienTichSuDung=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập chi phí thuê: ");
                Double chiPhiThue=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập số người: ");
                Integer soLuongNguoi=Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu thuê: ");
                String kieuThue=scanner.nextLine();
                System.out.println("Nhập tiêu chuẩn phòng: ");
                String tieuChuanPhong=scanner.nextLine();
                System.out.println("Nhập diện tích hồ bơi: ");
                Double dienTichHoBoi=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập số tầng: ");
                Integer soTang=Integer.parseInt(scanner.nextLine());
                Villa villa=new Villa(maDichVu,tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue, tieuChuanPhong, dienTichHoBoi, soTang);
                linkedHashMap.put(villa,0);
                break;
            case 2:
                System.out.println("Nhập mã dịch vụ: ");
                String maDichVu1=scanner.nextLine();
                System.out.print("Nhập tên dịch vụ: ");
                String tenDichVu1=scanner.nextLine();
                System.out.println("Nhập diện tích sử dụng: ");
                Double dienTichSuDung1=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập chi phí thuê: ");
                Double chiPhiThue1=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập số người: ");
                Integer soLuongNguoi1=Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu thuê: ");
                String kieuThue1=scanner.nextLine();
                System.out.println("Nhập tiêu chuẩn phòng: ");
                String tieuChuanPhong1=scanner.nextLine();
                System.out.println("Nhập số tầng: ");
                Integer soTang1=Integer.parseInt(scanner.nextLine());
                House house=new House(maDichVu1,tenDichVu1, dienTichSuDung1, chiPhiThue1, soLuongNguoi1, kieuThue1, tieuChuanPhong1, soTang1);
                linkedHashMap.put(house,0);
                break;
            case 3:
                System.out.println("Nhập mã dịch vụ: ");
                String maDichVu2=scanner.nextLine();
                System.out.print("Nhập tên dịch vụ: ");
                String tenDichVu2=scanner.nextLine();
                System.out.println("Nhập diện tích sử dụng: ");
                Double dienTichSuDung2=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập chi phí thuê: ");
                Double chiPhiThue2=Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập số người: ");
                Integer soLuongNguoi2=Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập kiểu thuê: ");
                String kieuThue2=scanner.nextLine();
                System.out.println("Nhập dịch vụ miễn phí");
                String dichVuMienPhi2=scanner.nextLine();
                Room room=new Room(maDichVu2,tenDichVu2, dienTichSuDung2, chiPhiThue2, soLuongNguoi2, kieuThue2, dichVuMienPhi2);
                linkedHashMap.put(room,0);
                break;
        }
    }

    @Override
    public void display() {
        Set<Facility> set=linkedHashMap.keySet();
        for (Facility f: set) {
            System.out.println(f);
        }
    }

    @Override
    public void displayMainTenance() {
        Set<Facility> set=linkedHashMap.keySet();
        for (Facility f: set) {
            if (linkedHashMap.get(f)>=5){
                System.out.println(f);
            }

        }
    }
}
