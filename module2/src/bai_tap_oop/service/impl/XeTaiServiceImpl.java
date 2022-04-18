package bai_tap_oop.service.impl;
import bai_tap_oop.model.XeTai;
import bai_tap_oop.service.XeTaiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiServiceImpl implements XeTaiService {
    private static List<XeTai> xeTais=new ArrayList<>();
    //static List<HangSanXuat> hangSanXuat=new ArrayList<>();
    private static Scanner scanner=new Scanner(System.in);
    static {
        xeTais.add(new XeTai("92K1", "huyndai", 2011, "mình", 12.0));
        xeTais.add(new XeTai("41F1", "jack", 2006, "nin", 21.4));
        xeTais.add(new XeTai("13M1", "suzuki", 2014, "nan", 53.3));
//        hangSanXuat.add(new HangSanXuat("ho1", "honda", "Japan"));
//        hangSanXuat.add(new HangSanXuat("s3", "suzuki", "korea"));
//        hangSanXuat.add(new HangSanXuat("c3", "jack", "china"));

    }

    @Override
    public void add() {
        System.out.println("Nhập biển kiểm soát: ");
        String bienKiemSat=scanner.nextLine();
        System.out.println("Nhập tên hãng sản xuất: ");
        String tenHangSanXuat=scanner.nextLine();
        System.out.println("Nhập năm sản xuất: ");
        Integer namSanXuat=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String chuSoHuu=scanner.nextLine();
        System.out.println("Nhập trọng tải: ");
        Double trongTai=Double.parseDouble(scanner.nextLine());
        XeTai xeTai=new XeTai(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu, trongTai);
        xeTais.add(xeTai);
    }

    @Override
    public void display() {
        for (XeTai xetai: xeTais) {
            System.out.println(xetai);
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {

    }
}
