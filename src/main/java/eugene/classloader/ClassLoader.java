package eugene.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by Jian on 2015/8/11.
 */
public class ClassLoader {
    public static void main(String[] args){
        System.out.println(sun.misc.Launcher.getLauncher().getClassLoader());//sun.misc.Launcher$AppClassLoader@5cad8086
        System.out.println();

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i=0; i<urls.length; i++) System.out.println(urls[i].toExternalForm());
        System.out.println();

        java.lang.ClassLoader loader = ClassLoader.class.getClassLoader();
        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@366412da
        System.out.println(loader.getClass());//class sun.misc.Launcher$AppClassLoader
        System.out.println(loader.getClass().getName());//sun.misc.Launcher$AppClassLoader
        System.out.println();

        //BootStrap加载器，不是一个类
        System.out.println(String.class.getClassLoader());//null
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
