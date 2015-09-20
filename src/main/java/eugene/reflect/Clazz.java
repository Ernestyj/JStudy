package eugene.reflect;

import java.util.Date;

/**Class解析
 * Created by Jian on 2015/8/10.
 */
public class Clazz {

    public static void main(String[] args){
        Person person1 = new Person();

        //获取Class的方式1
        Class cls1 = Date.class;
        //获取Class的方式2
        Class cls2 = person1.getClass();
        //获取Class的方式3
        try {
            Class cls3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String s = "abc";
        Class clazz1 = s.getClass();
        Class clazz2 = String.class;
        Class clazz3 = null;
        try {
            clazz3 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("clazz1.getName : " + clazz1.getName());//T
        System.out.println("clazz1 == clazz2 : " + (clazz1 == clazz2));//T
        System.out.println("clazz3 == clazz2 : " + (clazz3 == clazz2));//T
        System.out.println();

        System.out.println("clazz1.isPrimitive : " + clazz1.isPrimitive());//F
        System.out.println("int.class.isPrimitive : " + int.class.isPrimitive());//T
        System.out.println("int[].class.isPrimitive : " + int[].class.isPrimitive());//F
        System.out.println("int[].class.isArray : " + int[].class.isArray());//T
        System.out.println();


        System.out.println("int.class == Integer.class : " + (int.class == Integer.class));//F
        System.out.println("int.class == Integer.TYPE : " + (int.class == Integer.TYPE));//T
        System.out.println();
    }

    public static class Person{
        private String name;
        private int age;

        private Person() {
        }

        private Person(String name, int age) {

            this.name = name;
            this.age = age;
        }
    }
}
