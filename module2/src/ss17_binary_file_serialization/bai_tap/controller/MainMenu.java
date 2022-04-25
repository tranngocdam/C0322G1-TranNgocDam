package ss17_binary_file_serialization.bai_tap.controller;

import ss17_binary_file_serialization.bai_tap.model.Product;
import ss17_binary_file_serialization.bai_tap.service.ProductService;
import ss17_binary_file_serialization.bai_tap.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class MainMenu {
    private static ProductService productService=new ProductServiceImpl();
    private static Scanner scanner=new Scanner(System.in);
    public static void Display() {
        while (true) {
            System.out.println("Chọn chức năng:\n" +
                    "1. Thêm mới\n" +
                    "2. Hiển thị\n" +
                    "3. Tìm kiếm\n" +
                    "4. Thoát\n");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    productService.themMoi();
                    break;
                case 2:
                    productService.hienThi();
                    break;
                case 3:
                    productService.timKiem();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
