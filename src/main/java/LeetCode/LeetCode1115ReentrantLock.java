package LeetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import lombok.SneakyThrows;

/**
 * ReentrantLock实现
 * @Author: mengchao
 * @Date: 2020/9/10 19:01
 */
public class LeetCode1115ReentrantLock {
    static class FooBar {
        private ReentrantLock lock = new ReentrantLock();
        private Condition fooCondition = lock.newCondition();
        private Condition barCondition = lock.newCondition();
        private int flag = 0;
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    if (flag!=0){
                        fooCondition.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    barCondition.signal();
                    flag=1;
                }finally {
                    lock.unlock();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try{
                    if (flag!=1){
                        barCondition.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooCondition.signal();
                    flag=1;
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        LeetCode1115Volatile.FooBar fooBar = new LeetCode1115Volatile.FooBar(5);

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
