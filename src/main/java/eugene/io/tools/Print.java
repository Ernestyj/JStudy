package eugene.io.tools;

import java.util.Collection;

/**
 * Created by DCLab on 10/28/2015.
 */
public final class Print {

    public static String format(Collection<?> c){
        if (c.size() == 0) return "[]";
        StringBuilder result = new StringBuilder("[");
        for (Object elem : c){
            if (c.size() != 1) result.append("\n   ");
            result.append(elem);
        }
        if (c.size() != 1) result.append("\n");
        result.append("]");
        return result.toString();
    }

    public static void print(Collection<?> c){
        System.out.println(format(c));
    }

    public static void print(Object[] c){
        System.out.println(format(java.util.Arrays.asList(c)));
    }
}
