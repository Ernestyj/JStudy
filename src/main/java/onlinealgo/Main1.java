package onlinealgo;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by eugene on 16/8/2.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (in.hasNext()) {//注意while处理多个case
            String raw = in.nextLine();
            for (String s: raw.split(" ")){
                set.add(s);
            }
        }
        System.out.println(set.size());
    }
}
