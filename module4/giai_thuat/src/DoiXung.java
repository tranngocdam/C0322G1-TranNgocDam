public class DoiXung {
    public static void main(String[] args){
        int[] array={1,2,3,8,0,2,1};

            if(doiXung(array)==1){
                System.out.printf("đối xứng");
            }else {
                System.out.printf("ko");
            }

    }
    public static int doiXung(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length -1-i]) {
                return  -1;
            }
        }
        return 1;
    }
}
