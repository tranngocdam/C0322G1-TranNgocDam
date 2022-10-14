package bai_test.controller;

import bai_test.service.GiangVienService;
import bai_test.service.HocVienService;
import bai_test.service.impl.GiangVienServiceimpl;
import bai_test.service.impl.HocVienServiceimpl;
import bai_test.util.Selection;

import java.util.Scanner;

public class MenuController {

    private static Scanner scanner=new Scanner(System.in);
    private static HocVienService hocVienService=new HocVienServiceimpl();
    private static GiangVienService giangVienService=new GiangVienServiceimpl();
    public static void MenuDisplay(){
        while (true){
            int choice;
            System.out.println("CHƯƠNG TRÌNH QUẢN LÍ SINH VIÊN\n" +
                    "1. Thêm mới giảng viên hoặc học sinh\n" +
                    "2. Xóa giảng viên hoặc học sinh\n" +
                    "3. Xem danh sách giảng viên hoặc học sinh\n" +
                    "4. Tìm kiếm giảng viên hoặc học sinh\n" +
                    "5. Điểm số\n" +
                    "6. Thoát\n" +
                    "Chọn chức năng: ");
            choice= Selection.luaChon(1,5);
            switch (choice){
                case 1:
                    exit1:
                    while (true) {
                        String choice1;
                        System.out.println("===Thêm mới===\n" +
                                "1. Giảng viên\n" +
                                "2. Học viên\n" +
                                "Chọn: ");
                        choice1=scanner.nextLine();
                        switch (choice1){
                            case "1":
                                giangVienService.themMoi();
                                break ;
                            case "2":
                                hocVienService.themMoi();
                                break ;
                            default:break exit1;
                        }
                    }
                    break;
                case 2:
                    exit2:
                    while (true) {
                        String choice2;
                        System.out.println("===Xóa===\n" +
                                "1. Giảng viên\n" +
                                "2. Học viên\n" +
                                "Chọn: ");
                        choice2=scanner.nextLine();
                        switch (choice2){
                            case "1":
                                giangVienService.xoa();
                                break ;
                            case"2":
                                hocVienService.xoa();
                                break ;
                            default:break exit2;
                        }
                    }
                    break;
                case 3:
                    exit3:
                    while (true) {
                        String choice3;
                        System.out.println("===Danh sách==\n" +
                                "1. Giảng viên\n" +
                                "2. Học viên\n" +
                                "Chọn: ");
                        choice3=scanner.nextLine();
                        switch (choice3){
                            case "1":
                                giangVienService.hienthi();
                                break ;
                            case "2":
                                hocVienService.hienthi();
                                break ;
                            default:break exit3;
                        }
                    }
                    break;
                case 4:
                    String choice3;
                    exit4:
                    while (true) {
                        System.out.println("===Tìm kiếm===\n" +
                                "1. Giảng viên\n" +
                                "2. Học viên\n" +
                                "Chọn: ");
                        choice3=scanner.nextLine();
                        switch (choice3){
                            case "1":
                                giangVienService.timKiem();
                                break ;
                            case "2":
                                hocVienService.timKiem();
                                break ;
                            default:break exit4;
                        }
                    }
                    break;
                case 5:
                    hocVienService.diemSo();
                    case 6:
                        System.exit(0);
            }
        }
    }
}
