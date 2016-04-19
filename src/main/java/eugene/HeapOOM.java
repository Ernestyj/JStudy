package eugene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene on 16/4/18.
 */
public class HeapOOM {

    static class OOMObject {
        
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
