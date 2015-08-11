package eugene.generic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Vector;

/**
 * Created by Jian on 2015/8/11.
 */
public class GenericReflect {
    public static void main(String[] args){
        try {
            Method applyMethod = GenericReflect.class.getMethod("applyVector", Vector.class);
            Type[] types = applyMethod.getGenericParameterTypes();
            ParameterizedType pType = (ParameterizedType) types[0];
            System.out.println("pType.getRawType: " + pType.getRawType());
            System.out.println("pType.getActualTypeArguments: " + pType.getActualTypeArguments());
            System.out.println("pType.getActualTypeArguments()[0]: " + pType.getActualTypeArguments()[0]);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void applyVector(Vector<Date> v){
    }
    //下面的方法与上面的方法不能同时定义
//    public static void applyVector(Vector<String> v){
//    }
}
