package algorithm;

import sun.security.provider.MD5;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {
    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        System.out.println();
        char[] chars1 = {'1', '2'};
        char[] chars2 = {'1', '2'};
        System.out.println(chars1 == chars2);


        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() throws IOException {
    }

    private static void test(final String inputString) throws IOException {
    }

}