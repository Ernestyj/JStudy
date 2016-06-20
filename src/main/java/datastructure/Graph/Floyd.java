package datastructure.Graph;

/**求多源、无负权边的最短路。用矩阵记录图。时效性较差，时间复杂度O(V^3)
 * TODO 基于邻接矩阵
 * http://www.cnblogs.com/skywang12345/p/3711532.html
 * Created by eugene on 16/6/18.
 */
public class Floyd {

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
        Floyd graph = new Floyd(vexs, matrix);
        int v = graph.mVertex.length;
        int[][] path = new int[v][v];
        int[][] dist = new int[v][v];
        graph.floyd(path, dist);
    }

    private char[] mVertex; //顶点集合
    private int[][] mMatrix;    //邻接矩阵,权重(路径长)
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    public Floyd(char[] vexs, int[][] matrix) {
        this.mVertex = vexs;
        this.mMatrix = matrix;
    }

    /**
     * @param path 路径, path[i][j]=k表示i到j的最短路径会经过k
     * @param dist 长度数组, dist[i][j]表示i到j的最短路径的长度
     */
    public void floyd(int[][] path, int[][] dist) {
        int v = mVertex.length;
        for (int i=0; i<v; i++) {   // 初始化
            for (int j=0; j<v; j++) {
                dist[i][j] = mMatrix[i][j];    // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
                path[i][j] = j;                // "顶点i"到"顶点j"的最短路径是经过顶点j。
            }
        }
        for (int k=0; k<v; k++) {   // 计算最短路径
            for (int i=0; i<v; i++) {
                for (int j=0; j<v; j++) {
                    int tmp = (dist[i][k]==INF || dist[k][j]==INF)? INF : dist[i][k]+dist[k][j];
                    if (dist[i][j] > tmp) {// 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
                        dist[i][j] = tmp;
                        path[i][j] = path[i][k];// "i到j最短路径"对应的路径经过k
                    }
                }
            }
        }
        //打印floyd最短路径的结果
        System.out.printf("floyd: \n");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) System.out.printf("%2d  ", dist[i][j]);
            System.out.printf("\n");
        }
    }

}
