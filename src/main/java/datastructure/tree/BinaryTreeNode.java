package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树是一种特殊的树，在二叉树中每个节点最多有两个子节点；
 * 一般称为左子节点和右子节点（或左孩子和右孩子），并且二叉树的子树有左右之分，其次序不能任意颠倒；
 * 二叉树是递归定义的；
 * Created by DCLab on 10/31/2015.
 */
public class BinaryTreeNode {
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private String val;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, String val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public int getNodeNum(){
        return getNodeNum(this);
    }
    /**
     * 递归解法：
     （1）如果二叉树为空，节点个数为0
     （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     * @param root
     * @return
     */
    private int getNodeNum(BinaryTreeNode root){
        if (root == null) return 0;
        return  1 + getNodeNum(root.left) + getNodeNum(root.right);
    }

    public int getDepth(){
        return getDepth(this);
    }
    /**
     * 递归解法：
     （1）如果二叉树为空，二叉树的深度为0
     （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     * @param root
     * @return
     */
    private int getDepth(BinaryTreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    private void visit(BinaryTreeNode node){
        System.out.print(node.val + " ");
    }

    public void traversePreOder(){
        traversePreOder(this);
    }
    /**
     * 前序遍历递归解法：
     （1）如果二叉树为空，空操作
     （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     * @param root
     */
    private void traversePreOder(BinaryTreeNode root){
        if (null == root) return;
        visit(root);
        traversePreOder(root.left);
        traversePreOder(root.right);
    }


    public void traverseInOder(){
        traverseInOder(this);
    }
    /**
     * 中序遍历递归解法
     （1）如果二叉树为空，空操作。
     （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     */
    private void traverseInOder(BinaryTreeNode root){
        if (null == root) return;
        traverseInOder(root.left);
        visit(root);
        traverseInOder(root.right);
    }

    public void traversePostOder(){
        traversePostOder(this);
    }
    /**
     * 后序遍历递归解法
     （1）如果二叉树为空，空操作
     （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     */
    private void traversePostOder(BinaryTreeNode root){
        if (null == root) return;
        traversePostOder(root.left);
        traversePostOder(root.right);
        visit(root);
    }

    public void traverseLayer(){
        traverseLayer(this);
    }

    /**
     * 相当于广度优先搜索，使用队列实现。
     * a. 队列初始化，将根节点压入队列。
     * b. 当队列不为空，进行如下操作：
     *  弹出一个节点，访问；若左子节点或右子节点不为空，将其压入队列。
     * @param root
     */
    private void traverseLayer(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            visit(node);
            if (null != node.left) queue.offer(node.left);
            if (null != node.right) queue.offer(node.right);
        }
    }

}
