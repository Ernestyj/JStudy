package algorithm;

/**
 * 输入三个字符 a、b、c，则它们的组合有a b c ab ac bc abc。
 *
 * Created by DCLab on 11/13/2015.
 */
public class Combination {

    public static void main(String[] args) {
        String str[] = { "A", "B", "C", "D", "E" };
        printAllCombinations(str);
    }

    /**
     * http://segmentfault.com/a/1190000002710424
     * 思路：基于位图。
     * 假设原有元素n个，最终的组合结果有2^n - 1.
     * 可以使用2^n - 1个位，1表示取该元素，0表示不取。
     * 例如001,010,011,100,101,110,111。对应输出组合结果为：a,b,ab,c,ac,bc,abc。
     * 因此可以循环 1~2^n-1(字符串长度)，然后输出对应代表的组合即可。
     *
     * @param str
     */
    public static void printAllCombinations(String[] str) {
        if(str.length == 0) return;
        int n = 1 << str.length;    //2^len
        for(int i = 1; i < n; i++){ //从1循环到2^len-1
            StringBuffer sb = new StringBuffer();
            //查看第一层循环任意一种取值中哪一位是1；如果是1，对应的字符就存在，打印当前组合。
            for(int j = 0; j < str.length; j++){
                if( (i & (1 << j)) != 0)  //对应位为1，则输出对应的字符
                    sb.append(str[j]);
            }
            System.out.print(sb + " ");
        }
    }

    /**
     * TODO
     * 递归法
     *
     * @param str
     */
    public static void allCombinations(String[] str) {

    }

}
