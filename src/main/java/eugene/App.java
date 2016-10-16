package eugene;

import java.math.BigDecimal;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        double x = 0.0;
        System.out.println(Math.abs(x)<0.00001);

        print(new int[]{1, 2, 3});

        System.out.println(" ".split(" ").length);

        System.out.println(Double.compare(1.61-1.6, 0.01));
        System.out.println(new BigDecimal("1.61").subtract(new BigDecimal("1.6")).toString());

        System.out.println(Math.round(12F));//float 返回int, double 返回long

        byte a = 127, b = 127;
        //b = a + b; // error : cannot convert from int to byte
        b += a; // ok

        System.out.println((Integer)127 == (Integer)127);
        System.out.println((Integer)128 != (Integer)128);

    }

    private static void print(Object... args) {
        for (Object o: args) System.out.print(o+" ");
        System.out.println();
    }

}
