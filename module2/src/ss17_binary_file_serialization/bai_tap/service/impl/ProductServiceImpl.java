package ss17_binary_file_serialization.bai_tap.service.impl;

import ss17_binary_file_serialization.bai_tap.common.read_write.WriteAndRead;
import ss17_binary_file_serialization.bai_tap.model.Product;
import ss17_binary_file_serialization.bai_tap.service.IService;
import ss17_binary_file_serialization.bai_tap.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Product>products=new ArrayList<>();
    static {
        products.add(new Product("kd", "kẹo", "thanh long", 55000.0, "chat luong cao"));
        products.add(new Product("bq", "bánh", "orio", 9868.0, "ISO9900"));
        WriteAndRead.WriteFile(products);
    }
    @Override
    public void themMoi() {
        System.out.print("Nhập mã sản phẩm: ");
        String maSanPham = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String hangSanXuat = scanner.nextLine();
        System.out.print("Nhập giá: ");
        Double gia=Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mô tả khác: ");
        String moTaKhac=scanner.nextLine();
        Product product=new Product(maSanPham, tenSanPham, hangSanXuat, gia, moTaKhac);
        products.add(product);
        WriteAndRead.WriteFile(products);
    }

    @Override
    public void hienThi() {
        for (Product p: WriteAndRead.readFile()) {
            System.out.println(p);
        }
    }

    @Override
    public void timKiem() {
        boolean check=false;
        System.out.println("Nhập mã sản phẩm: ");
        String maSanPham=scanner.nextLine();
        for (int i = 0; i < products.size() ; i++) {
            if(maSanPham.equals(ProductServiceImpl.products.get(i).getMaSanPham())){
                check=true;
                System.out.println(ProductServiceImpl.products.get(i));
            }
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
}
