package eugene.examples.thread;

/**子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，
 * 如此循环50次
 * Created by DCLab on 10/22/2015.
 */
public class ThreadEx{
    static int x, y;

    public static void main(String[] args){
        new ThreadEx().init();

    }

    private void init(){
        final Business business =new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 50; i++) business.subThread(i);
            }
        }).start();
        for(int i = 0; i < 50; i++) business.mainThread(i);
    }

    private class Business {
        boolean shouldSub = true;    //这里相当于定义了控制该谁执行的一个信号灯

        public synchronized void mainThread(int i){
            if(shouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j = 0; j < 100; j++)
                System.out.println(Thread.currentThread().getName() + ": i=" + i + ", j=" + j);
            shouldSub = true;
            this.notify();
        }

        public synchronized void subThread(int i){
            if (!shouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int j = 0; j < 10; j++)
                System.out.println(Thread.currentThread().getName() + ": i=" + i + ", j=" + j);
            shouldSub = false;
            this.notify();
        }
    }
}
