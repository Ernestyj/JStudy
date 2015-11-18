package algorithm;

/**
 * Created by Eugene on 11/16/2015.
 */
public class Search {

    public static void main(String[] args) {

        int[] nums = {6, 42, 48, 57, 60, 72, 73, 83, 85, 88};
        int result = new Search().binarySearch(nums, 88);

        System.out.println("*****RESULT*****");
        System.out.println(result);
    }


    /**
     * 二分查找：针对的排好序的数组
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        int m = 0;
        while (l <= r){
            m = (l + r) / 2;
            if (target < nums[m]) r = m - 1;
            else if (nums[m] < target) l = m + 1;
            else return m;  //target == nums[m]
        }
        return -1;
    }
}
