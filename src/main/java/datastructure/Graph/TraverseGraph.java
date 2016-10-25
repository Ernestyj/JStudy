package datastructure.Graph;

import java.util.*;

/**基于邻接矩阵(顶点编号从0开始,无边值为0),DFS(递归与非递归)和BFS
 * http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Graph/dfs.html
 * Created by eugene on 16/9/26.
 */
public class TraverseGraph {
    /* ------------------------------------------
       Data structure used to represent a graph
       ------------------------------------------ */
    int[][]  adjMatrix;
    int      rootNode = 0;
    int      numNodes;

    boolean[] visited;

    /* -------------------------------
       Construct a graph of n nodes
       ------------------------------- */
    TraverseGraph(int n) {
        numNodes = n;
        adjMatrix = new int[n][n];
        visited = new boolean[n];
    }

    TraverseGraph(int[][] mat) {
        numNodes = mat.length;
        adjMatrix = new int[numNodes][numNodes];
        visited = new boolean[numNodes];
        for (int i=0; i < numNodes; i++)
            for (int j=0; j < numNodes; j++)
                adjMatrix[i][j] = mat[i][j];
    }

    //DFS (Recursive)
    public void dfs(int i) {
        visited[i] = true;
        printNode(i);
        for (int j = 0; j < numNodes; j++ ) {
            if ( adjMatrix[i][j] > 0 && !visited[j] )
                dfs(j);
        }
    }

    //DFS uses Stack data structure
    public void dfsNonRecursive() {
        Stack<Integer> stack = new Stack<>();
        stack.push(rootNode);
        visited[rootNode] = true;
        printNode(rootNode);
        while( !stack.isEmpty() ) {
            int child = getUnvisitedChildNode(stack.peek());
            if ( child != -1 ) {    //无邻接节点
                visited[child] = true;
                printNode(child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
    }

    // BFS uses Queue data structure
    public void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(rootNode);
        visited[rootNode] = true;
        printNode(rootNode);
        while( !q.isEmpty() ) {
            int child = getUnvisitedChildNode(q.peek());
            if ( child != -1 ) {
                visited[child] = true;
                printNode(child);
                q.add(child);
            } else {
                q.remove();
            }
        }
    }

    private int getUnvisitedChildNode(int n) {  //无邻接节点返回-1
        for (int j = 0; j < numNodes; j++ ) {
            if ( adjMatrix[n][j] > 0 && !visited[j] )
                return j;
        }
        return -1;
    }

    private void clearVisited() {
        int i;
        for (i = 0; i < visited.length; i++)
            visited[i] = false;
        System.out.println("\nVisited cleared.");
    }

    private void printNode(int n) {
        System.out.print(n+" ");
    }

    public static void main(String[] args)
    {
//                        0  1  2  3  4  5  6  7  8
// ===================================================
        int[][] conn = {{ 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
                        { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
                        { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
                        { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
                        { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
                        { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
                        { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
                        { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
                        { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

        TraverseGraph graph = new TraverseGraph(conn);
        System.out.println("*****DFS(Recursive)*****");
        graph.dfs(graph.rootNode);
        graph.clearVisited();

        System.out.println("*****DFS(Recursive)*****");
        graph.dfsNonRecursive();
        graph.clearVisited();

        System.out.println("*****DFS(Recursive)*****");
        graph.bfs();
        graph.clearVisited();
    }
}

