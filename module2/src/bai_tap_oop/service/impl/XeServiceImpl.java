package bai_tap_oop.service.impl;

import bai_tap_oop.service.XeService;

import java.util.Scanner;

public class XeServiceImpl implements XeService {
        Scanner scanner=new Scanner(System.in);

    @Override
    public void delete() {
        System.out.print("Nhập biển kiểm sát: ");
        String bienSo=scanner.nextLine();
        for (int i = 0; i <OtoServiceImpl.danhSachOto.size() ; i++) {
            if (bienSo.equals(OtoServiceImpl.danhSachOto.get(i).getBienKiemSat())){
                System.out.print("Bạn muốn xóa không:\n" +
                        "1. Yes\n" +
                        "2. No\n");
                System.out.print("Chọn 1 hoặc 2: ");
                int choice=Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        OtoServiceImpl.danhSachOto.remove(i);
                        System.out.println("Bạn đã xóa thành công");
                        scanner.nextLine();
                        break;
                }
            }
        }
        for (int i = 0; i <XeMayServiceImpl.danhSachXeMay.size() ; i++) {
            if (bienSo.equals(XeMayServiceImpl.danhSachXeMay.get(i).getBienKiemSat())){
                System.out.print("Bạn muốn xóa không:\n" +
                        "1. Yes\n" +
                        "2. No\n");
                System.out.print("Chọn 1 hoặc 2: ");
                int choice=Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        XeMayServiceImpl.danhSachXeMay.remove(i);
                        System.out.println("Bạn đã xóa thành công");
                        scanner.nextLine();
                        break;
                }
            }
        }
        for (int i = 0; i <XeTaiServiceImpl.danhSachXetai.size() ; i++) {
            if (bienSo.equals(XeTaiServiceImpl.danhSachXetai.get(i).getBienKiemSat())){
                System.out.print("Bạn muốn xóa không:\n" +
                        "1. Yes\n" +
                        "2. No\n");
                System.out.print("Chọn 1 hoặc 2: ");
                int choice=Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        XeTaiServiceImpl.danhSachXetai.remove(i);
                        System.out.println("Bạn đã xóa thành công");
                        scanner.nextLine();
                        break;
                }
            }
        }
    }

    @Override
    public void find() {
        boolean tim=false;
        System.out.print("Nhập biển kiếm sát: ");
        String bienSo=scanner.nextLine();
        for (int i = 0; i <OtoServiceImpl.danhSachOto.size() ; i++) {
            if (OtoServiceImpl.danhSachOto.get(i).getBienKiemSat().contains(bienSo)){
                System.out.println(OtoServiceImpl.danhSachOto.get(i));
                tim=true;
            }
        }
        for (int i = 0; i <XeMayServiceImpl.danhSachXeMay.size() ; i++) {
            if (XeMayServiceImpl.danhSachXeMay.get(i).getBienKiemSat().contains(bienSo)){
                System.out.println(XeMayServiceImpl.danhSachXeMay.get(i));
                tim=true;
            }
        }
        for (int i = 0; i <XeTaiServiceImpl.danhSachXetai.size() ; i++) {
            if (XeTaiServiceImpl.danhSachXetai.get(i).getBienKiemSat().contains(bienSo)){
                System.out.println(XeTaiServiceImpl.danhSachXetai.get(i));
                tim=true;
            }
        }
        if (!tim){
            System.out.println("Không tìm thấy");
        }
    }
}
