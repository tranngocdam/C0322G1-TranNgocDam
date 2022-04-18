package ss12_map_tree.bai_tap;

import ss12_map_tree.ProduceService;

import java.util.Scanner;

public class Main {
    private static ProduceService produceService=new ProductManager();
    public static void main(String[] args) {
        int choice;
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("Danh sách:\n" +
                    "1. Thêm mới\n" +
                    "2. Hiển thị\n" +
                    "3. Xóa\n" +
                    "4. Tìm");
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
                    produceService.xoa();
                    break;
                case 4:
                    produceService.timKiem();
                    break;
            }
        }
    }
}
