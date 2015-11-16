package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");


        System.out.println();
        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        System.out.println(Integer.toHexString(i));
        System.out.println(Integer.toHexString(j));
        System.out.println("i = " + Integer.toBinaryString(i));
        System.out.println("j = " + Integer.toBinaryString(j));
        System.out.println("i & j = " + Integer.toBinaryString(i & j));
        System.out.println("i | j = " + Integer.toBinaryString(i | j));
        System.out.println("i ^ j = " + Integer.toBinaryString(i ^ j));
        System.out.println("~i = " + Integer.toBinaryString(~i));
        System.out.println("~j = " + Integer.toBinaryString(~j));
        try {
            test();
//            int[] nums = {1, 0, -1, 0, -2, 2, 9};
//            for (int n : nums) System.out.print(n + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() throws IOException {

    }


    private static void test(int[] a){
    }


}