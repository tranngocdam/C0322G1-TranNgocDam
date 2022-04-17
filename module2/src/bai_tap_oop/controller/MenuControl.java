package bai_tap_oop.controller;

import bai_tap_oop.service.OtoService;
import bai_tap_oop.service.XeMayService;
import bai_tap_oop.service.XeTaiService;
import bai_tap_oop.service.impl.OtoServiceImpl;
import bai_tap_oop.service.impl.XeMayServiceImpl;
import bai_tap_oop.service.impl.XetaiServiceImpl;

import java.util.Scanner;

public class MenuControl {
    public static void mainDisplay(){
        XeMayService xeMayService=new XeMayServiceImpl();
        XeTaiService xeTaiService=new XetaiServiceImpl();
        OtoService otoService=new OtoServiceImpl();
        Scanner scanner=new Scanner(System.in);
        int choose, choose1, choose2;
        boolean check=true;
        choose=Integer.parseInt(scanner.nextLine());
        System.out.println("CHƯƠNG TRÌNH QUẢN LÍ PHƯƠNG TIỆN");
        do {
            System.out.println("Chọn chức năng\n" +
                    "1. Thêm mới phương tiện\n" +
                    "2. Hiển thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Tìm kiếm theo biển kiểm sát\n" +
                    "5. Thoát");
            switch (choose){
                case 1:
                    System.out.println("1. Thêm xe tải\n" +
                            "2. Thêm ô tô\n" +
                            "3. Thêm xe máy");
                    choose1=Integer.parseInt(scanner.nextLine());
                    switch (choose1){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                case 2:
                    System.out.println("1. Hiển thị xe tải\n" +
                            "2. Hiển thị ô tô\n" +
                            "3. Hiển thị xe máy");
                    choose2=Integer.parseInt(scanner.nextLine());
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
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
            }
        }while (check);
    }
}
