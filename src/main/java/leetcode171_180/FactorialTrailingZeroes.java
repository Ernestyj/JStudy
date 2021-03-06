package leetcode171_180;

/**Given an integer n, return the number of trailing zeroes in n!.
 Note: Your solution should be in logarithmic time complexity.
 * Created by eugene on 16/3/20.
 */
public class  FactorialTrailingZeroes {

    /**http://www.danielbit.com/blog/puzzle/leetcode/leetcode-factorial-trailing-zeroes
     * 需要统计阶乘质因子的(2,5)对的个数，因为2×5=10.容易观察到质因子中2的个数总是大于等于5的个数,因此只要计数5的个数就可以了。
     一个方法是计算floor(n/5)。例如，7!有一个5，10!有两个5。除此之外，还有一件事情要考虑,诸如25，125之类的数有不止一个5。
     最终解法就是：对n/5+n/25+n/125+…进行求和，当n小于分母的时候停止。
     这样的话在计算5^2的时候，能被25整除的数里面的两个5，其中一个已经在5^1中计算过了,所以5^2直接加到count上。
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        for (long i=5; i<=n; i*=5) {
            count += n/i;
        }
        return count;
    }

    //对于大的输入值会栈溢出
    public int trailingZeroes1(int n) {
        String s = String.valueOf(factorial(n));
        int count = 0;
        for (int i=s.length()-1; i>=0; i--){
            if (s.charAt(i)=='0') count++;
            else return count;
        }
        return count;
    }
    private long factorial(int n){
        if (n==0||n==1) return 1;
        return factorial(n-1)*n;
    }

}
