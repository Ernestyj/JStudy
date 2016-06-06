package onlinealgo;

/**
 * Created by eugene on 16/6/5.
 */
public class OptiverOccurrences {

    static String[] FizzBuzz(int start, int end) {
        String f = "Fizz", b = "Buzz", fb = "FizzBuzz";
        String[] result = new String[end-start+1];
        int k = 0;
        for (int i=start; i<=end; i++){
            if (i%3==0 && i%5==0) result[k++] = fb;
            else if (i%3==0)  result[k++] = f;
            else if (i%5==0) result[k++] = b;
            else result[k++] = String.valueOf(i);
        }
        return result;
    }

    private static char[] chars = {'O','P','T','I','V','E','R'};
    private static int count = 0;
    static int countOptiverOccurrences(String[] characterGrid) {
        int m = characterGrid.length;
        int n = characterGrid[0].length();
        char[][] grid = new char[m][n];
        for (int i=0; i<m; i++){
            grid[i] = characterGrid[i].toCharArray();
        }
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j]=='O') search(grid, m, n, grid[i][j], i, j);
            }
        }
        return count;
    }
    private static void search(char[][] grid, int m, int n, char c, int i, int j){
        if (j+7<=n){ // ->
            for (int k=1; k<7; k++){
                if (grid[i][j+k]!=chars[k]) break;
                if (k==6) count++;
            }
        }
        if (i+7<=m) { //down
            for (int k=1; k<7; k++){
                if (grid[i+k][j]!=chars[k]) break;
                if (k==6) count++;
            }
        }
        if (j-7>=-1) { // <-
            for (int k=1; k<7; k++){
                if (grid[i][j-k]!=chars[k]) break;
                if (k==6) count++;
            }
        }
        if (i-7>=-1) { //up
            for (int k=1; k<7; k++){
                if (grid[i-k][j]!=chars[k]) break;
                if (k==6) count++;
            }
        }
    }




}
