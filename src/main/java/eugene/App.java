package eugene;

import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.util.*;

/**Implement atoi to convert a string to an integer.
 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 * Created by Jian on 2015/7/28.
 */
public class App {


    public static void main(String[] args) {
        System.out.println("*****RESULT*****");
        double x = 0.0;
        System.out.println(Math.abs(x)<0.00001);

        print(new int[]{1,2,3});
        f(1, 'C');
        //f('C','a'); 报错对f的引用不明确

//        ArrayList<String> list = new ArrayList<>();
//        Iterator<String> iterator = list.listIterator();
//        java.util.Collections collections;
        HashMap<String, String> map;
        Queue<String> queue = new LinkedList<>();
//        queue = Collections.unmodifiableCollection();

        System.out.println(Math.pow(4,15));

    }

    static void print(Object... args){
        for (Object o: args){
            System.out.print(o+" ");
        }
        System.out.println();
    }
    static void f(float a, Character... args){
        System.out.println(a);
    }
    static void f(char c, Character... args){
        System.out.println(c);
    }
    static void f(Character... args){

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
