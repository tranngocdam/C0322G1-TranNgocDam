package ss11_stack_queue.bai_tap.reverse_array_stack.interger;
import jdk.nashorn.internal.IntDeque;
import ss11_stack_queue.bai_tap.reverse_array_stack.interger.GenericStack;

import java.util.Arrays;
import java.util.Scanner;

public class GenericStackMain {

    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("2. Stack of string");
        stackOfString();
    }
    private static void stackOfIntegers() {
        int n, i;
        int[] array;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        n=Integer.parseInt(input.nextLine());
        array = new int[n];
        GenericStack<Integer> stack = new GenericStack();
        while (stack.isEmpty()) {
            for ( i = 0; i <array.length ; i++) {
                System.out.print("Enter a element: ");
                array[i]=Integer.parseInt(input.nextLine());
                stack.push(array[i]);
            }
        }
        for (int j = 0; j < array.length ; j++) {
            System.out.print(array[j]+"\t");
        }
        System.out.println("");
        while (!stack.isEmpty()) {
                System.out.print(stack.pop()+"\t");
        }
        System.out.println("");
    }
    private static void stackOfString() {
        String mWord;
        Scanner input=new Scanner(System.in);
        mWord="toi yeu viet nam";
        String[] s=mWord.split(" ");
        GenericStack<String> wstack = new GenericStack();
        while (wstack.isEmpty()) {
            for (int i = 0; i <s.length ; i++) {
                wstack.push(s[i]);
            }
        }
        while (!wstack.isEmpty()) {
            System.out.print("  "+wstack.pop());
        }
    }
}
