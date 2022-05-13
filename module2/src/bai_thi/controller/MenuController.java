package bai_thi.controller;

import bai_thi.util.InputUtil;
import bai_thi.service.DienThoaiChinhHangService;
import bai_thi.service.DienThoaiSachTayService;
import bai_thi.service.impl.DienThoaiChinhHangServiceimpl;
import bai_thi.service.impl.DienThoaiSachTayServiceimpl;

import java.util.Scanner;

public class MenuController {
    private static Scanner scanner=new Scanner(System.in);
    private static DienThoaiSachTayService dienThoaiSachTayService=new DienThoaiSachTayServiceimpl();
    private static DienThoaiChinhHangService dienThoaiChinhHangService=new DienThoaiChinhHangServiceimpl();
    public static void menuDisplay(){
        while (true){
            int choice;
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÍ ĐIỆN THOẠI--\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách điện thoại\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát\n" +
                    "Chọn chức năng: ");
            choice= InputUtil.luaChon(1,5);
            switch (choice){
                case 1:
                    exit:
                    while (true){
                        String choice1;
                        System.out.println("==Thêm mới==\n" +
                                "1. Điện thoại chính hãng\n" +
                                "2. Điện thoại sách tay\n" +
                                "Chọn: ");
                        choice1=scanner.nextLine();
                        switch (choice1){
                            case "1":
                                dienThoaiChinhHangService.themMoi();
                                break ;
                            case "2":
                                dienThoaiSachTayService.themMoi();
                                break ;
                            default:break exit;
                        }
                    }
                    break;
                case 2:
                    exit1:
                    while (true){
                        String choice2;
                        System.out.println("==Xóa==\n" +
                                "1. Điện thoại chính hãng\n" +
                                "2. Điện thoại sách tay\n" +
                                "Chọn: ");
                        choice2=scanner.nextLine();
                        switch (choice2){
                            case "1":
                                dienThoaiChinhHangService.xoa();
                                break ;
                            case "2":
                                dienThoaiSachTayService.xoa();
                                break ;
                            default:break exit1;
                        }
                    }
                    break;
                case 3:
                    exit2:
                    while (true){
                        String choice2;
                        System.out.println("==Hiển thị==\n" +
                                "1. Điện thoại chính hãng\n" +
                                "2. Điện thoại sách tay\n" +
                                "Chọn: ");
                        choice2=scanner.nextLine();
                        switch (choice2){
                            case "1":
                                dienThoaiChinhHangService.hienThi();
                                break ;
                            case "2":
                                dienThoaiSachTayService.hienThi();
                                break ;
                            default:break exit2;
                        }
                    }
                    break;
                case 4:
                    exit3:
                    while (true){
                        String choice3;
                        System.out.println("==Tìm kiếm==\n" +
                                "1. Điện thoại chính hãng\n" +
                                "2. Điện thoại sách tay\n" +
                                "Chọn: ");
                        choice3=scanner.nextLine();
                        switch (choice3){
                            case "1":
                                dienThoaiChinhHangService.timKiem();
                                break ;
                            case "2":
                                dienThoaiSachTayService.timKiem();
                                break ;
                            default:break exit3;
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
