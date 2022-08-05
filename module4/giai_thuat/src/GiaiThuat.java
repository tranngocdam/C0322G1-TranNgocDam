public class GiaiThuat {
    //    static boolean b1, b2;
    public static void main(String[] args) {
//        bai1
//        int[] nums = {1,2,7,0,1,3,11};
//        int sum1 = 0;
//        boolean flag = false;
//        for (int i = 0; i < nums.length-2 ; i++) {
//         sum1+=nums[i];
//            if(sum1==nums[nums.length-1]){
//                flag = true;
//            }
//        }
//        System.out.printf(String.valueOf(flag));
//        --------------------------------------
//        bai2
//        for (int i = 0; i < 2; i++) {
//            switch (i) {
//                case 0:
////                    System.out.print("zero0");
////                    break;
//                case 1:
//                    System.out.print("one1");
////                    break;
//                case 2:
//                    System.out.print("two2");
////                    break;
//                case 3:
//                    System.out.print("three3");
////                    break;
//            }
//        }
//        System.out.println("done4");
//        -------------------------------------
//        bai3
//        int x = 300;
//        double y = 300.0;
//        boolean b = (x == y);
//        System.out.println(b);
//        ---------------------------------
//bai4
//        int a = 10, b = 5;
//        while (b <10) {
//            a++;
//            b=b+b;
//        }
//        System.out.println("a= " + b+ " b = " + b);
//        -------------------------------
//        int i = 3, j = -2;
//        i += j;//i=3-2=1
//        j -= i;//j=-2-1=-3
//        System.out.println(i + "," + j);
//----------------------------------------------
//        boolean x = false;
//        boolean y = !x;//true
//        System.out.print (!x || x==y);//true||false->true
//        System.out.print(x || x==y);//false||false=>false
//-----------------------------------------------
//        char i = 'b';
//        switch (i) {
//            case 'b':
//                System.out.print("Bi ");
//                break; // line 3
//            case 'a':
//                System.out.print("Ai "); // line 4
//            case 'c':
//                System.out.print("Ci");  // line 5
//            default:
//                System.out.print("Not found "); // line 6
//        }
//        ------------------------------
//        boolean x = false;
//        boolean y = false || true;//true
//        System.out.print (x&&y || x==y);//false||false=>false
//        System.out.print(x || y || x==y);//true||false=>true
//--------------------------------------------------
//        int x = 10;
//        int y = 20;
//        int z = x + y % x / 2;
//        System.out.println(z);
////----------------------------------------
//        int a, b;
//        a = 100;
//        b = (a == 200) ? 100 : 300;
//        System.out.println("b= " + b);
//--------------------------------
//        short hand = 32;
//        if (hand < 60)
//            hand++;
//        if (hand > 60)
//		else if (hand > 90) {
//            hand += 7;
//        } else
//            --hand;
//        System.out.println(hand);
//    }
//        ------------------------------------
//        int i = 1, j = -1;
//        switch (i){
//            case 0,1:
////            case 1:
//                j = 1;
//            case 2:
//                j = 2;
//            default:
//                j = 0;
//        }
//        System.out.println("j = " + j);
//---------------------------------------------------

//        int x = 15;
//        int y = 1;
//        if (x = y) {
//            System.out.println("x =" + x);
//        }
//          => x==y
//        -------------------
//        int value = 0;
//        boolean b1 = true;
//        boolean b2 = false, b;
//        b = (b1 | ((value++) == 0));//true
//        b = (b2 | ((value += 1) > 0));//true
//        System.out.print(value);
//        System.out.println(b);
//        -----------------------------
//        for (int i = 0; i < 2; i++) {
//            switch (i++) {
//                case 0:
//                    break;
//                case 1:
//                    System.out.print("one1 ");
//                case 2:
//                    System.out.print("two2");
//                case 3:
//                    System.out.print("three3 ");
//            }
//        }
//        System.out.println("done4");
//        --------------------------------------------
//        int x=200;
//        double y=200.1;
//        boolean b=(x=y);//boolean trả về true, false->lỗi biên dịch
//        System.out.println(b);
//        -----------------------------------------------
//        int a=10, b=5;
//        while (b--){
//            //trong while bthuc dkien
//            a++;
//        }
//        System.out.println("a="+a+ "b="+b);
//        --------------------------------------------------
//        for (int i = 1; i <=10 ; i++) {
//            if(i>6){
//                continue;
//            }
//            System.out.println(i);
//        }
//        -------------------------------------
//        boolean x = false && false;//false
//        boolean y = false || true;//true
//        System.out.print (x&&y || x==y);//false||false=>false
//        System.out.print(x || y || x==y);//true||false=>true
//        ---------------------------------------
//        int x = 1;
//        int y = 2;
//        int z = x + y % x / 2;//1
//        System.out.println(z);
//        -----------------------------------------
//            boolean done=false;
//            long x=2000;
//            while (!done){
//                x=x/10;
//                if(x<10){
//                    done=true;
//                }
//                done=false;
//            }
//        System.out.println(x);
//        ------------------------------------
//        int a,b;
//        a=100;
//        b=(a==100)?200:300;
//        System.out.println(b);
//        ----------------------------------------
//        int n = 5;
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                if (i == 1 || i == n || j == n) {
//                    System.out.print("*");
//                } else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//-------------------------------------------
//        int i = 10;
//        do {
//            i++;
//            System.out.print(i);
//        } while (i == i);
//        ----------------------------------------
//        float f = 10f;
//        double i=10.0;
//        System.out.println(f);
//        -------------------------------
//        int i = 1, j = 3;
//        for (; (i < 3) && (j++ < 6); i++) {
//            System.out.print(" " + i + " " + j);
//        }
//        System.out.print(" " + i + " " + j);
//------------------------------------------------------

//        int x = 1;
//        if (!b1) {
//            if (!b2) {
//                b1 = true;
//                x++;
//                if (5 > 6) {
//                    x++;
//                }
//                if (!b1)
//                    x = x + 10;
//                else if (b2 = true)
//                    x = x + 100;
//                else if (b1 | b2)
//                    x = x + 1000;
//            }
//        }
//        System.out.println(x);
//-------------------------------------
//        int value = 0;
//        boolean b1 = true;
//        boolean b2 = false, b;
//        b = (b1 | ((value++) == 0));//true
//        b = (b2 | ((value += 2) > 0));//true
//        System.out.println(value);
//-----------------------------------------
//        for (int i = 0; i <7 ; i++) {
//            for (int j = 0; j < 7; j++) {
//                if(i==j||j==0||i==6){
//                    System.out.print("+");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//        ----------------------------------
//        for (int i = 0; i <5 ; i++) {
//            for (int j = 0; j <5 ; j++) {
//                if(j==0||i==4||j==4){
//                    System.out.print("+");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//        ---------------------------------
//        int j;
//        for (int i = 1; i <=6 ; i++) {
//            for (j = 1; j <=6 ; j++) {
//                if(i==1||i==6||(j==(7-i))){
//                    System.out.print("+");
//                }else {
//                    System.out.print(" ");
//                }
//            }
//            System.out.println("");
//        }
//        -----------------------------------
//        int arr[] = {1, 3, 5, 9, 3, 6, 23, 13};
//
//        for (int i = 0; i < arr.length; i++) {
//            if (soNguyenTo(arr[i]) == true) {
//                System.out.print(arr[i] + ", ");
//            }
//        }
//
//    }
//
//    public static boolean soNguyenTo(int n) {
//        if (n < 2) {
//            return false;
//        } else {
//            for (int i = 2; i < n; i++) {
//                if (n % i == 0) {
//                    return false;
//                }
//            }
//        }
//        return true;
    }

}
