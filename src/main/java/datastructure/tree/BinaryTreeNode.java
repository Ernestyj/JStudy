package datastructure.tree;

import java.util.*;

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

    public List<String> traversePreOderIterative(BinaryTreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null) return result;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryTreeNode node = stack.pop();
            result.add(node.val);
            if (node.right!=null) stack.push(node.right);
            if (node.left!=null) stack.push(node.left);
        }
        return result;
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

    /**
     * 后序遍历的情况相对复杂,需要维护当前遍历的cur指针和前一个遍历的pre指针来追溯当前的情况
     （注意这里是遍历的指针，并不是真正按后序访问顺序的结点）。具体分为几种情况：
     （1）如果pre的左孩子或者右孩子是cur，那么说明遍历在往下走，按访问顺序继续，
     即如果有左孩子，则是左孩子进栈，否则如果有右孩子，则是右孩子进栈，
     如果左右孩子都没有，则说明该结点是叶子，可以直接访问并把结点出栈了。
     （2）如果反过来，cur的左孩子是pre，则说明已经在回溯往上走了，
     但是后序遍历要左右孩子走完才可以访问自己，所以这里如果有右孩子还需要把右孩子进栈，
     否则说明已经到自己了，可以访问并且出栈了。
     （3）如果cur的右孩子是pre，那么说明左右孩子都访问结束了，可以轮到自己了，访问并且出栈即可。
     与递归法一样,算法时间复杂度也是O(n)，空间复杂度是栈的大小O(logn)。
     * http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
     * @param root
     * @return
     */
    public List<String> traversePostOderIterative(BinaryTreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null) return result;
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode prev = null;
        while (!stack.isEmpty()){
            BinaryTreeNode curr = stack.peek();
            if (prev==null || prev.left==curr || prev.right==curr){ //往下走
                if (curr.left!=null) stack.push(curr.left);
                else if (curr.right!=null) stack.push(curr.right);
                else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if (curr.left==prev){    //从左节点往上走
                if (curr.right!=null) stack.push(curr.right);
                else {
                    stack.pop();
                    result.add(curr.val);
                }
            } else if (curr.right==prev){   //从右节点往上走
                stack.pop();
                result.add(curr.val);
            }
            prev = curr;
        }
        return result;
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
