package leetcode31_40;

/**Given a sorted array of integers, find the starting and ending position of a given target value.
 Your algorithm's runtime complexity must be in the order of O(log n).
 If the target is not found in the array, return [-1, -1].
 For example, Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class SearchForARange {

    //https://leetcode.com/discuss/19368/very-simple-java-solution-with-only-binary-search-algorithm
    //简洁, 巧妙
    public int[] searchRange(int[] nums, int target) {
        int start = firstGeq(nums, target);
        if (start==nums.length || nums[start] != target)
            return new int[]{-1, -1};
        return new int[]{start, firstGeq(nums, target+1)-1};
    }
    private static int firstGeq(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l<=r) {
            int m = l+((r-l)>>1);
            if (nums[m]>=target) r = m-1;
            else l = m+1;
        }
        return l;
    }

    public int[] searchRange1(int[] nums, int target) {
        int i1 = search(nums, target, 0, nums.length-1);
        if(i1==-1) return new int[]{-1, -1};
        int i2 = i1;
        while(i1-1>=0 && nums[i1-1]==target) i1--;
        while(i2+1<nums.length && nums[i2+1]==target) i2++;
        return new int[]{i1, i2};
    }
    private int search(int[] nums, int target, int l, int r){
        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target) return m;
            else if(nums[m]>target) r = m-1;
            else l = m+1;
        }
        return -1;
    }


}
