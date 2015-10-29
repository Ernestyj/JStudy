package eugene.io.tools;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by DCLab on 10/26/2015.
 */
public class MemoryInputString {

    public static void main(String... args) {
        try {
            StringReader in = new StringReader(BufferedInputFile.read("src/main/resources/eugene/b.txt"));
            int c;
            while ((c = in.read()) != -1) System.out.print((char)c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
