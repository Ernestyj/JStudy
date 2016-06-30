package eugene;

/**
 * Created by DCLab on 11/19/2015.
 */
public class BitOperation {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        System.out.println(maxInt());
        System.out.println(minInt());
        System.out.println(maxLong());
        System.out.println(minLong());

        System.out.println(Integer.toBinaryString(3 & 1));
        System.out.println(isOdd(2));

        System.out.println(multiplyTwoPower(1, 2));
        System.out.println(factorialOfTwo(2));

        System.out.println(oneBitsCount(2));
    }

    public static int maxInt(){
        return (1 << 31) - 1;
        //return ~(1 << 31);
        //return (1 << -1) - 1;
    }
    public static int minInt(){
        return 1 << 31;
        //return 1 << -1;
    }

    public static long maxLong(){
        return ((long)1 << 127) - 1;
    }
    public static long minLong(){
        return (long)1 << 127;
    }

    public static boolean isOdd(int n){
        return (n & 1) == 1;
    }

    public static int multiplyTwoPower(int m, int n){
        return m << n;
    }
    public static int factorialOfTwo(int n){
        //return 2 << (n - 1);
        return 1 << n;
    }

    /**求整数的二进制表示中有多少个 1
     * 思路：应用了n&=(n-1)能将 n 的二进制表示中的最右边的 1 翻转为 0 的事实。只需要不停地执行 n&=(n-1)，
     * 直到 n 变成 0 为止，那么翻转的次数就是原来的 n 的二进制表示中 1 的个数
     */
    public static int oneBitsCount(int n){
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }

}
