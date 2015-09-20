package eugene.enumerate;

/**枚举的高级应用(带构造方法的枚举)
 * 1. 枚举元素必须位于枚举体中的最开始部分，枚举元素列表的后要有分号与其他成员分隔
 * 2. 带构造方法的枚举
 • 构造方法必须定义成私有的
 • 如果有多个构造方法，该如何选择哪个构造方法？
 • 枚举元素MON和MON（）的效果一样，都是调用默认的构造方法。
 • 3. 带方法的枚举
 • 定义枚举TrafficLamp
 • 实现普通的next方法
 • 实现抽象的next方法：每个元素分别是由枚举类的子类来生成的实例对象，这些子类采用类似内部类的方式进行定义。
 • 增加上表示时间的构造方法
 * 4. 枚举只有一个成员时，就可以作为一种单例的实现方式
 *
 * Created by Jian on 2015/8/10.
 */
public enum WeekDay {
    //枚举元素必须位于枚举体中的最开始部分
    SUN(1), MON(), TUE(), WEN, THU, FRI, SAT;

    //构造方法必须定义成私有的
    //枚举元素MON和MON（）的效果一样，都是调用默认的构造方法
    private WeekDay(){ System.out.println("1st constructor"); };
    private WeekDay(int day){ System.out.println("2nd constructor"); };
}
