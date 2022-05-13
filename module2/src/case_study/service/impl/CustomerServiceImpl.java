package case_study.service.impl;

import case_study.common.exception.*;
import case_study.common.math.MathCommon;
import case_study.common.read_writer.Read;
import case_study.common.read_writer.Write;
import case_study.model.Customer;
import case_study.service.CustomerService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();

//    static {
//        customers.add(new Customer("Nguyen Bi", "03/02/2011", "nu", 244332, 45454,
//                "binh4@gmail", "NB6", "Silver", "Da Nang"));
//        customers.add(new Customer("Vu Anh", "03/09/1963", "nam", 999332, 94354,
//                "anh@gmail", "VA8", "Gold", "Quang Nam"));
//        Write.writeToCSVCustomer(customers, false);
//        //
//    }

    @Override
    public void add() {
        customers = Read.readToCSVCustomer();
        String hoTen;
        while (true) {
            System.out.print("Nhập họ tên: ");
            hoTen = scanner.nextLine();
            try {
                if (!hoTen.matches("^([A-Z][a-z]{1,})\\s([A-Z][a-z]{0,})+(\\s([A-Z][a-z]{0,}+))?$")) {
                    throw new CustomerCodeFormatException("Lỗi cú pháp(vd:Nguyen Van A, Nguyen A)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String ngaySinh;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày sinh dd/MM/yyyy: ");
            ngaySinh = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
                LocalDate now = LocalDate.now();
                now = now.plusYears(-18);
                if (localDate.isAfter(now)) {
                    throw new NotYet18YearOldException("Chưa đủ 18 tuổi");
                }
                now = now.plusYears(-82);
                if (localDate.isBefore(now)) {
                    throw new Over100YearsOldException("Hơn 100 tuổi");
                }
                break;
            } catch (NotYet18YearOldException | Over100YearsOldException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("không đúng định dạng");
            }
        }

        String gioiTinh;
        while (true) {
            try {
                System.out.print("Nhập giới tính: ");
                gioiTinh = scanner.nextLine();
                if (!gioiTinh.matches("^nam|nu$")) {
                    throw new CustomerCodeFormatException("Lỗi nhập giới tính, viết không dấu(vd nam or nu)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nhập số CMND: ");
        Integer soCMND = MathCommon.getSoCMND();

        System.out.print("Nhập số ĐT: ");
        Integer soDienThoai = MathCommon.getSoDienThoai();

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            try {
                if (!email.matches("^([a-z]{0,})+([0-9]+)?(@gmail\\.com)$")) {
                    throw new CustomerCodeFormatException("Lỗi sai cú pháp(vd a@gmail.com, na12@gmail.com)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        String maKhachHang;
        while (true) {
            try {
                System.out.print("Nhập mã khách hàng: ");
                maKhachHang = scanner.nextLine();
                if (!maKhachHang.matches("^[A-Z]{1,}[0-9]{1,}$")) {
                    throw new CustomerCodeFormatException("Lỗi cú pháp(vd VH09, V9)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Nhập loại khách\n" +
                "1. Diamond\n" +
                "2. Platinium\n" +
                "3. Gold\n" +
                "4. Silver\n" +
                "5. Member\n");
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 5) {
                    throw new LimitMenuException("Lựa chọn không hợp lệ");
                }
                break;
            } catch (LimitMenuException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Không nhập kí tự");
            }
        }
        String loaiKhach = null;
        switch (choice) {
            case 1:
                loaiKhach = "Diamond";
                break;
            case 2:
                loaiKhach = "Pltinium";
                break;
            case 3:
                loaiKhach = "Gold";
                break;
            case 4:
                loaiKhach = "Silver";
                break;
            case 5:
                loaiKhach = "Member";
                break;
        }
        String diaChi;
        while (true) {
            try {
                System.out.print("Nhập địa chỉ: ");
                diaChi = scanner.nextLine();
                if (diaChi.matches("^([A-Z][a-z]{0,})(\\s([A-Z][a-z]{1,}+))?$")) {
                    throw new CustomerCodeFormatException("Lỗi địa chỉ(vd Da Nang, Ha Noi, Hue)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        //Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, maKhachHang, loaiKhach, diaChi);
        //customers.add(customer);
        Write.writeToCSVCustomer(customers, false);
        //customers = Read.readToCSVCustomer();
    }

    @Override
    public void display() {
        customers = Read.readToCSVCustomer();
        for (Customer cus : customers) {
            System.out.println(cus);
            //cus.display();
        }
    }

    @Override
    public void edit() {
        boolean check = false;
        System.out.print("Nhập mã khách hàng: ");
        String maKhachHang = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (maKhachHang.equals(customers.get(i).getMaKhachHang())) {

                index = i;
                check = true;
            }
        }
        if (!check) {
            System.out.println("Mã khách hàng không tồn tại");
            return;
        }
        String hoTen;
        while (true) {
            System.out.print("Nhập họ tên: ");
            hoTen = scanner.nextLine();
            try {
                if (!hoTen.matches("^([A-Z][a-z]{1,})\\s([A-Z][a-z]{0,})+(\\s([A-Z][a-z]{1,}+))?$")) {
                    throw new CustomerCodeFormatException("Lỗi họ tên(Nguyen Van A, Nguyen A)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Không nhập chữ số, kí tự");
            }
        }

        String ngaySinh;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày sinh dd/MM/yyyy: ");
            ngaySinh = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(ngaySinh, formatter);
                LocalDate now = LocalDate.now();
                now = now.plusYears(-18);
                if (localDate.isAfter(now)) {
                    throw new NotYet18YearOldException("Chưa đủ 18 tuổi");
                }
                now = now.plusYears(-82);
                if (localDate.isBefore(now)) {
                    throw new Over100YearsOldException("Hơn 100 tuổi");
                }
                break;
            } catch (NotYet18YearOldException | Over100YearsOldException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("không đúng định dạng");
            }

        }
        String gioiTinh;
        while (true) {
            try {
                System.out.print("Nhập giới tính: ");
                gioiTinh = scanner.nextLine();
                if (!gioiTinh.matches("^nam|nu$")) {
                    throw new CustomerCodeFormatException("Lỗi, viết không dấu(nam or nu)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập số CMND: ");
        Integer soCMND = MathCommon.getSoCMND();

        System.out.print("Số điện thoại: ");
        Integer soDienThoai = MathCommon.getSoDienThoai();

        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            try {
                if (!email.matches("^([a-z]{0,})+([0-9]+)?(@gmail\\.com)$")) {
                    throw new CustomerCodeFormatException("Lỗi sai cú pháp(vd a@gamil.com)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập loại khách\n" +
                "1. Diamond\n" +
                "2. Platinium\n" +
                "3. Gold\n" +
                "4. Silver\n" +
                "5. Member\n");
        int choice;
        while (true) {
            try {
                System.out.println("Chọn");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 5) {
                    throw new LimitMenuException("Lựa chọn bị sai");
                }
                break;
            } catch (LimitMenuException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.err.print("Không nhập kí tự");
            }
        }

        String loaiKhach = null;
        switch (choice) {
            case 1:
                loaiKhach = "Diamond";
                break;
            case 2:
                loaiKhach = "Pltinium";
                break;
            case 3:
                loaiKhach = "Gold";
                break;
            case 4:
                loaiKhach = "Silver";
                break;
            case 5:
                loaiKhach = "Member";
                break;
        }
        String diaChi;
        while (true) {
            try {
                System.out.print("Nhập địa chỉ: ");
                diaChi = scanner.nextLine();
                if (diaChi.matches("^([A-Z][a-z]{1,})(\\s([A-Z][a-z]{1,}+))?$")) {
                    throw new CustomerCodeFormatException("Lỗi địa chỉ(vd Da Nang, Ha Noi, Hue)");
                }
                break;
            } catch (CustomerCodeFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        //Customer customer = new Customer(hoTen, ngaySinh, gioiTinh, soCMND, soDienThoai, email, maKhachHang, loaiKhach, diaChi);
        //customers.set(index, customer);
        Write.writeToCSVCustomer(customers, false);
    }
}
