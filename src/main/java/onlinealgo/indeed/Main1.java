package onlinealgo.indeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by eugene on 16/5/28.
 */
public class Main1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        unsafeWord(s);
    }

    private static void unsafeWord(String s){
        char[] chars = {'a','b','c','d'};
        HashSet<String> result = new HashSet<>();
        permutation("", s, result);
        StringBuilder sb;
        for (int i=0; i<s.length(); i++){
            for (int j=0; j<chars.length; j++){
                if (s.charAt(i)!=chars[j]) {
                    sb = new StringBuilder(s);
                    sb.setCharAt(i, chars[j]);
                    permutation("", sb.toString(), result);
                }
            }
        }
        ArrayList<String> list = new ArrayList<>(result);
        Collections.sort(list);
        for (String str: list){
            System.out.println(str);
        }
    }
    private static void permutation(String prefix, String str, HashSet<String> result) {
        int len = str.length();
        if (len == 0) result.add(prefix + "");
        else {
            for (int i = 0; i < len; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len), result);
        }
    }

}
