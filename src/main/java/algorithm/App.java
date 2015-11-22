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

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        long time = new Date().getTime();
        System.out.println(time);
        String md5 = MD5("1234");
        System.out.println(md5);

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

    public final static String MD5(String s) {
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            return new String(md);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}