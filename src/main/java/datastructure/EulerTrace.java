package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoz on 2016/10/31.
 * Reference to: http://www.cnblogs.com/leoo2sk/archive/2010/10/18/1854658.html
 * 扩展： 一笔画问题： 寻找欧拉迹
 *
 * 本题只要遍历寻找最大的包含有苹果的路径即可，不要求包含所有节点
 * 二叉树 从任意一个节点开始都还是一棵二叉树
 */
public class EulerTrace {
    class Node{
        int id;
        boolean hasApple;
        List<Node> edges;

        public Node(int id){
            this.id = id;
            this.hasApple = false;
            edges = new ArrayList<Node>();
        }
        public void setHasApple(){
            this.hasApple = true;
        }
        public boolean isHasApple(){
            return  hasApple;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object node){
            return node !=null && this.id == ((Node)node).getId();
        }
        public void addNeighbor(Node node){
            edges.add(node);
        }
    }

    //函数入口
    int collectApples(int N, int K, int[]applesAtNodes, int[][] connectedNodes){
        List<Node> nodeList = new ArrayList<Node>(N);
        for (int i = 0; i < N; i++) {
            nodeList.add(new Node(i+1));//start from 1
        }

        for (int i = 0; i < applesAtNodes.length; i++) {
            nodeList.get(i).setHasApple();
        }

        for (int i = 0; i < connectedNodes.length; i++) {
            int m = connectedNodes[i][0];
            int n = connectedNodes[i][1];
            nodeList.get(m - 1).addNeighbor(nodeList.get(n - 1));//假设编号从1开始，顺序加入
            nodeList.get(n - 1).addNeighbor(nodeList.get(m - 1));
        }

        //从任意一个节点开始，选任意一条边去遍历，递归到空节点结束为一条路径，计算此次has apple 的个数，取最大值
        //遍历结束条件是所有节点是当找到了最大值
        int max = 0;
        for (int i = 0; i < nodeList.size(); i++) {

            int sum = visit(nodeList.get(i), null);

            if (sum > max)
                max = sum;

            //find the maximum, no need to continue
            if (max == applesAtNodes.length)
                break;
        }

        return max;
    }

    //递归计算每条子路的最大值，不走回头路
    public int visit(Node node, Node parent){
        //当前节点的邻边只有出发点，走到尽头
        int currentValue = node.hasApple ? 1 : 0;

        //叶子节点，只有parent的边
        if(node.edges.size() == 1)
            return currentValue;

        int subMax = 0; //子节点中的最大值
        for (int i = 0; i < node.edges.size(); i++) {
            Node currNode = node.edges.get(i);
            if (currNode.equals(parent))  //can't go back to parent
                continue;

            int x =  visit(currNode, node); //recursive get the sum of subtree

            if (x > subMax)
                subMax = x;
        }

        return subMax + currentValue;
    }

    public static void main(String args[]){
        int N = 8;//4;
        int K = 4;//3;
        int[] applesAtNodes = {2,3,5,6};//{2,3,4};
        //int[][] connectedNodes = {{1,2},{1,3},{1,4}};
        int[][] connectedNodes ={{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{6,8}};
        int sum = new EulerTrace().collectApples(N, K, applesAtNodes, connectedNodes);
        System.out.println("Max apple collected: "+sum);
    }
}
