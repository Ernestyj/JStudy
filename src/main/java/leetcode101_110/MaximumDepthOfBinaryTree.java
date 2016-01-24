package leetcode101_110;

/**Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node
 down to the farthest leaf node.
 * Created by eugene on 16/1/24.
 */
public class MaximumDepthOfBinaryTree {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        return Math.max(maxL, maxR) + 1;
    }

}
