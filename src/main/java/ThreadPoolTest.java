import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池创建线程
 * @Author: mengchao
 * @Date: 2020/4/14 10:40
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = ((ThreadPoolExecutor) executorService);
        //适用于Runnable
        executorService.execute(new NumberThread1());
        executorService.execute(new NumberThread2());
//        executorService.submit(Callable callable);//适用于Callable
    }
}

class NumberThread1 implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(Thread.currentThread().getName()+"-------"+i);
        }
    }
}

class NumberThread2 implements  Runnable{
    @Override
    public void run() {
        for (int i = 200; i >100 ; i--) {
            System.out.println(Thread.currentThread().getName()+"-------"+i);
        }
    }
}