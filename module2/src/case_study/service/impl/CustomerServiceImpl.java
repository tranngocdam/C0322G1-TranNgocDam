package case_study.service.impl;

import case_study.model.Customer;
import case_study.service.CustomerService;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Customer>customers=new LinkedList<>();
    static {
        customers.add(new Customer("nguyễn bình", "3/2/2011", "nữ", 244332, 45454,"binh@gmail", "HK6", "Silver","đà nẵng"));
        customers.add(new Customer("vũ anh", "3/9/1963", "nữ", 999332, 946354,"anh@gmail", "VA8", "Gold","quảng nam"));
    }
    @Override
    public void add() {
        System.out.print("Nhập họ: ");
        String hoTen=scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        String ngaySinh=scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        String gioiTinh=scanner.nextLine();
        System.out.print("Nhập số CMND: ");
        Integer soCMND=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập số ĐT: ");
        Integer soDienThoai=Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập email: ");
        String email=scanner.nextLine();
        System.out.print("Nhập mã khách hàng: ");
        String maKhachHang=scanner.nextLine();
        System.out.print("Nhập loại khách: ");
        String loaiKhach=scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        String diaChi=scanner.nextLine();
        Customer customer=new Customer(hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, maKhachHang, loaiKhach, diaChi);
        customers.add(customer);
    }

    @Override
    public void display() {
        for (Customer cus: customers) {
            System.out.println(cus);
        }
    }
}
