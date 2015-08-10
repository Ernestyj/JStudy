package eugene.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
 * Created by Jian on 2015/8/10.
 */
public class SmallFramework {
    public static void main(String[] args) {
        try {
            //1. 建议用getRealPath()获取路径，且最好用完整路径（但不是硬编码的完整路径）
//            InputStream ips = new FileInputStream("configTest.properties");//这里的相对路径，是相对工程根目录
            //2. 另一种(更常用)方法是使用类加载器（直接使用类加载器时，不能以/打头）
//            InputStream ips = SmallFramework.class.getClassLoader()
//                    .getResourceAsStream("eugene/reflect/configTest.properties");//这里的相对路径，是相对class根目录
            //3. 再另一种方法，没有显式使用getClassLoader()，但实际上也是用了类加载器（可以/打头，即可以用class下的绝对路径）
            InputStream ips = SmallFramework.class
                    .getResourceAsStream("configTest.properties");//这里的相对路径，是相对SmallFramework.class所在目录

            Properties props = new Properties();
            props.load(ips);
            ips.close();

            String className = props.getProperty("className");
            Collection collection = (Collection) Class.forName(className).newInstance();
//            Collection collection = new HashSet();
            ReflectPoint pt1 = new ReflectPoint(3, 3);
            ReflectPoint pt2 = new ReflectPoint(5, 5);
            ReflectPoint pt3 = new ReflectPoint(3, 3);
            collection.add(pt1);
            collection.add(pt2);
            collection.add(pt3);
            collection.add(pt1);

            System.out.println(collection.size());//若不重载hashCode()则返回3，重写后返回2

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static class ReflectPoint{
        private int x;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReflectPoint that = (ReflectPoint) o;

            if (x != that.x) return false;
            if (y != that.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public int y;

        public ReflectPoint() {
        }

        public ReflectPoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {

            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
