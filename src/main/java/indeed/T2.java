package indeed;

import java.util.*;

/**
 * Created by eugene on 16/7/9.
 */
public class T2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
        //String res = runner(3, 7, 5);
        String res = runner(a, b, k);
        System.out.println(res);
    }

    static class RunTime{
        double time;
        String name;
        public RunTime(double time, String name) {
            this.time = time;
            this.name = name;
        }
    }

    private static final String S1 = "Takahashi", S2 = "Aoki";
    public static String runner(long A, long B, long K){
        ArrayList<RunTime> list = new ArrayList<>();
        HashMap<Double, String> map = new HashMap<>();
        if ((B+0.5)/A>K) return S1;
        else if(A/(B+0.5)>K) return S2;
        for (long i=1; i<=K; i++){
            list.add(new RunTime((double)i*A, S1));
            list.add(new RunTime(i*B+0.5, S2));
        }
        Collections.sort(list, new Comparator<RunTime>() {
            @Override
            public int compare(RunTime o1, RunTime o2) {
                return Double.compare(o1.time, o2.time);
            }
        });
        return list.get((int)(K-1)).name;
    }

}
