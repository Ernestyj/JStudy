package eugene.enumerate;

/**Class模拟枚举
 * 用普通类如何实现枚举功能，定义一个Weekday的类来模拟枚举功能。
 • 私有的构造方法
 • 每个元素分别用一个公有的静态成员变量表示
 • 可以有若干公有方法或抽象方法。采用抽象方法定义nextDay就将大量的if.else语句转移成了一个个独立的类。
 * Created by Jian on 2015/8/10.
 */

public class WeekDayClass {
    //构造方法是私有的
    private WeekDayClass(){};

    //每个元素分别用一个公有的静态成员变量表示
    public final static WeekDayClass SUN = new WeekDayClass();
    public final static WeekDayClass MON = new WeekDayClass();

    //可以有若干公有方法或抽象方法
    public WeekDayClass nextDay(){
        if(this == SUN) return MON;
        else return SUN;
    }

    @Override
    public String toString() {
        return this == SUN ? "SUN" : "MON";
    }
}
