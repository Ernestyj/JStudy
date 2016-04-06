package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {
    private static final String MESSAGE="taobao";

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);

        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;
        System.out.println(i.equals(l));


    }
    private void test(){
        System.out.println(super.getClass().getSuperclass());
    }

    public void App(){}
    App(){}

}
