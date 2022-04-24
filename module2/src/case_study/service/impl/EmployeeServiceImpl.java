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
        System.out.print("Nhập họ tên: ");
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
        System.out.print("Nhập trình độ\n" +
                "1. Trung cấp\n" +
                "2. Cao đẳng\n" +
                "3. Đại học\n" +
                "4. Sau đại học\n: ");
        int choice1=Integer.parseInt(scanner.nextLine());
        String trinhDo=null;
        switch (choice1){
            case 1:
                trinhDo="Trung cấp";
                break;
            case 2:
                trinhDo="Cao đẳng";
                break;
            case 3:
                trinhDo="Đại học";
                break;
            case 4:
                trinhDo="Sau đại học";
                break;
        }
        System.out.print("Nhập vị trí\n" +
                "1. Lễ tân\n" +
                "2. Phục vụ\n" +
                "3. Chuyên viên\n" +
                "4. Giám sát\n" +
                "5. Quản lí\n" +
                "6. Giám đốc\n");
        int choice2=Integer.parseInt(scanner.nextLine());
        String viTri=null;
        switch (choice2){
            case 1:
                viTri="Lễ tân";
                break;
            case 2:
                viTri="Phục vụ";
                break;
            case 3:
                viTri="Chuyên viên";
                break;
            case 4:
                viTri="Giám sát";
                break;
            case 5:
                viTri="Quản lí";
                break;
            case 6:
                viTri="Giám đốc";
                break;
        }
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
    public void edit() {
        boolean check=false;
        Employee employee=null;
        System.out.print("Nhập mã nhân viên: ");
        String maNhanVien=scanner.nextLine();
        for (int i = 0; i <employees.size(); i++) {
            if (maNhanVien.equals(employees.get(i).getMaNhanVien())) {
                check = true;
                employee=employees.get(i);
                break;
            }
        }
        if(!check){
            System.out.println("Không tồn tại");
            return;
        }
            System.out.println("Nhập thông tin muốn sửa:\n" +
                    "1. Họ tên\n" +
                    "2. Ngày sinh\n" +
                    "3. Giới tính\n" +
                    "4. Số điện thoại\n" +
                    "5. Email\n" +
                    "6. Trình độ\n" +
                    "7. Vị trí\n" +
                    "8. Lương\n");
            int choice=Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    System.out.print("Nhập họ tên: ");
                    String hoTen=scanner.nextLine();
                    employee.setHoTen(hoTen);
                    break;
                case 2:
                    System.out.print("Nhập ngày sinh: ");
                    String ngaySinh=scanner.nextLine();
                    employee.setNgaySinh(ngaySinh);
                    break;
                case 3:
                    System.out.print("Nhập giới tính: ");
                    String gioiTinh=scanner.nextLine();
                    employee.setGioiTinh(gioiTinh);
                    break;
                case 4:
                    System.out.print("Nhập số điện thoại: ");
                    Integer soDienThoai=Integer.parseInt(scanner.nextLine());
                    employee.setSoDienThoai(soDienThoai);
                    break;
                case 5:
                    System.out.print("Nhập email: ");
                    String email=scanner.nextLine();
                    employee.setEmail(email);
                    break;
                case 6:
                    System.out.print("Nhập trình độ: ");
                    String trinhDo=scanner.nextLine();
                    employee.setTrinhDo(trinhDo);
                    break;
                case 7:
                    System.out.print("Nhập vi trí: ");
                    String viTri=scanner.nextLine();
                    employee.setViTri(viTri);
                    break;
                case 8:
                    System.out.print("Nhập lương: ");
                    Double luong=Double.parseDouble(scanner.nextLine());
                    employee.setLuong(luong);
                    break;
            }

    }
}
