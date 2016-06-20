package indeed;

import java.util.*;

/**
 * Created by eugene on 16/5/28.
 */
public class Main3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int Q = sc.nextInt();
        int[][] q = new int[Q][Q];
        for (int i=0; i<Q; i++){
            q[i][0] = sc.nextInt();
            q[i][1] = sc.nextInt();
        }
        //int[][] q = {{2,7},{2,5},{4,1},{7,5},{1,2},{7,5},{6,8},{1,4}};
        shortestPath(V, Q, q);
    }

    private static void shortestPath(int V, int Q, int[][] q){
        ArrayList<Vertex> vs = new ArrayList<>();
        for (int i=0; i<V; i++){
            vs.add(new Vertex(String.valueOf(i+1)));
        }
        for (int i=0; i<V; i++){
            if (i+1<V) vs.get(i).adjs.add(new Edge(vs.get(i+1), 1));
        }
        for (int i=0; i<q.length; i++){
            int l = q[i][0], r = q[i][1];
            computePaths(vs.get(l-1));
            double dis = vs.get(r-1).minDis;
            if (Double.compare(dis, Double.POSITIVE_INFINITY)==0) dis = -1;
            System.out.println((int)dis);
            for (int j=0; j<V; j++){
                vs.get(j).minDis = Double.POSITIVE_INFINITY;
            }
            vs.get(l-1).adjs.add(new Edge(vs.get(r-1), 1));
        }
    }


    static class Vertex implements Comparable<Vertex> {
        public final String name;
        public List<Edge> adjs = new ArrayList<>();
        public double minDis = Double.POSITIVE_INFINITY;
        public Vertex previous;
        public Vertex(String argName) { name = argName; }
        public String toString() { return name; }
        public int compareTo(Vertex other) {
            return Double.compare(minDis, other.minDis);
        }
    }

    static class Edge {
        public final Vertex target;
        public final double weight;
        public Edge(Vertex argTarget, double argWeight)
        { target = argTarget; weight = argWeight; }
    }

    public static void computePaths(Vertex source) {
        source.minDis = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
            // Visit each edge exiting u
            for (Edge e : u.adjs) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDis + weight;
                if (distanceThroughU < v.minDis) {
                    vertexQueue.remove(v);

                    v.minDis = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);
        Collections.reverse(path);
        return path;
    }

}
