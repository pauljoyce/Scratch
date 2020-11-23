package threadlocal;

import net.sf.cglib.core.Local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: mengchao
 * @Date: 2020/11/23 17:52
 */
public class ThreadLocalTest {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        LocalThread localThread = new LocalThread();
        Thread thread1 = new Thread(localThread);
        Thread thread2 = new Thread(localThread);
        Thread thread3 = new Thread(localThread);
        thread1.setName("t1");
        thread2.setName("t2");
        thread3.setName("t3");

        thread1.start();
        thread2.start();
        thread3.start();


        System.out.println("---------------------------------------");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());

    }

    static class LocalThread implements Runnable{
        @Override
        public void run() {
            threadLocal.set("Threadlocal String:" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            System.out.println("x");
        }
    }
}
