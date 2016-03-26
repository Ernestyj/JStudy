package leetcode161_170;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 * Created by eugene on 16/3/19.
 */
public class MajorityElement {

    //nlog(n)
    public int majorityElement(int[] nums) {
        if (nums.length<=2) return nums[0];
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //n
    public int majorityElement1(int[] nums) {
        if (nums.length<=2) return nums[0];
        int indice = nums.length/2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if (!map.containsKey(n)) map.put(n, 1);
            else{
                int temp = map.get(n);
                if (temp+1>indice) return n;
                map.put(n, temp+1);
            }
        }
        return 0;
    }

}