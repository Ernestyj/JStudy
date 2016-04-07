package algorithm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by eugene on 16/4/6.
 */
public class Robot {
    public static void main(String[] args) {
        char[][] grids = read();
        int m = grids.length;
        int n = grids[0].length;
//        boolean canreach = canReach(m, n, grids);
//        System.out.println(canreach);
        int min = robot(m, n, grids);
        System.out.print(min);
    }

    static int min = Integer.MAX_VALUE;
    public static int robot(int m, int n, char[][] grids){
        if (canReach(m, n, grids)) return 0;

        return min;
    }
    private static void dfs(int m ,int n, char[][] grids, int row){
        if (row==m) return;
        for (int j=0; j<n; j++){
            if (grids[row][j]=='.'){
                grids[row][j]='b';
                if (canReach(m, n, grids)){
                    if (row+1<min) min = row+1;
                    grids[row][j]='.';
                    return;
                } else {
                    dfs(m, n, grids, row+1);
                    grids[row][j]='.';
                }
            }else if (grids[row][j]=='b'){
                grids[row][j]='.';
                if (canReach(m, n, grids)){
                    if (row+1<min) min = row+1;
                    grids[row][j]='b';
                    return;
                } else {
                    dfs(m, n, grids, row+1);
                    grids[row][j]='b';
                }
            }
        }
//        for (int i=depth; i<blocks.size(); i++){
//            Block block = blocks.get(i);
//            grids[block.x][block.y] = '.';
//            if (canReach(m, n, grids)) {
//                if (i-depth+1<min) min = i-depth+1;
//                grids[block.x][block.y] = 'b';
//                return;
//            } else {
//                dfs(m, n, grids, depth+1, blocks);
//                grids[block.x][block.y] = 'b';
//            }
//        }
    }
    private static boolean canReach(int m, int n, char[][] grids){
        int STEP = m + n - 2;
        int i = 0, j = 0;
        int step = 0;
        while (true){
            if (i+1<m && j+1<n && grids[i+1][j]=='b' && grids[i][j+1]=='b') return false;
            while (j+1<n && grids[i][j+1]!='b'){
                j++; step++;
                if (step==STEP) return true;
            }
            while (i+1<m && grids[i+1][j]!='b'){
                i++; step++;
                if (step==STEP) return true;
            }
        }
    }
    private static char[][] read(){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
//        System.out.println(m + " " + n);
        in.nextLine();
        char[][] grids = new char[m][n];
        for (int i=0; i<m; i++){
            String line = in.nextLine();
//            System.out.println(line);
            for (int j=0; j<n; j++){
                grids[i][j] = Character.valueOf(line.charAt(j));
            }
        }
        return grids;
    }

}
