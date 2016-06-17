package leetcode81_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:
 [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * Created by DCLab on 1/11/2016.
 */
public class SubsetsII {

    // 位图法：与Subsets位图法思路一致，再添加判重部分即可
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp;
        int len = nums.length;
        int n = 1 << len;
        for (int i=0; i<n; i++){
            temp = new ArrayList<>();
            //查看第一层循环任意一种取值中哪一位是1；如果是1，对应的字符就存在
            for (int k=1; k<=len; k++){
                if ( (i&(1 << k-1)) != 0 ) temp.add(nums[k-1]);
            }
            if (!result.contains(temp)) //判重
                result.add(new ArrayList<>(temp));
        }
        return result;
    }

    /**
     * 回溯法
     * 参考：http://bangbingsyb.blogspot.com/2014/11/leetcode-subsets-i-ii.html
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();
        result.add(sol);   //额外添加空集
        backTrack(nums, 0, result, sol);
        return result;
    }
    private void backTrack(int[] nums, int start, List<List<Integer>> result, List<Integer> sol){
        for(int i=start; i<nums.length; i++) {
            if (i>start && nums[i]==nums[i-1]) continue;    //跳过再次重复的数字
            sol.add(nums[i]);
            result.add(new ArrayList<>(sol));
            backTrack(nums, i+1, result, sol);
            sol.remove(sol.size() - 1);
        }
    }

}
