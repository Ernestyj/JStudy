package onlinealgo;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
//        int res = Arrays.binarySearch(nums, target);
        int res = binarySearch(nums, target);
        System.out.println(res);
    }
    public static int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        int m = 0;
        while (l <= r){
            m = (l + r) / 2;
            if (target < nums[m]) r = m - 1;
            else if (nums[m] < target) l = m + 1;
            else return m;  //target == nums[m]
        }
        return -(l+1);
    }
}
