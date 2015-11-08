package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        int[] nums = {1, 0, -1, 0, -2, 2, 9};
        try {
            test();
            test(nums);
            for (int n : nums) System.out.print(n + " ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() throws IOException {

    }


    private static void test(int[] a){
        for (int i = 0, j = a.length - 1; i < j; i++, j--){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }


}