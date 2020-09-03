import sun.awt.windows.ThemeReader;

/**
 * 线程通信
 * @Author: mengchao
 * @Date: 2020/4/13 18:00
 */
public class ThreadComm {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);
        Thread t3 = new Thread(number);
        t1.setName("1");
        t2.setName("2");
        t3.setName("3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Number implements Runnable{

    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notifyAll();
                if (number<=60){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程打印的是："+number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
