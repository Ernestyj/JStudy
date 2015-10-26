package eugene;

import java.io.*;
import java.util.*;

/**
 * Created by Jian on 2015/7/28.
 */
public class App {
    public static void main(String[] args){
        System.out.println("A"+"B");
        System.out.println('A'+'B');
        System.out.println(10 | 7);

        mergeTest();
    }

    private static void mergeTest() {
        try {
            FileReader aFileReader = new FileReader(new File("src/main/resources/a.txt"));
            FileReader bFileReader = new FileReader(new File("src/main/resources/b.txt"));
            FileWriter cFileWriter = new FileWriter(new File("src/main/resources/c.txt"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
