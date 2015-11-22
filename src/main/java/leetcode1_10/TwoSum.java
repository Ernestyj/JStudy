package leetcode1_10;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific
 * target number.

 The function twoSum should return indices of the two numbers such that they add up to
 the target, where index1 must be less than index2.
 Please note that your returned answers (both index1 and index2) are not zero-based.
 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1 = 1, index2 = 2
 *
 * Created by DCLab on 11/2/2015.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
//        int[] indexes = new TwoSum().twoSumBruteForce(nums, 9);
        int[] indexes = new TwoSum().twoSum(nums, 0);
        System.out.print("index1: " + indexes[0] + ", index2: " + indexes[1]);
    }

    /**
     * 时间复杂度 n^2
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] indexes = new int[2];

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int sum = nums[i] + nums[j];
                if (sum == target){
                    indexes[0] = i + 1;
                    indexes[1] = j + 1;
                    return indexes;
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度 nlogn （nlogn +  n）//TODO 易错（相同值的索引应区别对待）
     * 先排序，后夹逼线性查找
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] sortedNums = nums.clone();
        int[] indexes = new int[2];

        Arrays.sort(sortedNums);

        int left = 0;
        int right = sortedNums.length - 1;
        while (left < right){
            int sum = sortedNums[left] + sortedNums[right];
            if (sum == target){
                indexes[0] = getOriginIndex(sortedNums[left], nums, false) + 1;
                boolean isRepeat = false;
                if (sortedNums[left] == sortedNums[right]) isRepeat = true;//TODO 相同值的索引应区别对待
                indexes[1] = getOriginIndex(sortedNums[right], nums, isRepeat) + 1;
                if (indexes[0] > indexes[1]){   //换值
                    indexes[0] ^= indexes[1];
                    indexes[1] ^= indexes[0];
                    indexes[0] ^= indexes[1];
                }
                break;
            } else if (sum > target) right--;
            else left++;
        }
        return indexes;
    }
    private int getOriginIndex(int num, int[] nums, boolean isRepeat){
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == num){
                if (isRepeat) isRepeat = false; //TODO 此处 isRepeat = false 易漏
                else return i;
            }
        }
        return -1;
    }

}
