package leetcode201_210;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**Given two strings s and t, determine if they are isomorphic.
 Two strings are isomorphic if the characters in s can be replaced to get t.
 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 For example,
 Given "egg", "add", return true.
 Given "foo", "bar", return false.
 Given "paper", "title", return true.
 * Created by eugene on 16/4/2.
 */
public class IsomorphicStrings {

    /**
     * https://leetcode.com/discuss/33889/short-java-solution-without-maps
     * tricky方法,不使用哈希
     */
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;    //+1是因为初始值为0,不能使用0值.
        }
        return true;
    }

    //普通方法,哈希
    //https://discuss.leetcode.com/topic/14158/java-solution-using-hashmap
    public boolean isIsomorphic1(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i), b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b)) continue;
                else return false;
            }else{
                if(!map.containsValue(b)) map.put(a,b);
                else return false;
            }
        }
        return true;
    }

}
