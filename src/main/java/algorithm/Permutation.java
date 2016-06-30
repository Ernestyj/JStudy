package algorithm;

import java.util.*;

/**
 * 设计一个算法，输出一个字符串字符的全排列。
 * 比如，String = "abc"，输出是"abc","bac","cab","bca","cba","acb"
 *
 * Created by DCLab on 11/13/2015.
 */
public class Permutation {

    public static void main(String[] args) {
//        String str[] = { "A", "B", "C", "D", "E" };
        String str[] = { "A", "A" };
        printAllPermutations(str);
        System.out.println("\n Another******************");
        printAllPermutations1("aa");
    }

    /**TODO 不含重复
     * 回溯法：从集合依次选出每一个元素，作为排列的第一个元素，然后对剩余的元素进行全排列，如此递归处理。
     * 时间复杂度：n! 空间复杂度：（in place置换）
     * 以abc为例子：
     1. a和a交换(固定a), 求后面bc的全排列： abc, acb。 求完后，a 和 b交换； 得到bac,开始第二轮
     2. b和b交换(固定b), 求后面ac的全排列： bac, bca。 求完后，b 和 c交换； 得到cab,开始第三轮
     3. c和c交换(固定c), 求后面ba的全排列： cab, cba.
     * http://blog.csdn.net/randyjiawenjie/article/details/6313729
     * @param str
     */
    public static void printAllPermutations(String[] str) {
        permutation(str, 0, str.length);
    }
    private static void permutation(String[] str, int start, int len) {
        if (start == len) {
            for (int i = 0; i < len; i ++) System.out.print(str[i]);
            System.out.print(" ");
            return;
        }
        for (int i = start; i < len; i ++) {
            swap(str, start, i);
            permutation(str, start + 1, len); //TODO 注意特殊的地方,不是i+1而是start+1
            swap(str, start, i);
        }
    }
    private static void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /**TODO 含重复
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  //TODO 先排序可提速
        Set<List<Integer>> res = new HashSet<>();   //TODO 一定要用集合
        dfs(nums, res, 0);
        return new LinkedList<>(res);
    }
    private void dfs(int[] nums, Set<List<Integer>> res, int start){
        if(start==nums.length){
            LinkedList<Integer> sol = new LinkedList<>();
            for(int n: nums) sol.add(n);
            res.add(sol);
        }
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]) continue; //TODO 先排序
            swap(nums, start, i);
            dfs(nums, res, start+1);
            swap(nums, start, i);
        }
    }
    private void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    // http://www.ericleschinski.com/c/java_permutations_recursion/ TODO 不含重复
    public static void printAllPermutations1(String str) {
        permutation("", str);
    }
    private static void permutation(String prefix, String str) {
        int len = str.length();
        if (len == 0) System.out.print(prefix + " ");
        else {
            for (int i = 0; i < len; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len));
        }
    }
}
