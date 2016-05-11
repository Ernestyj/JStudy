package leetcode71_80;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character
 * Created by DCLab on 12/24/2015.
 */
public class EditDistance {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");
        System.out.println(new EditDistance().minDistance("eat", "sea"));
    }


    /**
     * https://leetcode.com/discuss/50807/java-dp-solution-o-nm
     * f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2
     Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
     f(i, j) = f(i - 1, j - 1)
     Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
     f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
     f(i, j - 1) represents insert operation
     f(i - 1, j) represents delete operation
     f(i - 1, j - 1) represents replace operation
     Here, we consider any operation from word1 to word2. It means, when we say insert operation,
     we insert a new character after word1 that matches the jth character of word2.
     So, now have to match i characters of word1 to j - 1 characters of word2.
     Same goes for other 2 operations as well.

     Note that the problem is symmetric. The insert operation in one direction (i.e. from word1 to word2)
     is same as delete operation in other. So, we could choose any direction.

     Above equations become the recursive definitions for DP.
     Base Case: f(0, k) = f(k, 0) = k
     *
     * 参考：http://blog.unieagle.net/2012/09/19/leetcode%E9%A2%98%E7%9B%AE%EF%BC%9Aedit-distance%EF%BC%8C%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%8B%E9%97%B4%E7%9A%84%E7%BC%96%E8%BE%91%E8%B7%9D%E7%A6%BB%EF%BC%8C%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92/
     * D[i,j]: s1的前i个字符和 s2的前j个字符的最短编辑距离
     * 注意置换也是一种基本操作，置换明显比 删除+增加 操作更短；
     * 如果置换不是基本操作，则是另一种算法（参考：http://blog.csdn.net/abcjennifer/article/details/7735272）。
     * s1[i]!=s2[j]时，D[i,j]=min(D[i-1,j]+1,D[i,j-1]+1,D[i-1,j-1]+1);
     * s1[i]==s2[j]时，D[i,j]=D[i-1,j-1];
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) return 0;
        int m = word1.length(), n = word2.length();
        int[][] D = new int[m+1][n+1];
        int i = 0, j = 0;
        //初始化
        for (i=0; i<=m; i++)
            D[i][0] = i;
        for (j=0; j<=n; j++)
            D[0][j] = j;
        //遍历
        for (i=1; i<=m; i++)
            for (j=1; j<=n; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    D[i][j] = D[i-1][j-1];
                else {
                    int replace = D[i-1][j-1] + 1;
                    int insert = D[i][j-1] + 1;
                    int delete = D[i-1][j] + 1;
                    int temp = Math.min(replace, insert);
                    D[i][j] = Math.min(temp, delete);
                }
            }
        return D[m][n];
    }

}
