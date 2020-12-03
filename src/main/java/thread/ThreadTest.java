package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: mengchao
 * @Date: 2020/12/3 10:22
 */
public class ThreadTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            executorService.submit(
                    () -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("child thread");
                    }
            );
            System.out.println("sleeping...");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
