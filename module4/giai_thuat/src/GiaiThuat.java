public class GiaiThuat {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int sum1 = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length-2 ; i++) {
         sum1+=nums[i];
            if(sum1==nums[nums.length-1]){
                flag = true;
            }
        }
        System.out.printf(String.valueOf(flag));
    }
}
