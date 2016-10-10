package onlinealgo.microsoft1010;

import java.util.Scanner;

/**
 * Created by DCLab on 2016/10/10.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int odd = 0, even = 0;
        for (int i=1; i<=n; i++){
            if (isOdd(in.nextInt())) odd++;
            else even++;
        }
        System.out.println(Math.abs(odd-even));
    }

    private static boolean isOdd(int x) {
        return x%2==0 ? false : true;
    }


}
