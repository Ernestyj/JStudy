package onlinealgo;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().trim().split(",");
        int[] nums = new int[strings.length];
        for (int i=0; i<nums.length; i++){
            nums[i] = Integer.valueOf(strings[i]);
        }
        int res = maxProfit(nums);
        System.out.println(res);
    }

    public static int maxProfit(int[] prices) {
        if(prices.length<=1) return 0;
        int min = prices[0], profit = 0;
        for(int i=1; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i]-min);
        }
        return profit;
    }

}
