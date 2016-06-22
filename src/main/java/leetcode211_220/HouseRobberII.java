package leetcode211_220;

/**Note: This is an extension of House Robber.
 After robbing those houses on that street, the thief has found himself a new place for his thievery
 so that he will not get too much attention. This time, all houses at this place are arranged in a circle.
 That means the first house is the neighbor of the last one. Meanwhile, the security system
 for these houses remain the same as for those in the previous street.
 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by eugene on 16/4/9.
 */
public class HouseRobberII {

    //DP, s(i)=max{s(i-1), s(i-2)+nums(i)}
    //分两种情况,遍历数组两次,1.包含第一个,不含最后一个;2.包含最后一个,不含第一个.
    //http://www.programcreek.com/2014/05/leetcode-house-robber-ii-java/
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        if (len==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        //剔除最后一个元素
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]); //TODO 易错
        for (int i=2; i<len-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        int temp = dp[len-2];
        //剔除第一个元素
        dp[1] = nums[1];
        dp[2] = Math.max(dp[1], nums[2]); //TODO 易错
        for (int i=3; i<len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return Math.max(temp, dp[len-1]);
    }

}
