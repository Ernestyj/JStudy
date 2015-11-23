package leetcode41_50;

import eugene.examples.generic.Stack;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log(m + n)).
 *
 * Created by DCLab on 11/23/2015.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {1};
        System.out.println("*****RESULT*****");
        double result = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }


    /**
     * 普通思路：TODO　边界条件极易出错
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null || nums1.length == 0 && nums2.length == 0) return 0;
        if ((nums1 == null || nums1.length == 0) && nums2 != null && nums2.length != 0) {
            if (nums2.length % 2 != 0) return nums2[nums2.length / 2];
            else return (double)(nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0d;
        }
        if ((nums2 == null || nums2.length == 0) && nums1 != null && nums1.length != 0) {
            if (nums1.length % 2 != 0) return nums1[nums1.length / 2];
            else return (double)(nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0d;
        }
        int len = nums1.length + nums2.length;
        int count = len / 2;
        boolean isOdd = len % 2 != 0;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (count >= 0){
            if (i >= nums1.length && j >= nums2.length) break;
            else if (i >= nums1.length) {
                stack.push(nums2[j]);
                j++;
            }else if (j >= nums2.length){
                stack.push(nums1[i]);
                i++;
            }else if (nums1[i] <= nums2[j]){
                stack.push(nums1[i]);
                i++;
            }else {
                stack.push(nums2[j]);
                j++;
            }
            count--;
        }
        if (isOdd) return stack.pop();
        else return (double)(stack.pop() + stack.pop()) / 2.0d;
    }

}
