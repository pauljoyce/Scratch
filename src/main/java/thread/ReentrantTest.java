package thread;

/**
 * @Author: mengchao
 * @Date: 2020/8/31 16:23
 */
public class ReentrantTest {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB(1);
        Thread thread1 = new Thread(threadB);
        ThreadB threadC = new ThreadB(2);
        Thread thread2 = new Thread(threadC);
        thread1.start();
        //thread2.start();
    }

}
class ThreadB implements Runnable{
    int i;
    public ThreadB(int i){
        this.i=i;
    }

    @Override
    public void run() {
        synchronized (this){
            System.out.println(i+":run()"+Thread.currentThread().getName());
            test();
        }
    }

    public synchronized void test(){
        System.out.println(i+"test()"+Thread.currentThread().getName());
    }
}
