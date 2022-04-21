package case_study.service.impl;

import case_study.model.Employee;
import case_study.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Employee>employees=new ArrayList<>();
    static {
        employees.add(new Employee("Trần Nam", "3/1999","Nam", 205456, 987556, "trannam@gmail", "N9J", "đại học", "chuyên viên", 560000.0));
        employees.add(new Employee("Nguyễn vi", "8/2011","Nữ", 23456, 23556, "vi@gmail", "V9K", "trung cấp", "lễ tân", 340000.0));
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
        System.out.print("Nhập mã nhân viên: ");
        String maNhanVien=scanner.nextLine();
        System.out.print("Nhập trình độ: ");
        String trinhDo=scanner.nextLine();
        System.out.print("Nhập vị trí: ");
        String viTri=scanner.nextLine();
        System.out.print("Nhập lương: ");
        Double luong=Double.parseDouble(scanner.nextLine());
        Employee employee=new Employee(hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, maNhanVien, trinhDo, viTri, luong);
        employees.add(employee);
    }

    @Override
    public void display() {
        for (Employee epl:employees) {
            System.out.println(epl);
        }
    }

    @Override
    public void exit() {
        boolean check=false;
        int index=-1;
        System.out.print("Nhập số CMND: ");
        String soCMND=scanner.nextLine();
        for (int i = 0; i <employees.size(); i++) {
//            if(soCMND==employees.get(i)){
//                index
            }
    }
}
