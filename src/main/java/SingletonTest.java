import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: mengchao
 * @Date: 2020/4/17 09:31
 */
public class SingletonTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Singleton> c = new Callable<Singleton>() {
            @Override
            public Singleton call() throws Exception {
                return Singleton.getInstance();
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Singleton> f1 = executorService.submit(c);
        Future<Singleton> f2 = executorService.submit(c);

        Singleton s1 = f1.get();
        Singleton s2 = f2.get();

        System.out.println(s1);
        System.out.println(s2);

    }
}


