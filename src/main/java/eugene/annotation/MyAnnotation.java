package eugene.annotation;

import eugene.enumerate.Trafficlamp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**自定义注解及其应用
 * @Retention 元注解,其三种取值：RetetionPolicy.SOURCE、RetetionPolicy.CLASS（默认）、RetetionPolicy.RUNTIME
 * 分别对应：java源文件-->class文件-->内存中的字节码
 * @Target 元注解：Target的默认值为任何元素，设置Target等于ElementType.METHOD，原来加在类上的注解就报错了，
 * 改为用数组方式设置{ElementType.METHOD,ElementType.TYPE}就可以了（TYPE范畴比Class更大，JDK1.5）
 * Created by Jian on 2015/8/10.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotation {
    //属性
    String color() default "yellow";
    //如果注解中有一个名称为value的属性，且你只想设置value属性（即其他属性都采用默认值或者你只有一个value属性），
    // 那么可以省略value=部分，例如：@MyAnnotation("lhm")
    String value() default "eugene";
    //数组属性，如果数组属性中只有一个元素，这时候属性值部分可以省略大括
    int[] arrayAttr() default {3, 4, 3};
    //枚举属性
    Trafficlamp lamp() default Trafficlamp.GREEN;
    //注解属性
    MetaAnnotation annotationAttr() default @MetaAnnotation("eugene");
}
