package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        System.out.println(Integer.valueOf("00"));

    }

    static private long factorial(int n){
        if (n==0||n==1) return 1;
        return factorial(n-1)*n;
    }



}