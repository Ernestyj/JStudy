package algorithm;

import java.io.*;

/**
 * 背包问题（注意：算法中物品数组边界问题极易出错）
 * 
 * Created by DCLab on 10/31/2015.
 */
public class Knapsack {

    private int capacity, num;
    private int[] weights, values;
    private boolean[] isTakes;
    private int bestVal;

    private int[] takes;    //0取，1不取
    private int[] tempTakes;    //0取，1不取


    public static void main(String[] args){
        try {
//            new Knapsack("data/knapsack.txt").zeroOneKnapsackDP();
            new Knapsack("data/knapsack.txt").zeroOneKnapsackBackTrack();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Knapsack(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream in = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        in.read(bytes);
        in.close();
        // 第一行为物品数量num及背包容量capacity，
        // 接下来的n行数据中每行两个数对应的是物品的重量weight及价值value
        String[] strings = new String(bytes).split("\r\n| ");
        num = Integer.parseInt(strings[0]);
        capacity = Integer.parseInt(strings[1]);
        //TODO 注意此处要考虑放0个物体的情况，物体数组大小应+ 1
        isTakes = new boolean[num + 1];
        weights = new int[num + 1];
        values = new int[num + 1];
        int indice = 1;
        for (int i = 2; i < strings.length; i += 2){
            weights[indice] = Integer.parseInt(strings[i]);
            values[indice] = Integer.parseInt(strings[i + 1]);
            indice++;
        }
    }


    public void zeroOneKnapsackDP(){
        zeroOneKnapsackDP(capacity, num, weights, values);
    }
    /**
     * 0-1背包问题：每种物品只有一件，要么带要么不带；（注意：算法中物品数组边界问题极易出错）
     * 动态规划：
     * 用子问题定义状态：即f[i][w]表示前i件物品恰放入一个容量为w的背包可以获得的最大价值。
     * 则其状态转移方程便是：f[i][w]=max{f[i-1][w],f[i-1][w-c[i]]+v[i]} (注意边界值)
     *
     * 详细解释：“将前i件物品放入容量为w的背包中”这个子问题，
     * 若只考虑第i件物品的策略（放或不放），那么就可以转化为一个只牵扯前i-1件物品的问题：
     * a. 如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为w的背包中”，价值为f[i-1][w]；
     * b. 如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为w-c[i]的背包中”，
     * 此时能获得的最大价值就是f[i-1][w-c[i]]再加上通过放入第i件物品获得的价值v[i]。
     *
     * @param capacity
     * @param num
     * @param weights
     * @param values
     */
    private void zeroOneKnapsackDP(int capacity, int num, int[] weights, int[] values){
        //TODO 注意此处要考虑放0个物体的情况，物体数组大小应+ 1
        int[][] valueF = new int[num + 1][capacity + 1];
        boolean[][] solution = new boolean[num + 1][capacity + 1];
        //i = 0以及w = 0的情况，valF均默认为0
        for (int i = 1; i < num + 1; i++){
            for (int w = 1; w < capacity + 1; w++){
                int temp1 = 0;
                int temp2 = 0;
                //不放第i件物品（注意边界）
                temp1 = valueF[i - 1][w];
                //放第i件物品（注意是否超重）
                temp2 = (w < weights[i]) ? temp1 : valueF[i - 1][w - weights[i]] + values[i];
                if (temp1 < temp2){
                    solution[i][w] = true;
                    valueF[i][w] = temp2;
                }
                else valueF[i][w] = temp1;
            }
        }
        //计算出isTakes
        for (int i = num, w = capacity; i > 0; i--){
            if (solution[i][w]){
                isTakes[i] = true;
                w -= weights[i];
            }
        }
        bestVal = valueF[num + 1 - 1][capacity + 1 - 1];
        //输出
        System.out.println("Optimal value: " + bestVal);
        System.out.println("******************************");
        System.out.println("item" + "\t" + "value" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= num; n++) {
            System.out.println(n + "\t" + values[n] + "\t" + weights[n] + "\t" + isTakes[n]);
        }
    }

    public void zeroOneKnapsackBackTrack(){
        zeroOneKnapsackBackTrack(capacity, num, weights, values);
    }
    private void zeroOneKnapsackBackTrack(int capacity, int num, int[] weights, int[] values) {
        takes = new int[num + 1];
        tempTakes = new int[num + 1];

        backtrackZeroOneKnapsack(1, 0, 0);

        System.out.println("Optimal value: " + bestVal);
        System.out.println("******************************");
        System.out.println("item" + "\t" + "value" + "\t" + "weight" + "\t" + "take");
        for (int n = 1; n <= num; n++) {
            System.out.println(n + "\t" + values[n] + "\t" + weights[n] + "\t" +
                    (takes[n] == 1 ? true : false));
        }
    }
    /**
     * 0-1背包问题：每种物品只有一件，要么带要么不带；
     * 回溯法：
     * 物品有num种，背包容量为capacity，分别用values[i]和weights[i]存储第i种物品的价值和重量，用
     sol[i]标记第i种物品是否装入背包，用bestSol[i]存储第i种物品的最优装载方案；
     * 用递归函数Backtrack(i, val, weight)来实现回溯法搜索子集树
     （i：递归深度，maxDepth：最大递归深度，val：当前总价。weight：当前总重量，bestVal：当前最优总价值）
         ① 若i > maxDepth（到达叶结点回溯结束）判断当前总价值是否最优：
            当val > bestVal，更新最优价值：bestVal = val，并循环更新装载方案：bestSol[x] = sol[x]；
         ② 若未到达叶子，采用for循环对物品i装与不装两种情况进行讨论（0 ≤ isTake ≤ 1）：
             1） sol[i] = isTake；
             2） 若总重量不大于背包容量 weight + sol[i] * weights[i] <= capacity，
            则更新当前总价值和总重量：weight += weights[i] * sol[i], val += values[i] * sol[i],
            对物品i + 1调用递归函数Backtrack(i + 1, val, weight) 继续进行装载；
             3） 函数Backtrack(i + 1, val, weight)调用结束后
            则更新当前总价值和总重量: weight -= weights[i] * sol[i], val -= values[i] * sol[i]
     * 主函数调用一次backtrack(1, 0, 0)即可完成整个回溯搜索过程，
     最终得到的bestVal和bestSol[i]即为所求最大总价值和最优装载方案。
     *
     * @param i 深度depth
     * @param val
     * @param weight
     */
    private void backtrackZeroOneKnapsack(int i, int val, int weight){
        if (i > num){  //到达叶子节点，回溯结束
            if (val > bestVal){
                bestVal = val;
                for (int x = 0; x < num + 1; x++) takes[x] = tempTakes[x];
            }
        } else {
            for (int isTake = 0; isTake <= 1; isTake++){    //0不取，1取
                tempTakes[i] = isTake;
                int temp = weight + tempTakes[i] * weights[i];
                if (temp <= capacity){
                    weight = temp;
                    val += values[i] * tempTakes[i];
                    backtrackZeroOneKnapsack(i + 1, val, weight);
                    weight -= weights[i] * tempTakes[i];
                    val -= values[i] * tempTakes[i];
                }
            }
        }


    }


}
