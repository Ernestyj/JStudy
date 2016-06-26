package leetcode71_80;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 For example,
 If n = 4 and k = 2, a solution is:
 [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4] ]
 * Created by DCLab on 12/29/2015.
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (n==0 || k==0) return res;
        dfs(n, k, 1, res, new LinkedList<>());
        return res;
    }
    private void dfs(int n, int k, int start, List<List<Integer>> res, List<Integer> sol){
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

}
