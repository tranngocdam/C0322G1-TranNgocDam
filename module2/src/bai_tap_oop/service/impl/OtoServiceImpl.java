package bai_tap_oop.service.impl;

import bai_tap_oop.model.HangSanXuat;
import bai_tap_oop.model.Oto;
import bai_tap_oop.service.OtoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtoServiceImpl implements OtoService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Oto>danhSachOto= new ArrayList<>();
    //static List<HangSanXuat>hangSanXuat=new ArrayList<>();
    static {
        danhSachOto.add(new Oto("47H1", "hyundai", 2017, "thắng", 12, "du lịch"));
        danhSachOto.add(new Oto("70L1", "honda", 2010, "ninh", 32, "khách"));
        danhSachOto.add(new Oto("81D1", "mazza", 2022, "phú", 4, "du lịch"));
//        hangSanXuat.add(new HangSanXuat("h1", "huyndai", "korea"));
//        hangSanXuat.add(new HangSanXuat("ho1", "honda", "japan"));
//        hangSanXuat.add(new HangSanXuat("vf1", "vifnast", "vietnam"));
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
        System.out.println("Nhập số chổ ngồi: ");
        Integer soChoNgoi=Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe: ");
        String kieuXe=scanner.nextLine();
        Oto oto=new Oto(bienKiemSat, tenHangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe);
        danhSachOto.add(oto);
    }

    @Override
    public void display() {
        for (Oto oto: danhSachOto) {
            System.out.println(oto);
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {

    }
}

