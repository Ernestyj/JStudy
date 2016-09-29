package onlinealgo;

import java.util.*;

/**未完成有错版本
 * Created by eugene on 16/4/8.
 */
public class SJF {

    public static void main(String[] args) {
        System.out.println("*****RESULT*****");

        int[] requestTimes = {0, 2, 4, 5};
        int[] durations = {7, 4, 1, 4};
        System.out.println(waitingTimeSJF(requestTimes, durations));
    }

    public static boolean solution(String S, String T) {
        return true;
    }

    static class MyTask {
        int request, duration;
        MyTask(int r, int d){
            request = r;
            duration = d;
        }
    }
    public static float waitingTimeSJF(int[] requestTimes, int[] durations) {
        ArrayList<MyTask> list = new ArrayList<>();
        //数据存入list,顺序是请求顺序
        for (int i=0; i<requestTimes.length; i++){
            list.add(new MyTask(requestTimes[i], durations[i]));
        }
        PriorityQueue<MyTask> queue = new PriorityQueue<>(new Comparator<MyTask>() {
            @Override
            public int compare(MyTask o1, MyTask o2) {
                if (o1.duration<o2.duration) return -1;
                else if(o1.duration>o2.duration) return 1;
                else return o1.request-o2.request;
            }
        });
        int timeStamp = 0;
        int totalWaitTime = 0;
        //维护timeStamp范围内的优先队列
        queue.offer(list.get(0));
        int index = 1;
        while (!queue.isEmpty()){
            MyTask cur = queue.poll();
            totalWaitTime += timeStamp-cur.request;
            timeStamp += cur.duration;
            while (index<list.size() && list.get(index).request<=timeStamp){
                queue.offer(list.get(index));
                index++;
            }
        }
        return (float)totalWaitTime/requestTimes.length;
    }

}
