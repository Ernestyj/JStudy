package eugene.reflect;

import java.util.Objects;

/**数组的反射
 * 具有相同维数和元素类型的数组属于同一个类型
 * Created by Jian on 2015/8/10.
 */
public class Arrays {
    public static void main(String[] args){
        int[] a1 = new int[3];
        int[] a2 = new int[4];
        int[][] a3 = new int[2][3];
        String[] a4 = new String[]{"a", "b", "c"};
        System.out.println(a1.getClass().getName());
        System.out.println(a4.getClass().getName());
        System.out.println(a1.getClass().getSuperclass());
        System.out.println(a4.getClass().getSuperclass());
        //具有相同维数和元素类型的数组属于同一个类型
        System.out.println(a1.getClass() == a2.getClass());
        //下面两种不能进行==比较
//        System.out.println(a1.getClass() == a3.getClass());
//        System.out.println(a1.getClass() == a4.getClass());
        System.out.println();

        //1 基本类型的一维数组可以被当作Object类型使用，不能当作Object[]类型使用
        //2 非基本类型的一维数组，既可以当做Object类型使用，又可以当做Object[]类型使用
        Object obj1 = a1;
        Object obj2 = a4;
        //Object[] obj3 = a1;
        Object[] obj4 = a3;
        Object[] obj5 = a4;
        System.out.println(a1);//[I@549d1e83
        System.out.println(a4);//[Ljava.lang.String;@173e55db
        //Arrays.asList()方法处理int[]和String[]时的差异
        System.out.println(java.util.Arrays.asList(a1));//[[I@549d1e83]
        System.out.println(java.util.Arrays.asList(a4));//[a, b, c]
        System.out.println();

    }
}
