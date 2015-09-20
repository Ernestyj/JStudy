package eugene.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**Constructor类代表某个类中的一个构造方法
 * Created by Jian on 2015/8/10.
 */
public class Constructors {
    public static void main(String[] args){
        try {
            Constructor[] constructors = String.class.getConstructors();
            for (Constructor cons : constructors) System.out.println(cons.toString());
            System.out.println();

            Constructor constructor = Class.forName("java.lang.String")
                    .getConstructor(StringBuffer.class);
            System.out.println(constructor);
            System.out.println();

            String s = (String) constructor.newInstance(new StringBuffer("abc"));
            System.out.println(s);
            System.out.println();

            //该方法内部先得到默认的构造方法，然后用该构造方法创建实例对象
            s = String.class.newInstance();
            System.out.println("s.length : " + s.length());
            System.out.println();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println();

    }
}
