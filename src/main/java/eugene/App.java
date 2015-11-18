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
//        int h = 0x10000000;
//        System.out.println(Integer.toBinaryString(h));
//        for(int i = 0; i < 28; i++) {
//            h >>>= 1;
//            System.out.println(Integer.toBinaryString(h));
//        }
//        int h = -1;
//        System.out.println(Integer.toBinaryString(h));
//        h <<= 10;
//        System.out.println(Integer.toBinaryString(h));
//        for(int i = 0; i < 32; i++) {
//            h >>>= 1;
//            System.out.println(Integer.toBinaryString(h));
//        }
        char c = 'a';
        System.out.println(Integer.toBinaryString(c));
        c = 'b';
        System.out.println(Integer.toBinaryString(c));
        c = 'c';
        System.out.println(Integer.toBinaryString(c));
        c = 'd';
        System.out.println(Integer.toBinaryString(c));
        c +=1;
        System.out.println(Integer.toBinaryString(c));
        c = 'A';
        System.out.println(Integer.toBinaryString(c));
        for(int i = 0; i < 26; i++) {
            c +=1;
            System.out.println(Integer.toBinaryString(c));
        }
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