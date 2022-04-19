package bai_tap_oop.service.impl;
import bai_tap_oop.model.XeTai;
import bai_tap_oop.service.XeTaiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiServiceImpl implements XeTaiService {
    protected static List<XeTai> danhSachXetai =new ArrayList<>();
    //static List<HangSanXuat> hangSanXuat=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    static {
        danhSachXetai.add(new XeTai("92K1", "huyndai", 2011, "mình", 12.0));
        danhSachXetai.add(new XeTai("41F1", "jack", 2006, "nin", 21.4));
        danhSachXetai.add(new XeTai("13M1", "suzuki", 2014, "nan", 53.3));
//        hangSanXuat.add(new HangSanXuat("ho1", "honda", "Japan"));
//        hangSanXuat.add(new HangSanXuat("s3", "suzuki", "korea"));
//        hangSanXuat.add(new HangSanXuat("c3", "jack", "china"));

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
        System.out.print("Nhập trọng tải: ");
        Double trongTai=Double.parseDouble(scanner.nextLine());
        XeTai xeTai=new XeTai(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu, trongTai);
        danhSachXetai.add(xeTai);
    }

    @Override
    public void display() {
        for (XeTai xetai: danhSachXetai) {
            System.out.println(xetai);
        }
    }
}
