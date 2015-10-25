package eugene.examples.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，
 * 如此循环50次
 * Created by DCLab on 10/22/2015.
 */
public class ThreadExTwo {
    private static Lock lock = new ReentrantLock();
    private static Condition subThreadCondition = lock.newCondition();
    private static boolean shouldSub = true;

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++){
                    lock.lock();
                    try{
                        if (!shouldSub) subThreadCondition.await();
                        for (int j = 0; j < 10; j++)
                            System.out.println(Thread.currentThread().getName() + ", j=" + j);
                        shouldSub = false;
                        subThreadCondition.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        threadPool.shutdown();
        for (int i = 0; i < 50; i++){
            lock.lock();
            try{
                if (shouldSub) subThreadCondition.await();
                for (int j = 0; j < 100; j++)
                    System.out.println(Thread.currentThread().getName() + ", j=" + j);
                shouldSub = true;
                subThreadCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
