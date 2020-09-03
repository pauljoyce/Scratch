import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现callable接口创建线程
 * @Author: mengchao
 * @Date: 2020/4/14 09:59
 */
public class ThreadCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread = new NumThread();
        FutureTask futureTask=new FutureTask<>(numThread);
        new Thread(futureTask).start();
        //get方法获取返回值
        System.out.println(futureTask.get());
    }
}

class NumThread implements Callable{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <100 ; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
