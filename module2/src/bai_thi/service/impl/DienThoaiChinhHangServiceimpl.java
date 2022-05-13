package bai_thi.service.impl;

import bai_test.service.impl.GiangVienServiceimpl;
import bai_thi.common.exception.NotFoundProductException;
import bai_thi.common.math.MathCommon;
import bai_thi.common.read_write.Read;
import bai_thi.common.read_write.Write;
import bai_thi.model.DienThoaiChinhHang;
import bai_thi.service.DienThoaiChinhHangService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DienThoaiChinhHangServiceimpl implements DienThoaiChinhHangService {
    private static Scanner scanner=new Scanner(System.in);
    public static List<DienThoaiChinhHang>dienThoaiChinhHangList=new ArrayList<>();
    static {
        dienThoaiChinhHangList.add(new DienThoaiChinhHang("1", "Samsung",34434.4, 5,"Samsung", "365", 1));
        dienThoaiChinhHangList.add(new DienThoaiChinhHang("2", "Iphone",11222.3, 25,"iphone", "233", 2));
        dienThoaiChinhHangList.add(new DienThoaiChinhHang("3", "LG",34342.3, 9,"LG", "100", 2));
        dienThoaiChinhHangList.add(new DienThoaiChinhHang("4", "Iphone",21222.3, 9,"Iphone", "100", 2));
        Write.writeToCSVDienThoaiChinhHang(dienThoaiChinhHangList,false);
    }
    @Override
    public void themMoi() {
        //dienThoaiChinhHangList=Read.readToCSVDienThoaiChinhHang();
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
        System.out.println("Nhập thời gian bảo hành: ");
        String thoiGianBaoHanh=scanner.nextLine();
        System.out.println("Nhập phạm vi bảo hành: ");
        Integer phamViBaoHanh=Integer.parseInt(scanner.nextLine());
        DienThoaiChinhHang dienThoaiChinhHang=new DienThoaiChinhHang(ID, tenDienThoai, giaBan, soLuong, nhaSanXuat, thoiGianBaoHanh, phamViBaoHanh);
        dienThoaiChinhHangList.add(dienThoaiChinhHang);
        Write.writeToCSVDienThoaiChinhHang(dienThoaiChinhHangList,false);
    }

    @Override
    public void hienThi() {
        //dienThoaiChinhHangList=Read.readToCSVDienThoaiChinhHang();
        for (DienThoaiChinhHang d : dienThoaiChinhHangList) {
            System.out.println(d);
            //d.Display();
        }
    }

    @Override
    public void timKiem() {
        //dienThoaiChinhHangList=Read.readToCSVDienThoaiChinhHang();
        System.out.println("Nhập tên điện thoại: ");
        String tenDienThoai = scanner.nextLine();
        for (int i = 0; i < dienThoaiChinhHangList.size(); i++) {
            if (DienThoaiChinhHangServiceimpl.dienThoaiChinhHangList.get(i).getTenDienThoai().contains(tenDienThoai)) {
                System.out.println(DienThoaiChinhHangServiceimpl.dienThoaiChinhHangList.get(i));
            }
        }
        Write.writeToCSVDienThoaiChinhHang(dienThoaiChinhHangList,false);
    }

    @Override
    public void xoa() {
        //dienThoaiChinhHangList=Read.readToCSVDienThoaiChinhHang();
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
        for (int i = 0; i <dienThoaiChinhHangList.size(); i++) {
            if (ID.equals(dienThoaiChinhHangList.get(i).getID())) {
                System.out.println("Bạn muốn xóa không?\n" +
                        "1. yes\n" +
                        "2. no\n");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    dienThoaiChinhHangList.remove(i);
                } else {
                    scanner.nextLine();
                }
            }
        }
        Write.writeToCSVDienThoaiChinhHang(dienThoaiChinhHangList,false);
    }
}
