package algorithm;

/**
 * Created by Eugene on 11/16/2015.
 */
public class Search {

    public static void main(String[] args) {

        int[] nums = {6, 42, 48, 57, 60, 72, 73, 83, 85, 88};
        int result = new Search().binarySearch(nums, 57);

        System.out.println("*****RESULT*****");
        System.out.println(result);
    }


    /**
     * TODO
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        return bSearch(nums, target, 0, nums.length - 1);
    }
    private int bSearch(int[] nums, int target, int left, int right){
        if (left < right){
            int mid = (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) return bSearch(nums, target, left, mid - 1);
            else return  bSearch(nums, target, mid + 1, right);
        }
        return -1;
    }
}
