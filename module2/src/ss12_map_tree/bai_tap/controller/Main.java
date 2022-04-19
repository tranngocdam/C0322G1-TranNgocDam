package ss12_map_tree.bai_tap.controller;

import ss12_map_tree.bai_tap.service.ProduceService;
import ss12_map_tree.bai_tap.service.impl.ProductManager;

import java.util.Scanner;

public class Main {

    public static void mainControl() {
        ProduceService produceService=new ProductManager();
        int choice;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("Danh sách:\n" +
                    "1. Thêm mới\n" +
                    "2. Hiển thị\n" +
                    "3. Sửa\n" +
                    "4. Xóa\n" +
                    "5. Tìm\n" +
                    "6. Sắp xếp");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    produceService.themMoi();
                    break;
                case 2:
                    produceService.hienThi();
                    break;
                case 3:
                    produceService.sua();
                    break;
                case 4:
                    produceService.xoa();
                    break;
                case 5:
                    produceService.timKiem();
                    break;
                case 6:
                    produceService.sapXep();
                    break;
            }
        }
    }
}
