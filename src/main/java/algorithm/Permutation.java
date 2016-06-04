package algorithm;

/**
 * 设计一个算法，输出一个字符串字符的全排列。
 * 比如，String = "abc"，输出是"abc","bac","cab","bca","cba","acb"
 *
 * Created by DCLab on 11/13/2015.
 */
public class Permutation {

    public static void main(String[] args) {
//        String str[] = { "A", "B", "C", "D", "E" };
        String str[] = { "A" };
        printAllPermutations(str);
        System.out.println("\n Another******************");
        printAllPermutations1("aa");
    }

    /**
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
        if (start == len - 1) {
            for (int i = 0; i < len; i ++) {
                System.out.print(str[i]);
            }
            System.out.print(" ");
        }
        else {
            for (int i = start; i < len; i ++) {
                swap(str, start, i);
                permutation(str, start + 1, len);
                swap(str, start, i);
            }
        }

    }
    private static void swap(String[] s, int i, int j) {
        String temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    // http://www.ericleschinski.com/c/java_permutations_recursion/
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
