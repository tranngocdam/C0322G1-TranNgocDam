package ss4_lop_doi_tuong_trong_java.bai_tap.StopWatch;

import java.util.*;
public class MainStopWatch {
    public static void main(String[] args) {
        int i;
        int array[];
        Random rnum = new Random();
        StopWatch stopWatch=new StopWatch();
        stopWatch.getStart();
        array=new int[100000];
        for ( i = 0; i < array.length; i++) {
             array[i]=rnum.nextInt(100);
            System.out.print(array[i]+"\t");
        }
        System.out.println("");
        for (int j = 0; j < array.length-1 ; j++) {
            for (int k = j+1; k < array.length ; k++) {
                if(array[j]>array[k]){
                    int dem=array[j];
                    array[j]=array[k];
                    array[k]=dem;
                }
            }
        }
        for (int j = 0; j < array.length ; j++) {
            System.out.print(array[j]+"\t");
        }
        System.out.println("");
        stopWatch.getStop();
        System.out.println(stopWatch.getStartTime());
        System.out.println(stopWatch.getStopTime());
        System.out.print(stopWatch.getElapsedTime());
    }
}
