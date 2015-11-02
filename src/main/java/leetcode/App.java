package leetcode;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {
    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() throws IOException {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] sortedNums = nums.clone();

        Arrays.sort(sortedNums);
        for (int i : nums) System.out.print(i + " ");
        System.out.println();
        for (int i : sortedNums) System.out.print(i + " ");
    }

    private static void test(final String inputString) throws IOException {
    }


}