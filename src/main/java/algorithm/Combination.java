package algorithm;

import java.util.ArrayList;
import java.util.List;

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
     * TODO 判断数x第i位是否为1：x & (1 << (i - 1)) != 0则为1
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
     * 回溯法
     *
     * @param str
     */
    public static void allCombinations(String[] str) {

    }

    /**TODO 修改下列算法为全组合
     * 回溯法
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
     For example,
     If n = 4 and k = 2, a solution is:
     [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
     */
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) return result;
        backTrack(n, k, 1);
        return result;
    }
    private void backTrack(int n, int k, int x){
        if (k == 0){
            result.add(new ArrayList<>(temp));
        }
        for (int i=x; i<=n; i++){
            temp.add(i);
            backTrack(n, k - 1, i + 1);
            temp.remove(temp.size()-1);
        }
    }


}
