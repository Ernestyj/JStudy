package interview.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum:
 * Given an array S of n integers, are there elements a, b, c, and d in S
 * such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Created by DCLab on 10/31/2015.
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answers = new ArrayList<>();
        Arrays.sort(nums);
        int[] twoNumSums = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++){
            twoNumSums[i] = nums[i] + nums[i + 1];
        }
        return answers;
    }

}
