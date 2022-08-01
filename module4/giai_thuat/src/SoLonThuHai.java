public class SoLonThuHai {
    public static void main(String[] args) {
        int array[] = {9,11,2,8,43,65,2,1};
        System.out.println(soLonThuHai(array));
        int[] b=sapXep(array);
        for (int i = 0; i <b.length; i++) {
            System.out.print(b[i]+", ");
        }

    }
    public static int soLonThuHai(int arr[]){
        int firstMax, secondMax;
        if(arr[0]>arr[1]){
            firstMax=arr[0];
            secondMax=arr[1];
        }else {
            firstMax=arr[1];
            secondMax=arr[0];
        }
        for (int i = 2; i <arr.length ; i++) {
            if (arr[i]>=firstMax){
                secondMax=firstMax;
                firstMax=arr[i];
            }else if(arr[i]>secondMax){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }
    public static int[] sapXep(int arr[]){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){
                    int dem=arr[i];
                    arr[i]=arr[j];
                    arr[j]=dem;
                }
            }
        }
        return arr;
    }
}
