package leetcode111_120;

import java.util.List;

/**Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * Created by eugene on 16/2/8.
 */
public class Triangle {

    /**http://blog.csdn.net/linhuanmars/article/details/23230657
     * 二维动态规划(自顶向下):在某一个元素i，j的最小路径和就是它上层对应的相邻两个元素的最小路径和加上自己的值，
     动态规划(自底向上):sum[i][j]=min(sum[i+1][j],sum[i+1][j+1])+triangle[i][j],
     自底向上的方式省去了对每层首尾元素的特殊处理,更简洁.
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m==0) return 0;
        int[] dp = new int[m];
        for (int i=0; i<triangle.get(m-1).size(); i++)
            dp[i] = triangle.get(m-1).get(i);
        for (int i=m-2; i>=0; i--){
            for (int j=0; j<triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        }
        return dp[0];
    }

}
