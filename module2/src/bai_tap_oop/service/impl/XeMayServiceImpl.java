package bai_tap_oop.service.impl;
import bai_tap_oop.model.XeMay;
import bai_tap_oop.service.XeMayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeMayServiceImpl implements XeMayService {
    protected static List<XeMay>danhSachXeMay=new ArrayList<>();
    //static List<HangSanXuat> hangSanXuat=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    static {
        danhSachXeMay.add(new XeMay("92E1", "honda", 2014, "bình", 12.0));
        danhSachXeMay.add(new XeMay("43F1", "yamaha", 2010, "nhã", 20.9));
        danhSachXeMay.add(new XeMay("73K1", "suzuki", 2004, "an", 23.1));
//        hangSanXuat.add(new HangSanXuat("m1", "honda", "Japan"));
//        hangSanXuat.add(new HangSanXuat("c3", "sym", "China"));
//        hangSanXuat.add(new HangSanXuat("c3", "yamaha", ""));

    }

    @Override
    public void add() {
        System.out.print("Nhập biển kiểm soát: ");
        String bienKiemSat=scanner.nextLine();
        System.out.print("Nhập tên hãng sản xuất: ");
        String tenHangSanXuat=scanner.nextLine();
        System.out.print("Nhập năm sản xuất: ");
        Integer namSanXuat=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập chủ sở hữu: ");
        String chuSoHuu=scanner.nextLine();
        System.out.print("Nhập công suất: ");
        Double congSuat=Double.parseDouble(scanner.nextLine());
        XeMay xeMay=new XeMay(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu, congSuat);
        danhSachXeMay.add(xeMay);
    }

    @Override
    public void display() {
        for (XeMay xemay: danhSachXeMay) {
            System.out.println(xemay);
        }
    }
}
