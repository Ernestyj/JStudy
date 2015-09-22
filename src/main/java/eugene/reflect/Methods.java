package eugene.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**Method类代表某个类中的一个成员方法
 * Created by Jian on 2015/8/10.
 */
public class Methods {
    public static void main(String[] args){
        try {
//            String s = "abc";
//            Method charAt = String.class.getMethod("charAt", int.class);
//            System.out.println("Normal call: " + s.charAt(2));
//            System.out.println("Reflect call: " + charAt.invoke(s, 2));
//            System.out.println();

            //main方法反射调用（对接收数组参数的成员方法进行反射）
            Method mainMethod = Class.forName("eugene.eugene.reflect.App").getMethod("main", String[].class);
            //如果传递给Method对象的invoke()方法的第一个参数为null，说明该Method对象对应的是一个静态方法
            //javac只把它当作jdk1.4的语法进行理解，而不把它当作jdk1.5的语法解释，传入的String数组会被解包成一个一个元素，因此会出现参数类型不对的问题
//            mainMethod.invoke(null, new String[]{"11", "22"});//这里是错误的调用方式，IllegalArgumentException
            mainMethod.invoke(null, (Object)new String[]{"11", "22"});//打包成Object，告诉编译器不要拆
            System.out.println("另一种传参方式：");
            mainMethod.invoke(null, new Object[]{new String[]{"11", "22"}});//另一种传参方式
           // Object[] 与String[]没有父子关系，Object与String有父子关系
            mainMethod.invoke(null, (Object)(new Object[]{"11","22"}));//IllegalArgumentException，

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
