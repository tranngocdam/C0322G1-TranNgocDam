package bai_test.service.impl;

import bai_test.common.exception.NameFormatException;
import bai_test.common.exception.NotFoundSavingException;
import bai_test.model.GiangVien;
import bai_test.service.GiangVienService;
import bai_test.util.Selection;
import case_study.common.exception.NotYet18YearOldException;
import case_study.common.exception.Over100YearsOldException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GiangVienServiceimpl implements GiangVienService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<GiangVien> giangViens = new ArrayList<>();

    static {
        giangViens.add(new GiangVien("GV-0023", "ving", "12/03/1993", 2, "tutor"));
        giangViens.add(new GiangVien("GV-4312", "nhung", "19/01/1993", 1, "tutor"));
        giangViens.add(new GiangVien("GV-2323", "nhung", "19/01/1960", 3, "tutor"));
        giangViens.add(new GiangVien("GV-4343", "nhung", "12/12/1999", 3, "tutor"));
    }

    @Override
    public void themMoi() {
        String ma;
        while (true) {
            try {
                System.out.println("Nhập mã giảng viên: ");
                ma = scanner.nextLine();
                if (!ma.matches("^(GV)\\-([0-9]{4})$")) {
                    throw new NameFormatException("Sai cú pháp(vd GV-1212, GV-2121)");
                }
                break;
            } catch (NameFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Nhập tên giảng viên: ");
        String ten = scanner.nextLine();
        String ngaySinh;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày sinh dd/MM/yyyy: ");
            ngaySinh = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("không đúng định dạng");
            }
        }
        Integer gioiTinh;
        System.out.println("Nhập giới tính\n" +
                "1. nam\n" +
                "2. nữ\n" +
                "3. khác");
        gioiTinh = Selection.luaChon(1, 3);
        System.out.println("Nhập chuyên môn: ");
        String chuyenMon = scanner.nextLine();
        GiangVien giangVien = new GiangVien(ma, ten, ngaySinh, gioiTinh, chuyenMon);
        giangViens.add(giangVien);
    }

    @Override
    public void timKiem() {
        System.out.println("Nhập tên giảng viên: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < giangViens.size(); i++) {
            if (GiangVienServiceimpl.giangViens.get(i).getTen().contains(ten)) {
                System.out.println(GiangVienServiceimpl.giangViens.get(i));
            }
        }
    }

    @Override
    public void xoa() {
        int choice;
        String ma;
        while (true) {
            try {
                System.out.println("Nhập mã giảng viên: ");
                ma = scanner.nextLine();
                if (ma.matches("^(GV)//-([0-9]{4})$")) {
                    throw new NotFoundSavingException("Mã giảng viên không tồn tại");
                }
                break;
            } catch (NotFoundSavingException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < giangViens.size(); i++) {
            if (ma.equals(giangViens.get(i).getMa())) {
                System.out.println("Bạn muốn xóa không?\n" +
                        "1. yes\n" +
                        "2. no\n");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    giangViens.remove(i);
                } else {
                    scanner.nextLine();
                }
            }
        }


    }

    @Override
    public void hienthi() {
        for (GiangVien g : giangViens) {
            //System.out.println(g);
            g.display();
        }

    }
}
