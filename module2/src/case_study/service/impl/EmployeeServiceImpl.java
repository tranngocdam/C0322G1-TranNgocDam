package case_study.service.impl;

import case_study.common.exception.CustomerCodeFormatException;
import case_study.common.exception.EmployeeCodeFormatException;
import case_study.common.exception.LimitMenuException;
import case_study.common.math.MathCommon;
import case_study.common.read_writer.Write;
import case_study.model.Employee;
import case_study.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static Scanner scanner=new Scanner(System.in);
    private static List<Employee>employees=new ArrayList<>();

    static {
        employees.add(new Employee("Tran Nam", "3/5/1999","nam", 205456, 98755
                , "trannam@gmail", "TN3", "đại học", "chuyên viên", 560000.0));
        employees.add(new Employee("Nguyen Vi", "8/9/2011","nu", 234563, 23556
                , "vi@gmail", "NV8", "trung cấp", "lễ tân", 340000.0));
        Write.writeToCSVEmployee(employees,false);
    }

    @Override
    public void add() {

        String hoTen;
        while (true){
            System.out.print("Nhập họ tên: ");
            hoTen=scanner.nextLine();
            try {
                if(!hoTen.matches("^([A-Z][a-z]{1,})\\s([A-Z][a-z]{0,})+(\\s([A-Z][a-z]{0,}+))?$")){
                    throw new EmployeeCodeFormatException("Lỗi cú pháp(vd:Nguyen Van A, Nguyen A)");
                }
                break;
            }catch (EmployeeCodeFormatException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập ngày sinh: ");
        String ngaySinh=scanner.nextLine();

        String gioiTinh;
        while (true){
            try {
                System.out.print("Nhập giới tính: ");
                gioiTinh=scanner.nextLine();
                if(!gioiTinh.matches("^nam|nu$")){
                    throw new EmployeeCodeFormatException("Lỗi, giới tính viết không dấu(nam or nu)");
                }
                break;
            }catch (EmployeeCodeFormatException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập số CMND: ");
        Integer soCMND= MathCommon.getSoCMND();

        System.out.print("Nhập số ĐT: ");
        Integer soDienThoai=MathCommon.getSoDienThoai();

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            try {
                if (!email.matches("^([a-z]{0,})+([0-9]+)?(@gmail\\.com)$")) {
                    throw new CustomerCodeFormatException("Lỗi sai cú pháp(vd a@gmail.com, bin11@gmail.com)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String maNhanVien;
        while (true){
            try {
                System.out.print("Nhập mã nhân viên: ");
                maNhanVien=scanner.nextLine();
                if(!maNhanVien.matches("^[A-Z]{1,}[0-9]{1,}$")){
                    throw new CustomerCodeFormatException("Lỗi cú pháp(vd VH09, V09)");
                }
                break;
            }catch (CustomerCodeFormatException e){
                System.out.println(e.getMessage());
            }
        }

        String trinhDo=null;
        System.out.print("Nhập trình độ\n" +
                "1. Trung cấp\n" +
                "2. Cao đẳng\n" +
                "3. Đại học\n" +
                "4. Sau đại học\n");
        int choice1;
        while(true){
            try {
                System.out.print("Chọn bậc: ");
                choice1 = Integer.parseInt(scanner.nextLine());
                if(choice1<1||choice1>4){
                    throw new LimitMenuException("Nhập sai lựa chọn");
                }
                break;
            }catch (LimitMenuException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.err.print("Không nhập kí tự");
            }
        }
        switch (choice1) {
            case 1:
                trinhDo = "Trung cấp";
                break;
            case 2:
                trinhDo = "Cao đẳng";
                break;
            case 3:
                trinhDo = "Đại học";
                break;
            case 4:
                trinhDo = "Sau đại học";
                break;
        }

        String viTri=null;
        System.out.print("Vị trí:\n" +
                "1. Lễ tân\n" +
                "2. Phục vụ\n" +
                "3. Chuyên viên\n" +
                "4. Giám sát\n" +
                "5. Quản lí\n" +
                "6. Giám đốc\n");
        int choice2;
        while(true){
            try {
                System.out.print("Chọn vị trí: ");
                choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2<1||choice2>6){
                    throw new EmployeeCodeFormatException("Nhập sai lựa chọn");
                }
                break;
            }catch (EmployeeCodeFormatException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.err.print("Không nhập kí tự");
            }
        }
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
        Write.writeToCSVEmployee(employees,false);
    }

    //@Override
    public void display() {
        for (Employee epl:employees) {
            //System.out.println(epl);
            epl.display();
        }
    }

    @Override
    public void edit() {
        boolean check=false;
        int index=-1;
        //Employee employee=null;
        System.out.print("Nhập mã nhân viên: ");
        String maNhanVien=scanner.nextLine();;
        for (int i = 0; i < employees.size(); i++) {
            if (maNhanVien.equals(employees.get(i).getMaNhanVien())) {
                check = true;
                index=i;
                break;
            }
        }
        if (!check) {
            System.out.println("Không tồn tại mã nhân viên");
            return;
        }
        String hoTen;
        while (true){
            System.out.print("Nhập họ tên: ");
            hoTen=scanner.nextLine();
            try {
                if(!hoTen.matches("^([A-Z][a-z]{1,})\\s([A-Z][a-z]{0,})+(\\s([A-Z][a-z]{1,}+))?$")){
                    throw new CustomerCodeFormatException("Lỗi họ tên(vd Nguyen Van A, Nguyen A)");
                }
                break;
            }catch (CustomerCodeFormatException e){
                System.out.println(e.getMessage());
            }
            catch (Exception e){
                System.out.println("Không nhập chữ số");
            }
        }

        System.out.print("Nhập ngày sinh: ");
        String ngaySinh=scanner.nextLine();

        String gioiTinh;
        while (true){
            try {
                System.out.print("Nhập giới tính: ");
                gioiTinh=scanner.nextLine();
                if(!gioiTinh.matches("^nam|nu$")){
                    throw new CustomerCodeFormatException("Lỗi, viết không dấu(nam or nu)");
                }
                break;
            }catch (CustomerCodeFormatException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập số CMND: ");
        Integer soCMND=MathCommon.getSoCMND();

        System.out.print("Số điện thoại: ");
        Integer soDienThoai=MathCommon.getSoDienThoai();

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            try {
                if (!email.matches("^([a-z]{0,})+([0-9]+)?(@gmail\\.com)$")) {
                    throw new CustomerCodeFormatException("Lỗi sai cú pháp(vd a@gmail.com, a12@gmail.com )");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập trình độ\n" +
                "1. Trung cấp\n" +
                "2. Cao đẳng\n" +
                "3. Đại học\n" +
                "4. Sau đại học\n");
        int choice1;
        while(true){
            try {
                System.out.print("Chọn bậc: ");
                choice1 = Integer.parseInt(scanner.nextLine());
                if(choice1<1||choice1>4){
                    throw new LimitMenuException("Nhập sai lựa chọn");
                }
                break;
            }catch (LimitMenuException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.err.print("Không nhập kí tự");
            }
        }
        String trinhDo=null;
        switch (choice1) {
            case 1:
                trinhDo = "Trung cấp";
                break;
            case 2:
                trinhDo = "Cao đẳng";
                break;
            case 3:
                trinhDo = "Đại học";
                break;
            case 4:
                trinhDo = "Sau đại học";
                break;
        }

        System.out.print("Vị trí:\n" +
                "1. Lễ tân\n" +
                "2. Phục vụ\n" +
                "3. Chuyên viên\n" +
                "4. Giám sát\n" +
                "5. Quản lí\n" +
                "6. Giám đốc\n");
        int choice2;
        while(true){
            try {
                System.out.print("Chọn vị trí: ");
                choice2 = Integer.parseInt(scanner.nextLine());
                if (choice2<1||choice2>6){
                    throw new EmployeeCodeFormatException("Nhập sai lựa chọn");
                }
                break;
            }catch (EmployeeCodeFormatException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.err.print("Không nhập kí tự");
            }
        }
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

        Employee employee1=new Employee(hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, maNhanVien, trinhDo, viTri, luong );
        employees.set(index,employee1);
//write
    }
}
