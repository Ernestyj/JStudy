package eugene;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by eugene on 16/7/11.
 */
public class CallPython {

    private static final String PY_PATH = "/Users/eugene/anaconda/bin/python";
    private static final String PY_FILE_PATH = "/Users/eugene/ProgramData/PyStudy/finance/module/Days.py";
    private static final String BASE_PATH = "/Users/eugene/Downloads/data/";
    private static final String INSTRUMENT = "000300.SH";
    private static final long INIT_CAPITAL = 100000000;
    private static final int START_YEAR = 2014;
    private static final int YEAR_NUM = 2;
    private static final int WIN_DAYS = 15;
    private static final int WIN = 9;


    public static void main(String[] args) {
        try {
            System.out.println("start");
//            System.out.println(PY_PATH+" "+PY_FILE_PATH
//                    +" "+BASE_PATH+" "+INSTRUMENT+" "+INIT_CAPITAL+" "+START_YEAR+" "+YEAR_NUM+" "+WIN_DAYS+" "+WIN);
            Process p = Runtime.getRuntime().exec(PY_PATH+" "+PY_FILE_PATH
                +" "+BASE_PATH+" "+INSTRUMENT+" "+INIT_CAPITAL+" "+START_YEAR+" "+YEAR_NUM+" "+WIN_DAYS+" "+WIN);

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            in.close();
            System.out.println(p.exitValue());
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
