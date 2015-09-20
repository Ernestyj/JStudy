package eugene.reflect;

import java.lang.reflect.Field;

/**• Field类代表某个类中的一个成员变量
 * Created by Jian on 2015/8/10.
 */
public class Fields {
    public static void main(String[] args){
        ReflectPoint point = new ReflectPoint(3, 5);
        Field fieldX = null;
        Field fieldY = null;
        try {
//            fieldX = point.getClass().getField("x");//私有变量获取会失败
            fieldX = point.getClass().getDeclaredField("x");
            fieldX.setAccessible(true);
            System.out.println("fieldX.get(point) : " + fieldX.get(point));
            fieldY = point.getClass().getField("y");
            System.out.println("fieldY.get(point) : " + fieldY.get(point));
            System.out.println();

            Field[] fields = point.getClass().getDeclaredFields();
            for (Field f : fields){
                f.setAccessible(true);
                System.out.println(f.get(point) + " : " + f.getType());
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static class ReflectPoint{
        private int x;
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
