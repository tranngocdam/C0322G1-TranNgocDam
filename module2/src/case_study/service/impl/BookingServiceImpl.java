package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.Facility;
import case_study.service.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Scanner scanner=new Scanner(System.in);
    private static TreeSet<Booking>treeSet=new TreeSet<>();
    static {
        treeSet.add(new Booking("MB1","2001/8/6","2001/8/21","HK6", "KJH","Room"));
        treeSet.add(new Booking("MB2","2011/1/6","2011/1/21","VA1", "VAl","Villa"));
    }
    @Override
    public void add() {
        System.out.println("Nhập mã booking: ");
        String maBooking=scanner.nextLine();
        System.out.println("Nhập ngày bắt đầu: ");
        String ngayBatDau=scanner.nextLine();
        System.out.println("Nhập ngày kết thúc: ");
        String ngayKetThuc=scanner.nextLine();
        System.out.println("Mời chọn mã khách hàng:");
        for (int i = 0; i <CustomerServiceImpl.customers.size() ; i++) {
            System.out.println((i+1)+". "+CustomerServiceImpl.customers.get(i));
        }
        int choice=Integer.parseInt(scanner.nextLine());
        String maKhachHang=CustomerServiceImpl.customers.get(choice-1).getMaKhachHang();
        System.out.println("Mời chọn dịch vụ: ");
        Set<Facility>set=FacilityServiceImpl.linkedHashMap.keySet();
        List<Facility>list=new ArrayList<>(set);
        for (int i = 0; i <set.size() ; i++) {
            System.out.println((i+1)+". "+list.get(i));
        }
        int choice1=Integer.parseInt(scanner.nextLine());
        String tenDichVu=list.get(choice1-1).getTenDichVu();
        System.out.println("Nhập loai dịch vụ: ");
        String loaiDichVu=scanner.nextLine();
        Booking booking=new Booking(maBooking, ngayBatDau, ngayKetThuc, maKhachHang, tenDichVu, loaiDichVu);
        treeSet.add(booking);
    }

    @Override
    public void display() {
        for (Booking b: treeSet) {
            System.out.println(b);
        }
    }
}
