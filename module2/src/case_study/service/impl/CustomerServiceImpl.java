package case_study.service.impl;

import case_study.model.Customer;
import case_study.service.CustomerService;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner=new Scanner(System.in);
    public static List<Customer>customers=new LinkedList<>();
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
        System.out.print("Nhập loại khách\n" +
                "1. Diamond\n" +
                "2. Platinium\n" +
                "3. Gold\n" +
                "4. Silver\n" +
                "5. Member\n");
        int choice=Integer.parseInt(scanner.nextLine());
        String loaiKhach=null;
        switch (choice){
            case 1:
                loaiKhach="Diamond";
                break;
            case 2:
                loaiKhach="Pltinium";
                break;
            case 3:
                loaiKhach="Gold";
                break;
            case 4:
                loaiKhach="Silver";
                break;
            case 5:
                loaiKhach="Member";
                break;
        }
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

    @Override
    public void edit() {
        boolean check=false;
        System.out.println("Nhập mã khách hàng: ");
        String maKhachHang=scanner.nextLine();
        Customer customer=null;
        for (int i = 0; i <customers.size() ; i++) {
            if (maKhachHang.equals(customers.get(i).getMaKhachHang())){
                customer=customers.get(i);
                check=true;
            }
        }
        if (!check){
            System.out.println("Mã khách hàng không tồn tại");
            return;
        }
    }
}
