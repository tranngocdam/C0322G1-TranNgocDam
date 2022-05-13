package case_study_1.service.impl;

import case_study.common.exception.NotYet18YearOldException;
import case_study.common.exception.Over100YearsOldException;
import case_study_1.common.exception.AfterCurrentDateException;
import case_study_1.common.exception.CinemaFormatException;
import case_study_1.model.Cinema;
import case_study_1.service.CinemaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaServiceimpl implements CinemaService {
    private static Scanner scanner=new Scanner(System.in);
    public static List<Cinema>cinemaList=new ArrayList<>();
    static {
        cinemaList.add(new Cinema("CI-1232", "tây du kí", 34, "09/05/2022"));
        cinemaList.add(new Cinema("CI-4545", "hoa cỏ", 84, "06/05/2022"));
        cinemaList.add(new Cinema("CI-2323", "mặt trời", 231, "01/05/2022"));
    }
    @Override
    public void themMoi() {
        //String maChieuPhim;
        boolean check=true;
        checkMaChieuPhim(check);
        System.out.println("Nhập tên phim: ");
        String tenPhim=scanner.nextLine();
        System.out.println("Nhập số lượng vé: ");
        Integer soLuongVe=Integer.parseInt(scanner.nextLine());

        String ngayChieu;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhập ngày chiếu dd/MM/yyyy: ");
            ngayChieu = scanner.nextLine();
            try {
                LocalDate localDate = LocalDate.parse(ngayChieu, formatter);
                LocalDate now = LocalDate.now();
                if (localDate.isBefore(now)) {
                    throw new AfterCurrentDateException("Sau ngày hiện tại");
                }
                break;
            } catch (AfterCurrentDateException e) {
                System.out.println(e.getMessage());
            } catch (DateTimeParseException e) {
                System.out.println("không đúng định dạng");
            }
        }
        //Cinema cinema=new Cinema(maChieuPhim, tenPhim, soLuongVe, ngayChieu);
       // cinemaList.add(cinema);
    }

    private void checkMaChieuPhim(boolean check) {
        String maChieuPhim=null;
        while (check){
            System.out.println("Nhập mã chiếu phim: ");
            maChieuPhim=scanner.nextLine();
             try {
                 if(!maChieuPhim.matches("^(CI)(\\-[0-9]{4})$")){
                     throw new CinemaFormatException("Sai cú pháp vd(CI-2121, CI-4401)");
                 }
                 for (Cinema c: cinemaList) {
                     if(maChieuPhim.equals(c.getMaChieuphim())){
                         check = true;
                         System.out.println("Mã trùng lặp, vui lòng nhập lại");
                     }else {
                         check = false;
                     }
                 }
             }catch (CinemaFormatException e){
                 System.out.println(e.getMessage());
             }
        }
    }

    @Override
    public void danhSach() {
        for (Cinema c: cinemaList) {
            System.out.println(c);
        }
    }

    @Override
    public void xoa() {
        System.out.println("Nhập mã chiếu phim");
        String maChieuPhim=scanner.nextLine();
        int choice;
        for (int i=0; i<cinemaList.size(); i++) {
            if(maChieuPhim.equals(CinemaServiceimpl.cinemaList.get(i).getMaChieuphim())){
                System.out.println("Bạn có muốn xóa không\n" +
                        "1. Yes\n" +
                        "2. No");
                choice=Integer.parseInt(scanner.nextLine());
                if ((choice==1)){
                    cinemaList.remove(i);
                    break;
                }
            }
        }
        System.out.println("Mã không tồn tại");
    }

}
