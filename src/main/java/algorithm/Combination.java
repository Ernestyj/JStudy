package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入三个字符 a、b、c（不重复），则它们的组合有a b c ab ac bc abc。
 * 若输入字符含有重复，可参考SubsetsII。
 * Created by DCLab on 11/13/2015.
 */
public class Combination {

    public static void main(String[] args) {
        String str[] = { "A", "B", "C" };
//        String str[] = { "A", "B", "C", "D", "E" };
        System.out.println("*****RESULT*****");
        //方法一
//        printAllCombinations(str);
        //方法二
//        Combination instance = new Combination();
//        instance.allCombinations(str);
//        for (List<String> strs : instance.result){
//            for (String i : strs) System.out.print(i + " ");
//            System.out.println();
//        }
        //方法三
        List<List<String>> res = new Combination().allCombinations1(str);
        for (List<String> strs : res){
            for (String i : strs) System.out.print(i + " ");
            System.out.println();
        }

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
        System.out.println("\n*********");
    }

    /**
     * 回溯法
     * @param str
     */
    private List<List<String>> result = new ArrayList<>();
    private List<String> sol = new ArrayList<>();
    public List<List<String>> allCombinations(String[] str) {
        backTrack(str, 0);
        return result;
    }
    private void backTrack(String[] str, int start){
        for(int i=start; i<str.length; i++) {
            sol.add(str[i]);
            result.add(new ArrayList<>(sol));
            backTrack(str, i+1);
            sol.remove(sol.size() - 1);
        }
    }

    /**
     * 添加数字构建subset方法（TODO 注意：此方法需要起始包含空集！）
     起始subset集为：[]
     添加S0后为：[] | [S0]
     添加S1后为：[], [S0] | [S1], [S0, S1]
     添加S2后为：[], [S0], [S1], [S0, S1] | [S2], [S0, S2], [S1, S2], [S0, S1, S2]
     显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si。
     * @param str
     * @return TODO 注意返回结果中含有空集
     */
    public List<List<String>> allCombinations1(String[] str) {
        List<List<String>> result = new ArrayList<>();
        List<String> newSol = new ArrayList<>();
        result.add(newSol);   //添加空集
        for(int i=0; i<str.length; i++) {
            int n = result.size();
            for(int j=0; j<n; j++) {
                newSol = new ArrayList<>(result.get(j));    //TODO 此处应分配新空间
                newSol.add(str[i]);
                result.add(newSol);
            }
        }
        return result;
    }


}
