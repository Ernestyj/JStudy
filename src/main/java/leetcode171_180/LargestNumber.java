package leetcode171_180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**Given a list of non negative integers, arrange them such that they form the largest number.
 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 Note: The result may be very large, so you need to return a string instead of an integer.
 * Created by eugene on 16/3/23.
 */
public class LargestNumber {

    //简洁写法. 关键:拼接待比较的两个数o1与o2，s1=o1+o2，s2=o2+o1，从s1、s2的最高位开始比较
    public  String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        String[] numS = new String[nums.length];
        for(int i=0; i<nums.length; i++) numS[i] = nums[i]+"";
        Comparator<String> comp = new Comparator<String>(){ //升序
            @Override
            public int compare(String str1, String str2){
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(numS, comp);
        if(numS[numS.length-1].charAt(0)=='0') return "0";  //用例[0, 0]
        StringBuilder sb = new StringBuilder();
        for(String s: numS) sb.insert(0, s);    //降序
        return sb.toString();
    }

}
