package ss14_thuat_toan_sap_xep.bai_tap;

public class ThuatToanSapXepChen {
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        int[] arr={2, 9, 5, 4, 8, 1, 6};
        insertionSort(arr);
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"\t");

        }
    }
}
