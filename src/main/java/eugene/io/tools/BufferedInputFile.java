package eugene.io.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by DCLab on 10/26/2015.
 */
public class BufferedInputFile {

    public static void main(String[] args){
        try {
            System.out.println(BufferedInputFile.read("src/main/resources/eugene/b.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(String fileName) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;
        StringBuilder sBuilder = new StringBuilder();
        while ((s = in.readLine()) != null) sBuilder.append(s + "\n");
        in.close();
        return sBuilder.toString();
    }

}
