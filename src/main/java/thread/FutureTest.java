package thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 获取线程执行结果，非阻塞
 * @Author: mengchao
 * @Date: 2020/12/5 22:11
 */
public class FutureTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        ExecutorService watchService = Executors.newFixedThreadPool(5);
        List<String> list = Arrays.asList("this", "is", "a", "word");
        for (int i = 0; i < 5; i++) {
            Future<String> future= (Future<String>) service.submit(() -> {
                list.get(0);
            });
            watchService.submit(()->{
                while (!future.isDone()) {
                    System.out.println("waiting...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
        watchService.shutdown();
    }


}
