package datastructure.Graph;

import java.util.Iterator;
import java.util.LinkedList;

/**有向图，基于邻接表(顶点编号从0开始),BFS
 * This class represents a directed graph using adjacency list representation
 * Created by DCLab on 2016/10/25.
 */
public class TraverseGraphAdjList {

    public static void main(String args[]) {
        Graph g = new Graph(6);//从1开始，多分配一个
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(3, 5);
        g.addEdge(5, 3);

        g.BFS(1);
    }

    static class Graph {
        private int numNodes;
        private LinkedList<Integer>[] adj;

        Graph(int v) {
            numNodes = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i) adj[i] = new LinkedList<>();
        }

        void addEdge(int v,int w) {
            adj[v].add(w);
        }

        void BFS(int s) {
            boolean[] visited = new boolean[numNodes];
            LinkedList<Integer> q = new LinkedList<>();
            visited[s] = true;
            q.add(s);
            while (!q.isEmpty()) {
                s = q.poll();
                System.out.print(s+" ");
                Iterator<Integer> iter = adj[s].listIterator();
                while (iter.hasNext()) {
                    int n = iter.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        q.add(n);
                    }
                }
            }
        }

    }

}
