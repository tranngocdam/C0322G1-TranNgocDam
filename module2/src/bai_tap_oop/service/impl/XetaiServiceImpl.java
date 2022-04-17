package bai_tap_oop.service.impl;

import bai_tap_oop.model.HangSanXuat;
import bai_tap_oop.model.XeTai;
import bai_tap_oop.service.XeTaiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XetaiServiceImpl implements XeTaiService {
    static List<XeTai> danhSachXeTai=new ArrayList<>();
    static List<HangSanXuat> hangSanXuat=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    static {
        danhSachXeTai.add(new XeTai("92K1", "huyndai", 2011, "mình", 12));
        danhSachXeTai.add(new XeTai("41F1", "jack", 2006, "nin", 21));
        danhSachXeTai.add(new XeTai("13M1", "suzuki", 2014, "nan", 53));
        hangSanXuat.add(new HangSanXuat("ho1", "honda", "Japan"));
        hangSanXuat.add(new HangSanXuat("s3", "suzuki", "korea"));
        hangSanXuat.add(new HangSanXuat("c3", "jack", "china"));

    }
    @Override
    public void display(){
        for (int i = 0; i <danhSachXeTai.size() ; i++) {
            System.out.printf("Danh sách xe máy"+(i+1));
            System.out.print(danhSachXeTai.get(i));

        }
    }
}
