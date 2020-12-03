package thread;

import java.util.concurrent.*;

public class CachedThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        FutureTask<Integer> result = new FutureTask<Integer>(new LiftOffCall());
        for (int i=0;i<5;i++){
            System.out.println("Waiting for launching");
            Future<Integer> integerFutureTask = executorService.submit(new LiftOffCall());
            System.out.println(integerFutureTask.get());
        }

    }
}
