package eugene.classloader;

/**
 * Created by Jian on 2015/8/11.
 */
public class ClassLoader {
    public static void main(String[] args){
        java.lang.ClassLoader loader = ClassLoader.class.getClassLoader();

        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@366412da
        System.out.println(loader.getClass());//class sun.misc.Launcher$AppClassLoader
        System.out.println(loader.getClass().getName());//sun.misc.Launcher$AppClassLoader
        System.out.println();

        //BootStrap加载器，不是一个类
        System.out.println(System.class.getClassLoader());//null
        System.out.println();

        //打印类加载器（子->父）
        while (loader != null){
            System.out.println(loader.getClass().getName());
            loader = loader.getParent();
        }
        System.out.println(loader);//null(BootStrap加载器)
        System.out.println();

    }
}
