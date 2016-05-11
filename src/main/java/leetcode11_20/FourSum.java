package leetcode11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum:
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
     (-1,  0, 0, 1)
     (-2, -1, 1, 2)
     (-2,  0, 0, 2)
 *
 * Created by DCLab on 10/31/2015.
 */
public class FourSum {

    /**
     * 时间复杂度 n^3 （nlogn + n^2 * n）
     * 先快排，再枚举第一个、第二个数，然后对余下数的求2sum(注意去重，去重易出错)
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;  //去重
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  //去重
                int twoSumTarget = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right){
                    int twoSum = nums[left] + nums[right];
                    if (twoSumTarget == twoSum){
                        lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        //去重
                        int k = left + 1;
                        while (k < right && nums[k] == nums[left]) k++;
                        left = k;
                        //去重
                        k = right - 1;
                        while (k > left && nums[k] == nums[right]) k--;
                        right = k;
                    } else if (twoSum < twoSumTarget){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return lists;
    }

}
