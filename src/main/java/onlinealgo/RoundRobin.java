package onlinealgo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by DCLab on 2016/9/29.
 */
public class RoundRobin {

    static class Process{
        public int excuteTime;
        public int arriveTime;
        Process( int arrTime, int excTime ){
            this.excuteTime = excTime;
            this.arriveTime = arrTime;
        }
    }

    public static float waitingTimeRobin(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)	return 0;
        int length = Atime.length;
        // process q
        Queue<Process> queue = new LinkedList<>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                // fetch current queue
                Process cur = queue.poll();
                waitTime += curTime - cur.arriveTime;
                curTime += Math.min(cur.excuteTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new Process(Atime[index], Etime[index]));
                if (cur.excuteTime > q)
                    queue.offer(new Process(curTime, cur.excuteTime - q));
            }else{
                queue.offer(new Process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }

    public static void main(String[] args) {
        int[] arrival1 = {0, 1, 4};
        int[] run1 = {5, 2, 3};
        int q1 = 3;
        int[] arrival2 = {0, 1, 3, 9};
        int[] run2 = {2, 1, 7, 5};
        int q2 = 2;
        System.out.print(waitingTimeRobin(arrival2, run2, q2));
    }
}
