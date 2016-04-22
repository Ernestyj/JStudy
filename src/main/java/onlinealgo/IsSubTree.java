package onlinealgo;

/**
 * Created by eugene on 16/4/8.
 */
public class IsSubTree {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};

        System.out.println();
    }


    class TNode {
        int value;
        TNode left;
        TNode right;
    }

    // 判断t2是否是t1的子树
    private static boolean isSubTreeHelper(TNode t1, TNode t2) {
        if(t2 == null) {            // 空树始终是另一个树的子树
            return true;
        }
        if(t1 == null) {        // 此时r2非空，非空树不可能是一个空树的子树
            return false;
        }
        if(t1.value == t2.value) {            // 找到两树匹配
            if(isSameTree(t1, t2)){
                return true;
            }
        }
        // 继续在r1的左子树和右子树里找匹配
        return isSubTreeHelper(t1.left, t2) || isSubTreeHelper(t1.right, t2);
    }
    // 判断两棵树是否相同
    private static boolean isSameTree(TNode t1, TNode t2) {
        if(t1==null && t2==null) {
            return true;
        }
        if(t1==null || t2==null) {
            return false;
        }
        if(t1.value != t2.value) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
    public static int isSubTree(TNode root1, TNode root2) {
        boolean isSub = isSubTreeHelper(root1, root2);
        if (isSub) return 1;
        else return -1;
    }


}
