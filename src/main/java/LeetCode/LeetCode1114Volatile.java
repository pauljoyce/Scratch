package LeetCode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1114. 按序打印
 * 使用volatile变量控制
 * @Author: mengchao
 * @Date: 2020/9/9 23:24
 */
public class LeetCode1114Volatile {
    static class Foo {
        private volatile int flag = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 1;
        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (flag!=1){
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 2;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (flag!=2){
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }

    }
    //使用原子变量实现
//    static class Foo {
//        private AtomicInteger flag = new AtomicInteger(0);
//
//        public Foo() {
//
//        }
//
//        public void first(Runnable printFirst) throws InterruptedException {
//
//            // printFirst.run() outputs "first". Do not change or remove this line.
//            printFirst.run();
//            flag.set(1);
//        }
//
//        public void second(Runnable printSecond) throws InterruptedException {
//            while (flag.get() !=1){
//            }
//            // printSecond.run() outputs "second". Do not change or remove this line.
//            printSecond.run();
//            flag.set(2);
//        }
//
//        public void third(Runnable printThird) throws InterruptedException {
//            while (flag.get() !=2){
//            }
//            // printThird.run() outputs "third". Do not change or remove this line.
//            printThird.run();
//        }
//
//    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //匿名内部类写法
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("first");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //lambda表达式写法
        executorService.submit(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(()->{
            try {
                foo.third(()->System.out.print("third"));
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
