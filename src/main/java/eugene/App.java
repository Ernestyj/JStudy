package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        System.out.println(secondsToFormatTime(3600));
    }


    public static String secondsToFormatTime(int seconds){
        int hour = seconds / 3600;
        int minute = seconds%3600 / 60;
        int second = seconds % 60;
        StringBuilder builder = new StringBuilder();
        String h = (hour/10 == 0) ? "0"+hour : String.valueOf(hour);
        String m = (minute/10 == 0) ? "0"+minute : String.valueOf(minute);
        String s = (second/10 == 0) ? "0"+second : String.valueOf(second);
        builder.append(h + ":" + m + ":" + s);
        return builder.toString();
    }



}