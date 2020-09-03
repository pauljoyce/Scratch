package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 多线程共享变量测试
 * @Author: mengchao
 * @Date: 2020/8/31 13:44
 */
public class SharedFieldTest {
    public volatile static int num = 0;
    //public volatile static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(40);
        ThreadPoolExecutor service = ((ThreadPoolExecutor) executorService);
        ThreadA threadA = new ThreadA(1);
        executorService.execute(threadA);
        executorService.execute(threadA);
        executorService.execute(threadA);
        executorService.execute(threadA);
        executorService.execute(threadA);
        executorService.execute(threadA);
        executorService.execute(threadA);
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("main:"+num);
    }
}

/**
 * 原子Integer类，可以保证多线程中共享变量的安全
 */
//class ThreadA implements Runnable{
//    int i;
//    public ThreadA(int i){
//        this.i = i;
//    }
//    @Override
//    public void run() {
//        try{
//            Thread.sleep(100);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        CASTest.num.getAndAdd(1);
//        System.out.println(i+":"+CASTest.num);
//    }
//}

/**
 * 同步代码
 */
class ThreadA implements Runnable{
    int i;
    public ThreadA(int i){
        this.i = i;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //当锁住的对象是this，如果是同一个实例，就会按顺序访问，但是如果是不同实例，就可以同时访问
        //同一个实例比如executorService.execute(threadA);
        //        executorService.execute(threadA);
        //        executorService.execute(threadA);
        //不同实例比如 executorService.execute(new ThreadA(1));
        //           executorService.execute(new ThreadA(2));
        //           executorService.execute(new ThreadA(3));

        //当锁住的对象是class,则就会拦截所有线程，只能让一个线程访问。
        synchronized (this){
            SharedFieldTest.num ++;
        }
        System.out.println(i+":"+ SharedFieldTest.num);
    }
}

