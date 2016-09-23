package leetcode161_170;

/**A peak element is an element that is greater than its neighbors.
 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 You may imagine that num[-1] = num[n] = -∞.
 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 Note: Your solution should be in logarithmic complexity.
 * Created by eugene on 16/3/15.
 */
public class FindPeakElement {

    //https://leetcode.com/discuss/68999/java-solution-and-explanation-using-invariants
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) return 0;
        int l = 0, r = len-1;
        while (r-l > 1) {
            int mid = l + (r-l)/2;
            if (nums[mid] < nums[mid+1]) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return (l==len-1 || nums[l]>nums[l+1]) ? l : r;
    }


    //二分法搜索
    public int findPeakElement1(int[] nums) {
        if (nums.length==1) return 0;
        int l = 0, r = nums.length;
        int m = 0;
        while (l<=r) {
            m = (l+r)/2;
            if (m-1<=-1) {
                if (nums[m]>nums[m+1]) return m;
                else return m+1;
            } else if (m+1>=nums.length) {
                if (nums[m]>nums[m-1]) return m;
                else return m-1;
            }
            if (nums[m]>nums[m-1] && nums[m]>nums[m+1]) return m;
            else if (nums[m]<=nums[m-1]) r = m-1;
            else l = m+1;
        }
        return -1;
    }

}
