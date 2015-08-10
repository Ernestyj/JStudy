package eugene.enumerate;

/**枚举的高级应用(带方法的枚举)
 * Created by Jian on 2015/8/10.
 */
public enum Trafficlamp {
    //枚举元素必须位于枚举体中的最开始部分
    RED(30){
        @Override
        public Trafficlamp nextLamp() {
            return GREEN;
        }
    }, GREEN(45){
        @Override
        public Trafficlamp nextLamp() {
            return YELLOW;
        }
    }, YELLOW(5){
        @Override
        public Trafficlamp nextLamp() {
            return RED;
        }
    };
    private int time;
    private Trafficlamp(int time){
        this.time = time;
    }
    //实现抽象的next方法：每个元素分别是由枚举类的子类来生成的实例对象，这些子类采用类似内部类的方式进行定义
    abstract public Trafficlamp nextLamp();
}
