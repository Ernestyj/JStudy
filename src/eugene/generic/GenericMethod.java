package eugene.generic;

import java.util.Collection;

/**
 * Created by Jian on 2015/8/11.
 */
public class GenericMethod {
    public static void main(String[] args){

        Object obj = "abc";
        String s1 = autoConvert(obj);



        System.out.println();
    }

    public static <T> T autoConvert(Object o){
        return (T)o;
    }

    public static <T> void fillArray(T[] a, T obj){
        for(int i = 0; i < a.length; i++) a[i] = obj;
    }

    //此例若用通配符?实现，则函数体中不能使用collection.add()方法
    public static <T> void printCollection(Collection<T> collection){
        System.out.println(collection.size());
        for(Object obj : collection) System.out.println(obj);

    }

    private static <T> T add(T x, T y){
//        return x + y;//无法实现相加
        return null;
    }
}
