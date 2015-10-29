package eugene.io.tools;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by DCLab on 10/26/2015.
 */
public class BytesInputFile {

    public static void main(String... args) {
        long start = System.nanoTime();
        String s = null;
        try {
            s = BytesInputFile.read(new File("src/main/resources/eugene/b.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long time = System.nanoTime() - start;
        System.out.println(s);
        System.out.printf("Took %.3f seconds to read a file with %,d bytes%n",
                time / 1e9, s.length());
    }

    public static String read(File file)  throws IOException{
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        byte[] bytes = new byte[(int) file.length()];
        in.readFully(bytes);
        in.close();
        return new String(bytes, StandardCharsets.UTF_8); // ASCII text only.
    }
}
