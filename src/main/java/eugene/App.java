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
        LinkedList<String> queue = new LinkedList<>();
//        queue = Collections.unmodifiableCollection();
        ArrayDeque q = new ArrayDeque();
        //q.add(null);
        queue.add(null);

        System.out.println(3*0.1);
        System.out.println(new Double(3*0.1).compareTo(0.3));

    }

    private static void print(Object... args) {
        for (Object o: args) System.out.print(o+" ");
        System.out.println();
    }

    static void f(float a, Character... args){
        System.out.println(a);
    }
    static void f(char c, Character... args){
        System.out.println(c);
    }
    static void f(Character... args){ }

}
class A extends Object{}
