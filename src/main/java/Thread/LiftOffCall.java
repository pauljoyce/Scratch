package Thread;

import java.util.concurrent.Callable;

/*
 * 一、创建执行线程的方式三：实现 Callable 接口。 相较于实现 Runnable 接口的方式，方法可以有返回值，并且可以抛出异常。
 *
 * 二、执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。  FutureTask 是  Future 接口的实现类
 */
public class LiftOffCall implements Callable<Integer> {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
//    public LiftOff() {
//
//    }
//    public LiftOff(int countDown){
//        this.countDown = countDown;
//
//    }
    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff") + ")";
    }

//    @Override
//    public void run() {
//        while (countDown-->0){
//            System.out.print(status());
//            Thread.yield();
//        }
//    }

    @Override
    public Integer call() throws Exception {
        while (countDown-->0){
            System.out.print(status());
            Thread.yield();
        }
        return 1;
    }
}
