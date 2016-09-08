package onlinealgo;

import java.math.BigDecimal;

/**
 * Created by v_yangjian02 on 2016/9/8.
 */
public class CoverPoints {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        double[] nums = {0.1, 0.2, 0.3, 1.5, 1.6, 1.61, 9.8};
        int res = maxCover(nums, 0.2);
        System.out.println(res);
    }

    //求满足a[j]-a[i]<=L && a[j+1]-a[i]>L这两个条件的j与i中间的所有点个数中的最大值，即j-i+1最大
    public static int maxCover(double nums[], double L) {
        int n = nums.length;
        int count = 2, maxCount = 1, start = 0;
        int i = 0, j = 1;
        while(i<n && j<n) {
            while(j<n && (new BigDecimal(String.valueOf(nums[j])).subtract(new BigDecimal(String.valueOf(nums[i]))))
                    .compareTo(new BigDecimal(String.valueOf(L)))<=0) {
                j++;
                count++;
            }
            j--; count--;   //退回到满足条件的j
            if(maxCount<count) {
                start = i;  //记录起始覆盖点
                maxCount = count;
            }
            i++;    //收缩
            j++;    //TODO 注意j也++
        }
        return maxCount;
    }

}
