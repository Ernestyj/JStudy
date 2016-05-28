package onlinealgo;

import java.util.Scanner;

/**
 * Created by eugene on 16/5/28.
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println("*****RESULT*****");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] strings = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i=0; i<n; i++){
            nums[i] = Integer.valueOf(strings[i]);
        }

        System.out.println(n);
        for (int i: nums)
            System.out.print(i+" ");
    }

    private static void read(){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(m + " " + n);
        in.nextLine();
        char[][] grids = new char[m][n];
        for (int i=0; i<m; i++){
            String line = in.nextLine();
            System.out.println(line);
            for (int j=0; j<n; j++){
                grids[i][j] = Character.valueOf(line.charAt(j));
            }
        }
        for (int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grids[i][j] + " ");
            }
            System.out.println();
        }
    }


}
