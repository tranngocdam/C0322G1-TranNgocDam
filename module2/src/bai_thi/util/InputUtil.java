package bai_thi.util;

import bai_thi.common.exception.LimitException;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner=new Scanner(System.in);
    public static int luaChon(int batDau, int ketThuc){
        int luaChon=0;
        do {
            System.out.print("Nhập vào lựa chọn của bạn: ");
            try{
                luaChon = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập vào số");
                continue;
            }
            try {
                if (luaChon < batDau || luaChon > ketThuc) {
                    throw new LimitException(String.format("Giá trị chỉ được phép [%d - %d], xin kiểm tra lại!\n", batDau, ketThuc));
                }
            }catch (LimitException e){
                System.out.println(e.getMessage());
            }
        }while (luaChon < batDau || luaChon > ketThuc);

        return luaChon;
    }
}
