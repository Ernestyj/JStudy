package eugene.classloader;

import java.io.*;
import java.lang.*;
import java.lang.reflect.Method;

/**编写自己的类加载器（参考视频）
 * Created by Jian on 2015/8/11.
 */
public class MyClassLoader extends java.lang.ClassLoader{

    public static void main(String [] args) throws Exception {

        //下面省略了错误检查
        if(!args[0].endsWith("class")) {
            java.lang.ClassLoader loader = new MyClassLoader(args[1]);
            Class cls = loader.loadClass(args[0]);

			/*让自定义类继承Date类
			System.out.println(cls.getClassLoader().getClass().getName());
            java.util.Date d = (java.util.Date)cls.newInstance();
            System.out.println(d.toString());*/

            //Method m = cls.getMethod("test",null);//在jdk1.5中报警告，为什么？
            Method m = cls.getMethod("test");
            //m.invoke(cls.newInstance(),null);
            m.invoke(cls.newInstance());
            //((Test)cls.newInstance()).test();
            return;
        } else {
            FileInputStream fis = new FileInputStream(args[0]);
            File f = new File(args[1], new File(args[0]).getName());//不用检查目录最后是否有目录分割符
            FileOutputStream fos = new FileOutputStream(f);
            cypher(fis,fos);
            fis.close();
            fos.close();
        }
    }

    @Override
    protected Class<?> findClass(String name) //throws ClassNotFoundException //为什么不能抛出
    {
        try {
            File f = new File(path,name.substring(name.lastIndexOf('.')+1) + ".class");
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            cypher(fis,bos);
            byte [] buf = bos.toByteArray();
            fis.close();
            bos.close();
            return defineClass(name,buf,0,buf.length);
        }catch(Exception e) {
            try {
                throw new ClassNotFoundException(name + " is not found!");
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        return null;
//        return super.findClass(name);
    }

    private String path = null;
    public MyClassLoader(String path) throws Exception//检查文件是否存在
    {
        File f = new File(path);
        if(!f.isDirectory()) {
            throw new RuntimeException(path + " is not a directory");
        }
        this.path = path;
    }

    public static void cypher(InputStream istream, OutputStream ostream) throws Exception {
        //下面这段代码可能遇到255的字节，当成byte就成了-1
		/*byte b = 0;
		while((b = (byte)istream.read()) != -1)
		{
			ostream.write(b ^ 0xff);
		}*/
        int b = 0;
        while((b = istream.read()) != -1)
        {
            ostream.write(((byte)b) ^ 0xff);
        }
    }
}

//类加载器不能加载这种非public的类
/*Exception in thread "main" java.lang.IllegalAccessException: Class MyClassLoader
 can not access a member of class MyTest with modifiers ""*/
/*
class MyTest
{
	public void test()
	{
		System.out.println("hello,www.it315.org");
	}
}
*/

