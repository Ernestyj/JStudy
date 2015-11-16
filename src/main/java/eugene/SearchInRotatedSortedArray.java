package eugene;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 *
 * Created by Eugene on 11/16/2015.
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("*****RESULT*****");
        int count = new SearchInRotatedSortedArray().search(nums, 0);
        System.out.println(count);
    }

    /**
     * TODO
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (target == nums[0]) return 0;
        int index = -1;
        int head = -1;
        if (target < nums[0]) ;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == target) return i;
            if (nums[i - 1] > nums[i]) head = i;
        }
        return index;
    }
}
