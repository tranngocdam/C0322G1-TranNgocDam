package bai_tap_oop.service.impl;

import bai_tap_oop.model.HangSanXuat;
import bai_tap_oop.model.XeMay;
import bai_tap_oop.service.XeMayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeMayServiceImpl implements XeMayService {
    static List<XeMay>danhSachXeMay=new ArrayList<>();
    static List<HangSanXuat> hangSanXuat=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    static {
        danhSachXeMay.add(new XeMay("92E1", "honda", 2014, "bình", 12));
        danhSachXeMay.add(new XeMay("43F1", "yamaha", 2010, "nhã", 20));
        danhSachXeMay.add(new XeMay("73K1", "suzuki", 2004, "an", 23));
        hangSanXuat.add(new HangSanXuat("m1", "honda", "Japan"));
        hangSanXuat.add(new HangSanXuat("c3", "sym", "China"));
        hangSanXuat.add(new HangSanXuat("c3", "yamaha", ""));

    }
    @Override
    public void display(){
        for (int i = 0; i <danhSachXeMay.size() ; i++) {
            System.out.printf("Danh sách xe máy"+(i+1));
            System.out.print(danhSachXeMay.get(i));

        }
    }
}
