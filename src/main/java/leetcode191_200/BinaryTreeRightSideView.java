package leetcode191_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Created by eugene on 16/3/29.
 */
public class BinaryTreeRightSideView {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Core idea: 1.Each depth of the tree only select one node. 2.View depth is current size of result list.
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null) return;
        if(currDepth == result.size()) result.add(curr.val);

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

    //单队列
    public List<Integer> rightSideView1(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();    //get size here
            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();
                if(i==0) result.add(top.val);   //the first element in the queue (right-most of the tree)
                if(top.right!=null) queue.add(top.right);
                if(top.left!=null) queue.add(top.left);
            }
        }
        return result;
    }

    //双队列
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qNext = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode n = q.poll();
            if (n.left!=null) qNext.offer(n.left);
            if (n.right!=null) qNext.offer(n.right);
            if (q.isEmpty()){
                result.add(n.val);
                if (!qNext.isEmpty()){
                    q = new LinkedList<>(qNext);
                    qNext = new LinkedList<>();
                }
            }
        }
        return result;
    }

}
