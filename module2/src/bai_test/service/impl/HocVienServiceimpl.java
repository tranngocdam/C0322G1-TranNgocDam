package bai_test.service.impl;

import bai_test.model.HocVien;
import bai_test.service.HocVienService;
import bai_test.util.Selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HocVienServiceimpl implements HocVienService {
    private static Scanner scanner=new Scanner(System.in);
    public static List<HocVien>hocViens=new ArrayList<>();
    static {
        hocViens.add(new HocVien("SV-2121", "nhung", "09/02/2001", 1, "C04", 6.4));
        hocViens.add(new HocVien("SV-5423", "lài", "31/07/1979", 3, "C03", 8.1));
        hocViens.add(new HocVien("SV-2322", "di", "09/04/2001", 2, "C11", 4.2));
        hocViens.add(new HocVien("SV-0423", "lài", "12/11/1990", 1, "C13", 9.1));
    }

    @Override
    public void diemSo() {
        for (int i = 0; i <hocViens.size() ; i++) {
            if (hocViens.get(i).getDiemSo()>8){
                System.out.println(HocVienServiceimpl.hocViens.get(i));
            }
        }
    }

    @Override
    public void themMoi() {
        System.out.println("Nhập mã học viên: ");
        String ma = scanner.nextLine();
        System.out.println("Nhập tên họ viên: ");
        String ten = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String ngaySinh = scanner.nextLine();
        Integer gioiTinh;
        System.out.println("Nhập giới tính\n" +
                "1. nam\n" +
                "2. nữ\n" +
                "3. khác");
        gioiTinh = Selection.luaChon(1, 3);
        System.out.println("Nhập lớp: ");
        String lop = scanner.nextLine();
        System.out.println("Nhập điểm số: ");
        Double diemSo = Double.parseDouble(scanner.nextLine());
        HocVien hocVien = new HocVien(ma, ten, ngaySinh, gioiTinh, lop, diemSo);
        hocViens.add(hocVien);
    }
    @Override
    public void hienthi() {
        for (HocVien h: hocViens) {
            System.out.println(h);
        }
    }

    @Override
    public void xoa() {

    }

    @Override
    public void timKiem() {
        System.out.println("Nhập tên học viên: ");
        String ten=scanner.nextLine();
        for (int i=0; i< hocViens.size(); i++) {
            if(HocVienServiceimpl.hocViens.get(i).getTen().contains(ten)){
                System.out.println(HocVienServiceimpl.hocViens.get(i));
            }
        }
    }


}
