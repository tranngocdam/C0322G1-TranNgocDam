import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int array[]={2, 6, 7, 12, 34, 21, 9, 0};
        for (int i=0; i<array.length; i++){
            if (soNguyenTo(array[i])==true){
                System.out.print(array[i]+", ");
            }
        }
    }
    private static boolean soNguyenTo(int n){
        if (n<2){
            return false;
        }else {
            for (int i=2; i<n; i++){
                if (n%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
