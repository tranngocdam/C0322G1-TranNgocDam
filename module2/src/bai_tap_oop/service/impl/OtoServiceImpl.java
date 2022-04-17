package bai_tap_oop.service.impl;

import bai_tap_oop.model.HangSanXuat;
import bai_tap_oop.model.Oto;
import bai_tap_oop.service.OtoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtoServiceImpl implements OtoService {
    Scanner scanner=new Scanner(System.in);
    static List<Oto>danhSachOto= new ArrayList<>();
    static List<HangSanXuat>hangSanXuat=new ArrayList<>();
    static {
        danhSachOto.add(new Oto("47H1", "hyundai", 2017, "thắng", 12, "du lịch"));
        danhSachOto.add(new Oto("70L1", "honda", 2010, "ninh", 32, "khách"));
        danhSachOto.add(new Oto("81D1", "mazza", 2022, "phú", 4, "du lịch"));
        hangSanXuat.add(new HangSanXuat("h1", "huyndai", "korea"));
        hangSanXuat.add(new HangSanXuat("ho1", "honda", "japan"));
        hangSanXuat.add(new HangSanXuat("vf1", "vifnast", "vietnam"));
    }
    @Override
    public void display(){
        for (int i = 0; i <danhSachOto.size() ; i++) {
            System.out.printf("Danh sach ô tô"+ (i+1));
            System.out.println(danhSachOto.get(i));
        }

    }
}

