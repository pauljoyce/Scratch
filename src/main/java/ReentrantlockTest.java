import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: mengchao
 * @Date: 2020/4/13 17:38
 * 解决死锁问题的解决方案之lock
 * lock方案和synchronized方法有什么区别？
 * synchronize方法执行完同步代码后自动释放锁
 * lock需要手动启动lock和解锁
 */
public class ReentrantlockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("1");
        t2.setName("2");
        t3.setName("3");

        t1.start();
        t2.start();
        t3.start();

    }

}

class Window implements Runnable{
    private int ticket=50;
    private ReentrantLock lock = new ReentrantLock(false);
    @Override
    public void run() {
        try {
            lock.lock();
            while (true){
                if (ticket>0){
                    System.out.println(Thread.currentThread().getName() + "窗口售票，余票为：" + ticket);
                    ticket = ticket - 1;
                }else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
