package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        try {
            test();
            test(10, 1, 8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() throws IOException {

    }


    private static void test(int age, int count, int target){
        if (count >= target){
            System.out.println(age);
            return;
        }
        test(age += 2, ++count, target);
    }


}