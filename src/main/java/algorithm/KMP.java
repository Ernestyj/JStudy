package algorithm;

/**TODO
 * 图解：http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * 代码：http://blog.csdn.net/v_july_v/article/details/7041827
 *
 * Created by DCLab on 11/18/2015.
 */
public class KMP {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String p = "foo";

        System.out.println("*****RESULT*****");
        int index = new KMP().kmpSearch(s.toCharArray(), p.toCharArray());
        System.out.println(index);
    }


    private int[] next;
    public int kmpSearch(char[] s, char[] p){
        next = new int[p.length];
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == p.length) return i - j;
        else return -1;
    }
    private void patternNext(char[] p, int[] next) {
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < p.length - 1) {
            //p[k]表示前缀，p[j]表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

}
