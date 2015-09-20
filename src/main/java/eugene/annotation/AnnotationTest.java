package eugene.annotation;

import eugene.reflect.Arrays;

/**
 * Created by Jian on 2015/8/10.
 */
@MyAnnotation(color = "red", annotationAttr = @MetaAnnotation("ernest"))
public class AnnotationTest {
    public static void main(String[] args){
        if(AnnotationTest.class.isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = AnnotationTest.class.getAnnotation(MyAnnotation.class);
            System.out.println(annotation);
            System.out.println(annotation.color());
            System.out.println(annotation.value());
            System.out.println(annotation.arrayAttr().length);
            System.out.println(annotation.lamp().nextLamp());
            System.out.println(annotation.annotationAttr());
        }
    }
}
