package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {

    public static void main(String[] args){
        System.out.println("*****RESULT*****");

        System.out.println(Integer.valueOf('1'));
    }
    private void test(){
        System.out.println(super.getClass().getSuperclass());
    }

    public void App(){}
    App(){}

}