package LeetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.SneakyThrows;

/**
 * Volatile实现，会超时
 * @Author: mengchao
 * @Date: 2020/9/10 18:00
 */
public class LeetCode1115Volatile {
    static class FooBar {
        private int n;
        private volatile int flag=0;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag==1){
                    //让出cpu时间后，线程会由Running状态转为Ready状态，然后会立刻再次进入Running，之后又进入Ready无限循环，不过从输出上看线程是"暂停"的
                    //另一个线程改变flag后，线程再次进入Running后强制刷新flag的值，线程得以正常输出
                    Thread.yield();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = 1;
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                while (flag==0){
                    Thread.yield();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 0;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FooBar fooBar = new FooBar(5);

        executorService.submit(
                new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        fooBar.foo(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("foo");
                            }
                        });
                    }
                }
        );
        executorService.submit(
                new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        fooBar.bar(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("bar");
                            }
                        });
                    }
                }
        );
    }
}
