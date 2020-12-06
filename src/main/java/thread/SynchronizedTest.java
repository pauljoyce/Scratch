package thread;

/**
 * @Author: mengchao
 * @Date: 2020/12/6 15:43
 */
public class SynchronizedTest {

    static class Task implements Runnable{
        private static volatile int count = 0;
        @Override
        public void run() {
            synchronized (this){
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + ":" + (count++));
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(task, "t1");
        Thread t2 = new Thread(task, "t2");
        t1.start();
        t2.start();

    }
}
