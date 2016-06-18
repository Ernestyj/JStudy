package leetcode121_130;

/**Given a binary tree containing digits from 0-9 only,
 each root-to-leaf path could represent a number.
 Find the total sum of all root-to-leaf numbers.
 For example,
   1
  / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 Return the sum = 12 + 13 = 25.
 * Created by eugene on 16/2/17.
 */
public class SumRootToLeafNumbers {
    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //http://blog.csdn.net/linhuanmars/article/details/22913699
    //递归,简洁但速度较慢
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int sum) {
        if(root == null) return 0;
        int curSum = sum*10+root.val;
        if(root.left==null && root.right==null) return curSum;  //叶子节点
        return helper(root.left, curSum) + helper(root.right, curSum);
    }


}
