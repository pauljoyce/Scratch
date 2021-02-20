package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 起两个线程，线程同时执行输出，结果保证顺序
 * @Author: mengchao
 * @Date: 2021/1/25 18:30
 */
public class TwoThreadOutput {
    private static volatile int flag = 0;
    private static volatile int integer = 0;
    //private static AtomicInteger integer = new AtomicInteger(0);

    private static final List<Integer> list = new ArrayList<>();
    static {
        for (int i = 0; i <= 100; i++) {
            list.add(i);
        }
    }

    private static List<Integer> synchronizedList = Collections.synchronizedList(list);
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        System.out.println();
    }

    /**
     * 使用同步代码实现
     */
    public static class MyThread implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                for (int i = 0; i < 50; i++) {
                    this.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "正在输出序号：" + integer++);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     *  使用Lock实现，基于CO
     */
    public static class MyThread1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                lock.lock();
                try {
                    condition.signalAll();
                    System.out.println(Thread.currentThread().getName() + "正在输出序号：" + integer++);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }finally {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.unlock();
                }
            }

        }
    }
}
