package indeed;

import java.util.*;

/**
 * Created by eugene on 16/7/9.
 */
public class T1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        //String res = replace("abc", "xyz");
        String res = replace(s, t);
        System.out.println(res);
    }

    private static final String r1 = "Possible", r2 = "Impossible";
    public static String replace(String S, String T){
        if (S.equals(T)) return r1;
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<S.length(); i++){
            char c1 = S.charAt(i), c2 = T.charAt(i);
            if (c1==c2) continue;
            if (!map.containsKey(c1)) {
                if (map.size()<1) {
                    map.put(c1, c2);
                    map.put(c2, c1);
                } else return r2;
            } else {
                if (map.get(c1)!=c2) return r2;
            }
        }
        return r1;
    }


}
