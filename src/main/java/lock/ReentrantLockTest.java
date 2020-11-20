package lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: mengchao
 * @Date: 2020/11/20 19:09
 */
public class ReentrantLockTest {
    //公平锁
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {

    }

    public static void testMethod(){
        reentrantLock.lock();
        try {

        }catch (Exception e){

        }finally {
            reentrantLock.unlock();
        }
    }
}
