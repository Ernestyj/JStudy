package datastructure.Graph;

/**求单源、无负权的最短路。时效性较好，时间复杂度为O(V^2+E)。
 * TODO 基于邻接矩阵
 * http://www.cnblogs.com/skywang12345/p/3711516.html
 * Created by eugene on 16/6/18.
 */
public class Dijkstra {

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
          /*A*/ {   0,  12, INF, INF, INF,  16,  14},
          /*B*/ {  12,   0,  10, INF, INF,   7, INF},
          /*C*/ { INF,  10,   0,   3,   5,   6, INF},
          /*D*/ { INF, INF,   3,   0,   4, INF, INF},
          /*E*/ { INF, INF,   5,   4,   0,   2,   8},
          /*F*/ {  16,   7,   6, INF,   2,   0,   9},
          /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        Dijkstra graph = new Dijkstra(vexs, matrix);
        int v = graph.mVertex.length;
        int[] prev = new int[v];
        int[] dist = new int[v];
        // dijkstra算法获取"第4个顶点"到其它各个顶点的最短距离
        graph.dijkstra(3, prev, dist);
    }

    private char[] mVertex; //顶点集合
    private int[][] mMatrix;    //邻接矩阵,权重(路径长)
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    public Dijkstra(char[] vexs, int[][] matrix) {
        this.mVertex = vexs;
        this.mMatrix = matrix;
    }

    /**DP, dist[i]=dist[k]+matrix[k,i], dist[k]=min(dist[0,v-1])
     若已经计算出s到i最短路径的结点,且i-j间有边,则计算从i到未计算结点j的最短路径.
     * @param s 起始顶点
     * @param prev 前驱顶点数组, prev[i]是s到i的最短路径所经历的全部顶点中，位于i之前的那个顶点
     * @param dist 长度数组, dist[i]是s到i的最短路径的长度
     */
    public void dijkstra(int s, int[] prev, int[] dist) {
        int v = mVertex.length;
        boolean[] shortest = new boolean[v];// shortest[i]=true表示s到i的最短路径已成功获取
        for (int i = 0; i<v; i++) { // 初始化
            dist[i] = mMatrix[s][i];  // 顶点i的最短路径为s到i的权
            prev[i] = -1;
        }
        shortest[s] = true; // 对s自身进行初始化
        int k=0;
        for (int t=1; t<v; t++) {   // 遍历v-1次；每次找出一个顶点的最短路径
            int min = INF;
            for (int i=0; i<v; i++) {// 寻找当前最小的路径, 即在未获取最短路径的顶点中找到离s最近的顶点k
                if (!shortest[i] && dist[i]<min) {
                    min = dist[i];
                    k = i;
                }
            }
            shortest[k] = true; // 标记"顶点k"为已经获取到最短路径
            // 修正当前最短路径和前驱顶点
            // 即当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
            for (int i=0; i<v; i++) {
                int tmp = mMatrix[k][i]==INF? INF : min+mMatrix[k][i];
                if (!shortest[i] && tmp<dist[i]) {
                    dist[i] = tmp;
                    prev[i] = k;
                }
            }
        }
        // 打印dijkstra最短路径的结果
        System.out.printf("dijkstra(%c): \n", mVertex[s]);
        for (int i=0; i<v; i++)
            System.out.printf(" shortest(%c, %c)=%d\n", mVertex[s], mVertex[i], dist[i]);
    }

}
