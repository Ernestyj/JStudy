package onlinealgo.indeed;

import java.util.Scanner;

/**
 * Created by eugene on 16/7/2.
 */
public class M1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = breakLine(s);
        System.out.println(breakLine(res));
    }

    public static String breakLine(String s){
        return s.replaceAll(",", "\n");
    }

}
