package datastructure.Graph;

import java.io.IOException;
import java.util.LinkedList;

/**求单源最短路，可以判断有无负权回路(若有，则不存在最短路).时效性较好，时间复杂度O(VE)
 * TODO 基于邻接矩阵
 * http://stackoverflow.com/questions/15681885/bellman-ford-algorithm-in-java
 * Created by eugene on 16/6/18.
 */
public class BellmanFord  {

    public static void main(String args[]) throws IOException   {
//        char[] vexs = {'0', '1', '2'};
//        int[][] matrix = {
//                {0, 99, 1},
//                {4, 0, 2},
//                {2, 4, 0}};
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
        BellmanFord  graph = new BellmanFord(vexs, matrix);
        int v = graph.mVertex.length;
        int[] prev = new int[v];
        long[] dist = new long[v];  //TODO long
        // BellmanFord算法获取"第4个顶点"到其它各个顶点的最短距离
        graph.bellmanford(3, prev, dist);
    }

    LinkedList<Edge> edges;
    private char[] mVertex; //顶点集合
    private int[][] mMatrix;    //邻接矩阵,权重(路径长)
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    private static class Edge  {
        int u, v;
        long w;
        public Edge(int a, int b, long c)     {
            u=a; v=b; w=c;
        }
    }

    public BellmanFord(char[] vexs, int[][] matrix) {
        this.mVertex = vexs;
        this.mMatrix = matrix;
        int v = mMatrix.length;
        edges = new LinkedList<>();
        for(int i = 0; i<v; i++) {
            for(int j = 0; j<v; j++)   {
                if(mMatrix[i][j]!=0 && mMatrix[i][j]!=INF) edges.add(new Edge(i, j, mMatrix[i][j]));
            }
        }
    }

    public void bellmanford(int s, int[] prev, long[] dist) {
        int v = mMatrix.length;
        int e = edges.size();
        for(int i=0; i<v; ++i) {
            dist[i]= INF;
            prev[i] = -1;
        }
        dist[s] = 0;
        for (int i = 0; i < v - 1; ++i) {
            for (int j = 0; j < e; ++j) { //here i am calculating the shortest path
                if (dist[edges.get(j).u] + edges.get(j).w < dist[edges.get(j).v]) {
                    dist[edges.get(j).v] = dist[edges.get(j).u] + edges.get(j).w;
                    prev[edges.get(j).v] = edges.get(j).u;
                }
            }
        }
        //判断负权回路(若有，则不存在最短路)
        for (int j = 0; j < e; ++j){
            if (dist[edges.get(j).u] + edges.get(j).w < dist[edges.get(j).v]) {
                System.out.println(" There is a negative edge cycle ");
                break;
            }
        }
        // 打印BellmanFord最短路径的结果
        System.out.printf("BellmanFord(%c): \n", mVertex[s]);
        for(int i=0; i<v; i++)
            System.out.printf(" shortest(%c, %c)=%d\n", mVertex[s], mVertex[i], dist[i]);
        //for(int i=0; i<v; i++) System.out.println("Vertex " + i + " has predecessor " + prev[i]);
    }

}
