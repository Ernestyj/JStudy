package indeed;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by eugene on 16/5/28.
 */
public class Main2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        String m = sc.next();
//        numbers(String.valueOf(36452411l), BigInteger.valueOf(10l));
        numbers(String.valueOf(4243), BigInteger.valueOf(100));
//        numbers(s, BigInteger.valueOf(Long.valueOf(m)));
    }

    private static void numbers(String S, BigInteger M){
        HashMap<Integer, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String temp = "";
        int count = 0;
        StringBuilder sb = new StringBuilder(S);
        BigInteger i = BigInteger.ZERO;
        for (; i.compareTo(M)<0; i=i.add(BigInteger.ONE)){
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.insert(c-'0'-1, c);
            if (c=='1') break;
            if (!set.contains(sb.toString())){
                set.add(sb.toString());
                map.put(count, sb.toString());
                count++;
            } else {
                break;
            }
        }
        BigInteger remainder = M.mod(BigInteger.valueOf(count));

        System.out.println(map.get(Integer.valueOf(remainder.toString())+1));
        System.out.println(sb.toString());
    }


}
