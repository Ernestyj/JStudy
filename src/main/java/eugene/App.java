package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        int[] nums = {14, 14, 14, 9};
        int result = 0;
        for (int i=31; i>=0; i--){
            int sum = 0;
            int mask = 1<<i;
            System.out.print(i + ": ");
            for (int j=0; j<nums.length; j++){
                System.out.print((nums[j] & mask) + " ");
            }
            System.out.println();
        }
    }





}