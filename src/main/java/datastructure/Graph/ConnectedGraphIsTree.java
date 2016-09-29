package datastructure.Graph;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/**判断图是否为树要看两个条件：1.图连通；2.不存在回环
 * Created by eugene on 16/9/22.
 */
public class ConnectedGraphIsTree {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
//        int[][] grid = {{0,1,0,1},
//                        {1,0,1,0},
//                        {0,1,0,0},
//                        {1,0,0,0}};
//        int[][] grid = {{0,1},{1,1}};
        int[][] grid = {{0,1,0},{1,0,1},{0,1,0}};

        System.out.println(isTree(grid));
    }

    public static boolean isTree(int[][] grid){
        int n = grid.length;
        boolean[] visited = new boolean[n];
        for (int i=0; i<n; i++){
            if(!visited[i]){
                if (isCycle(i, -1, grid, visited)) return false;
            }
        }
        return true;
    }

    // For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited
    // and u is not parent of v, then there is a cycle in graph.
    public static boolean isCycle(int i, int parent, int[][] grid, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++ ) {
            if ( grid[i][j] > 0 && !visited[j] ) {
                // If an adjacent is not visited, then recur for that adjacent
                if (isCycle(j, i, grid, visited)) return true;
            } else if (grid[i][j] > 0 && visited[j]) {
                // If an adjacent is visited and not parent of current vertex, then there is a cycle.
                if (j != parent) return true;
            }
        }
        return false;
    }
}
