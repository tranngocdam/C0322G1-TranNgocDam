package bai_tap_oop.controller;

import bai_tap_oop.service.OtoService;
import bai_tap_oop.service.XeMayService;
import bai_tap_oop.service.XeService;
import bai_tap_oop.service.XeTaiService;
import bai_tap_oop.service.impl.OtoServiceImpl;
import bai_tap_oop.service.impl.XeMayServiceImpl;
import bai_tap_oop.service.impl.XeServiceImpl;
import bai_tap_oop.service.impl.XeTaiServiceImpl;

import java.util.Scanner;

public class MenuControl {
    private static XeMayService xeMayService=new XeMayServiceImpl();
    private static XeTaiService xeTaiService=new XeTaiServiceImpl();
    private static OtoService otoService=new OtoServiceImpl();
    private static XeService xeService=new XeServiceImpl();
    public static Scanner scanner=new Scanner(System.in);
    public static void mainDisplay(){
        int choose;
        boolean check=true;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ PHƯƠNG TIỆN");
            System.out.println("Chọn chức năng\n" +
                    "1. Thêm mới phương tiện\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Tìm kiếm theo biển kiểm sát\n" +
                    "5. Thoát");
            System.out.print("Chọn chức năng: ");
            choose=Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    chonXeThemMoi(xeMayService, xeTaiService, otoService, scanner);
                    break;
                case 2:
                    hienThiXe(xeMayService, xeTaiService, otoService, scanner);
                    break;
                case 3:
                    xeService.delete();
                    break;
                case 4:
                    xeService.find();
                    break;
                case 5:
                    System.exit(0);
            }
        }while (check);
    }

    private static void hienThiXe(XeMayService xeMayService, XeTaiService xeTaiService, OtoService otoService, Scanner scanner) {
        System.out.println("1. Hiển thị xe tải\n" +
                "2. Hiển thị ô tô\n" +
                "3. Hiển thị xe máy");
        int choose2=Integer.parseInt(scanner.nextLine());
        switch (choose2){
            case 1:
                xeTaiService.display();
                break;
            case 2:
                otoService.display();
                break;
            case 3:
                xeMayService.display();
                break;
        }
    }

    private static void chonXeThemMoi(XeMayService xeMayService, XeTaiService xeTaiService, OtoService otoService, Scanner scanner) {
        System.out.println("1. Thêm xe tải\n" +
                "2. Thêm ô tô\n" +
                "3. Thêm xe máy");
        int choose1=Integer.parseInt(scanner.nextLine());
        switch (choose1){
            case 1:
                xeTaiService.add();
                break;
            case 2:
                otoService.add();
                break;
            case 3:
                xeMayService.add();
                break;
        }
    }
}
