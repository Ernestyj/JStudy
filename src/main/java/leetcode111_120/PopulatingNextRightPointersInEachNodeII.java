package leetcode111_120;

import java.util.LinkedList;
import java.util.Queue;

/**Follow up for problem "Populating Next Right Pointers in Each Node".
 What if the given tree could be any binary tree? Would your previous solution still work?
 Note: You may only use constant extra space.
 * Created by eugene on 16/2/5.
 */
public class PopulatingNextRightPointersInEachNodeII {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }


    /**
     * http://blog.csdn.net/linhuanmars/article/details/23510601
     * 类似二叉树层次遍历,由于使用队列
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        TreeLinkNode lastHead = root;//prevous level's head
        TreeLinkNode lastCurrent = null;//previous level's pointer
        TreeLinkNode currentHead = null;//currnet level's head
        TreeLinkNode current = null;//current level's pointer

        while(lastHead!=null){
            lastCurrent = lastHead;

            while(lastCurrent!=null){
                //left child is not null
                if(lastCurrent.left!=null)    {
                    if(currentHead == null){
                        currentHead = lastCurrent.left;
                        current = lastCurrent.left;
                    }else{
                        current.next = lastCurrent.left;
                        current = current.next;
                    }
                }

                //right child is not null
                if(lastCurrent.right!=null){
                    if(currentHead == null){
                        currentHead = lastCurrent.right;
                        current = lastCurrent.right;
                    }else{
                        current.next = lastCurrent.right;
                        current = current.next;
                    }
                }

                lastCurrent = lastCurrent.next;
            }

            //update last head
            lastHead = currentHead;
            currentHead = null;
        }
    }

    /**类似二叉树层次遍历,使用队列,空间复杂度O(n)
     * @param root
     */
    public void connect1(TreeLinkNode root) {
        if (root==null) return;
        Queue<TreeLinkNode> curQueue = new LinkedList<>();
        Queue<TreeLinkNode> nextQueue = new LinkedList<>();
        curQueue.offer(root);
        TreeLinkNode old = null;
        while (!curQueue.isEmpty()){
            TreeLinkNode node = curQueue.poll();
            if (old!=null) old.next = node;
            old = node;
            if (node.left!=null) nextQueue.offer(node.left);
            if (node.right!=null) nextQueue.offer(node.right);
            if (curQueue.isEmpty()){
                old = null;
                curQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }
    }

}
