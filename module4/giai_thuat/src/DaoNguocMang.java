import java.util.Scanner;

public class DaoNguocMang {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int array[]=new int[6];
        for (int i=0; i<array.length; i++){
            System.out.print("phần tử: ");
            array[i]=Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+", ");
        }
        System.out.println("");
        String arr1="toiyeuem";
        int c[]=daoNguocMang(array);
        for (int i = 0; i <array.length ; i++) {
            System.out.print(c[i]+", ");
        }
    }
    private static int[] daoNguocMang(int arr[]){
        int first=0;
        int last=arr.length-1;
        while (first<last){
            int dem=arr[first];
            arr[first]=arr[last];
            arr[last]=dem;
            first++;
            last--;
        }
        return arr;
    }
}
