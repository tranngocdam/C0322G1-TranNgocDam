package bai_thi.service.impl;

import bai_test.common.exception.NotFoundSavingException;
import bai_thi.common.exception.NotFoundProductException;
import bai_thi.common.math.MathCommon;
import bai_thi.common.read_write.Read;
import bai_thi.common.read_write.Write;
import bai_thi.model.DienThoaiSachTay;
import bai_thi.service.DienThoaiSachTayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiSachTayServiceimpl implements DienThoaiSachTayService {
    private static Scanner scanner=new Scanner(System.in);
    public static List<DienThoaiSachTay>dienThoaiSachTayList=new ArrayList<>();
    static {
        dienThoaiSachTayList.add(new DienThoaiSachTay("1", "Iphone", 3232.2, 45, "Iphone"," USA", 1));
        dienThoaiSachTayList.add(new DienThoaiSachTay("2", "Samsung", 2212.2, 15, "Samsung"," China", 2));
        dienThoaiSachTayList.add(new DienThoaiSachTay("3", "LG", 562.2, 9, "LG","Japna", 2));
        dienThoaiSachTayList.add(new DienThoaiSachTay("4", "Iphone", 23362.2, 12, "Iphone","Japna", 1));
        Write.writeToCSVDienThoaiSachTay(dienThoaiSachTayList,false);
    }
    @Override
    public void themMoi() {
        //dienThoaiSachTayList= Read.readToCSVDienThoaiSachTay();
        System.out.println("Nhập ID: ");
        String ID=scanner.nextLine();
        System.out.println("Nhập tên điện thoại: ");
        String tenDienThoai=scanner.nextLine();
        System.out.println("Nhập giá bán: ");
        Double giaBan= MathCommon.getDouble1();
        System.out.println("Nhập số lượng: ");
        Integer soLuong=MathCommon.getInteger1();
        System.out.println("Nhập nhà sản xuất: ");
        String nhaSanXuat=scanner.nextLine();
        System.out.println("Nhập quốc gia sách tay: ");
        String quocGiaSachTay=scanner.nextLine();
        System.out.println("Nhập trạng thái: ");
        Integer trangThai=Integer.parseInt(scanner.nextLine());
        DienThoaiSachTay dienThoaiSachTay= new DienThoaiSachTay(ID, tenDienThoai, giaBan, soLuong, nhaSanXuat, quocGiaSachTay, trangThai );
        dienThoaiSachTayList.add(dienThoaiSachTay);
        Write.writeToCSVDienThoaiSachTay(dienThoaiSachTayList,false);
    }

    @Override
    public void hienThi() {
        //dienThoaiSachTayList= Read.readToCSVDienThoaiSachTay();
        for (DienThoaiSachTay d: dienThoaiSachTayList) {
            System.out.println(d);
            //d.Display();
        }
    }

    @Override
    public void timKiem() {
        //dienThoaiSachTayList= Read.readToCSVDienThoaiSachTay();
        System.out.println("Nhập tên điện thoại: ");
        String tenDienThoai = scanner.nextLine();
        for (int i = 0; i < dienThoaiSachTayList.size(); i++) {
            if (DienThoaiSachTayServiceimpl.dienThoaiSachTayList.get(i).getTenDienThoai().contains(tenDienThoai)) {
                System.out.println(DienThoaiSachTayServiceimpl.dienThoaiSachTayList.get(i));
            }
        }
        Write.writeToCSVDienThoaiSachTay(dienThoaiSachTayList,false);
    }

    @Override
    public void xoa() {
        //dienThoaiSachTayList= Read.readToCSVDienThoaiSachTay();
        String ID;
        int choice;
        while (true) {
            try {
                System.out.println("Nhập ID: ");
                ID = scanner.nextLine();
                if (!ID.matches("^([0-9]{1,})$")) {
                    throw new NotFoundProductException("ID điện thoại không tồn tại");
                }
                break;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < dienThoaiSachTayList.size(); i++) {
            if (ID.equals(dienThoaiSachTayList.get(i).getID())) {
                System.out.println("Bạn muốn xóa không?\n" +
                        "1. yes\n" +
                        "2. no\n");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    dienThoaiSachTayList.remove(i);
                } else {
                    scanner.nextLine();
                }
            }
        }
        Write.writeToCSVDienThoaiSachTay(dienThoaiSachTayList,false);
    }
}
