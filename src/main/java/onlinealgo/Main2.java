package onlinealgo;

import java.util.Scanner;

/**
 * Created by eugene on 16/8/2.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] matrix = new char[n][m];
        for (int i=0; i<n; i++){
            String line = in.nextLine();
            for (int j=0; j<m; j++){
                matrix[i][j] = line.charAt(j);
            }
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int k = in.nextInt();
        int[][] steps = new int[k][2];
        for (int i=0; i<k; i++){
            steps[k][0] = in.nextInt();
            steps[k][1] = in.nextInt();
        }
    }
    static int local = 0, max = 0;
    public static void maze(int n, int m, char[][] matrix, int startX, int startY, int k, int[][] steps){


    }
}
