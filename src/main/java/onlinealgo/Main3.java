package onlinealgo;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i=0; i<n; i++){
            String[] strings = in.nextLine().trim().split(",");
            for (int j=0; i<n; j++){
                matrix[i][j] = Integer.valueOf(strings[j]);
            }
        }
    }

}
