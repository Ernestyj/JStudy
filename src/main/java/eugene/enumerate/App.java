package eugene.enumerate;

import java.util.Date;

public class App {
    public static void main(String[] args){
        WeekDayClass weekDayClass = WeekDayClass.MON;
        System.out.println(weekDayClass.nextDay());

        WeekDayAbsClass weekDayAbs = WeekDayAbsClass.SUN;
        System.out.println(weekDayAbs.nextDay());

        WeekDay weekDay = WeekDay.FRI;
        System.out.println(weekDay);
        System.out.println(weekDay.name());
        System.out.println(weekDay.ordinal());
        System.out.println(WeekDay.valueOf("THU"));
        System.out.println(WeekDay.values().length);
        System.out.println(weekDay.getDeclaringClass());

        new Date(300){};
        Trafficlamp lamp = Trafficlamp.GREEN;
    }
}
