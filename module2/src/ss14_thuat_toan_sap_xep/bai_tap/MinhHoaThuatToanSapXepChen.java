package ss14_thuat_toan_sap_xep.bai_tap;

import java.util.Arrays;

public class MinhHoaThuatToanSapXepChen {
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                System.out.println("dịch chuyển");
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
            System.out.println("Lần thứ"+i+":"+ Arrays.toString(array));
        }
    }
    public static void main(String[] args) {
        int[] arr1={2, 9, 5, 4, 8, 1, 6};
        int[] arr2={2, 4, 6, 8, 10, 12, 14};
        insertionSort(arr1);
        for (int i = 0; i <arr1.length ; i++) {
            System.out.print(arr1[i]+"\t");

        }
    }
}
