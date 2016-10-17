package leetcode211_220;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**Given an array of integers, find out whether there are two distinct indices i and j
 in the array such that the difference between nums[i] and nums[j] is at most t
 and the difference between i and j is at most k.
 * Created by eugene on 16/4/14.
 */
public class ContainsDuplicateIII {

    /**
     * O(nlog(k)),借助TreeSet维护窗口k
     * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            int x = nums[i];
            //写成x-set.floor(x)<=t可能会溢出,注意边界用例 [-1,2147483647] 1 2147483647
            if ((set.floor(x)!=null && x<=set.floor(x)+t)
                    || (set.ceiling(x)!=null && x>=set.ceiling(x)-t))
                return true;
            set.add(x);
            if (set.size()>k) set.remove(nums[i-k]);
        }
        return false;
    }

    //(此法超时)维护窗口k, 注意边界情况 [-1,2147483647] 1 2147483647
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums==null || nums.length<=1) return false;
        int i, j;
        int len;
        if (nums.length-1<=k) len = nums.length-1;
        else len = k;
        for (i=0; i<=len; i++){
            for (j=i+1; j<=len; j++){
                if (i!=j && Math.abs((long)nums[j]-nums[i])<=t) return true;
            }
        }
        if (nums.length-1<=k) return false;
        for (i=k+1; i<nums.length; i++){    //窗口滚动
            for (j=i-k; j<i; j++){
                if (Math.abs((long)nums[j]-nums[i])<=t) return true;
            }
        }
        return false;
    }

}
