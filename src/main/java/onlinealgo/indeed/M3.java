package onlinealgo.indeed;

import java.util.Scanner;

/**
 * Created by eugene on 16/7/2.
 */
public class M3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] board = new char[6][6];
        for (int i=0; i<6; i++) {
            String line = sc.next();
            board[i] = line.toCharArray();
        }

        System.out.println();
    }

    private static int count = 0;
    public static int solveTable(char[][] board){
        if(!valid(board)) return 0;
        int[] cols = new int[6];
        dfs(board, 0, cols);
        return 0;
    }
    public static void dfs(char[][] board, int row, int[] cols){
        if(row==6){
            count++;
            return;
        }
        for (int r=row; r<6; r++){
            for (int j=0; j<6; j++){
                if(board[r][j]=='.' && cols[j]<3){
                    board[r][j] = 'o'; cols[j]++;
                    if (valid(board)) dfs(board, row, cols);
                    board[r][j] = '.';
                }
            }
        }

    }
    public static boolean valid(char[][] board){
        int[] cols = new int[6];
        for (int i=0; i<6; i++){
            int rowCount = 0;
            for (int j=0; j<6; j++){
                if (board[i][j]=='o'){
                    if(++rowCount >3) return false;
                    if(++cols[j] >3) return false;
                }
            }
        }
        return true;
    }

}
