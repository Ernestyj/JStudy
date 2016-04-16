package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {
    private static final String MESSAGE="taobao";
    public String name="abc";
    public static void main(String[] args) {
        System.out.println("*****RESULT*****");

        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);
        System.out.println((b+c)==MESSAGE);

        ((App)null).testMethod();


    }
    private void test(){
        System.out.println(super.getClass().getSuperclass());
    }
    private static void testMethod(){
        System.out.println("testMethod");
    }
    public void App(){}
    App(){}

    private static void read(){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(m + " " + n);
        in.nextLine();
        char[][] grids = new char[m][n];
        for (int i=0; i<m; i++){
            String line = in.nextLine();
            System.out.println(line);
            for (int j=0; j<n; j++){
                grids[i][j] = Character.valueOf(line.charAt(j));
            }
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grids[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class App1{
    App1(){}
}