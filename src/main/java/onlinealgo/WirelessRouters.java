package onlinealgo;

import java.util.*;

/**
 * Created by DCLab on 2016/10/25.
 */
public class WirelessRouters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(), M = in.nextInt();//read N and M
        int[] satVals = new int[N];
        for (int i=0; i<N; i++) satVals[i] = in.nextInt();//read satisfaction points
        HouseGraph house = new HouseGraph(N, satVals);
        for (int i=0; i<N-1; i++) house.addDoor(in.nextInt()-1, in.nextInt()-1);//read doors

        int maxSatVal = Integer.MIN_VALUE;
        List<List<Integer>> combinations = combinations(N, M);//get all device setting combinations
        for (List<Integer> sol : combinations){
            house.clearDevice();
            for (Integer i: sol) {//set devices
                house.hasDevice[i-1] = true;
                house.hasWifi[i-1] = true;
            }
            maxSatVal = Math.max(maxSatVal, house.countSatVal());//get max satisfaction values
        }
        System.out.println(maxSatVal);
    }

    //get all device setting combinations
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(n, k, 1, res, new LinkedList<>());
        return res;
    }
    //helper function for combinations
    private static void dfs(int n, int k, int start, List<List<Integer>> res, List<Integer> sol){
        if(sol.size()==k){
            res.add(new LinkedList<>(sol));
            return;
        }
        for(int i=start; i<=n; i++){
            sol.add(i);
            dfs(n, k, i+1, res, sol);
            sol.remove(sol.size()-1);
        }
    }

    static class HouseGraph {
        int n;//number of rooms
        LinkedList<Integer>[] adj;//adjacent list

        int[] satVal;
        boolean[] hasDevice;
        boolean[] hasWifi;

        public HouseGraph(int n, int[] satVal) {
            this.n = n;
            adj = new LinkedList[n];
            for (int i=0; i<n; i++) adj[i] = new LinkedList<>();
            this.satVal = satVal;
            hasDevice = new boolean[n];
            hasWifi = new boolean[n];
        }

        public void addDoor(int i, int j){
            adj[i].add(j);
            adj[j].add(i);
        }

        public void clearDevice(){
            hasDevice = new boolean[n];
            hasWifi = new boolean[n];
        }

        public int countSatVal(){
            int res = 0;
            for (int i=0; i<n; i++){
                if(hasDevice[i]){
                    res += satVal[i];
                    Iterator<Integer> it = adj[i].listIterator();
                    while (it.hasNext()){//count all adjacent rooms with wifi
                        int k = it.next();
                        if(!hasWifi[k]){
                            res += satVal[k];
                            hasWifi[k] = true;
                        }
                    }
                }
            }
            return res;
        }

    }

}
