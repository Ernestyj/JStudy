package eugene.reflect;

import org.junit.Test;

/**
 * Created by Jian on 2015/7/28.
 */
public class AppTest {
    @Test
    public void test() {
        String[] args = {};
        Clazz.main(args);
        Constructors.main(args);
        Fields.main(args);
        Methods.main(args);


        App.main(args);
    }
}
