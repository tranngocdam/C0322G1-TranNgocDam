package case_study_1.controller;

import bai_tap_oop.controller.MenuControl;
import case_study_1.service.CinemaService;
import case_study_1.service.impl.CinemaServiceimpl;

import java.util.Scanner;

public class CinemaMenu {
    private static Scanner scanner=new Scanner(System.in);
    private static CinemaService cinemaService=new CinemaServiceimpl();
    public  static void MenuDisplay(){
        while (true){
            int choice;
            System.out.println("====Menu====\n" +
                    "1. Danh sách toàn bộ suất chiếu của rạp.\n" +
                    "2. Thêm mới một suất chiếu.\n" +
                    "3. Xoá suất chiếu.\n" +
                    "4. Thoát.\n" +
                    "Chọn chức năng: ");
            choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    cinemaService.danhSach();
                    break;
                case 2:
                    cinemaService.themMoi();
                    break;
                case 3:
                    cinemaService.xoa();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
