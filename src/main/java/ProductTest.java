import sun.awt.windows.ThemeReader;

/**
 * @Author: mengchao
 * @Date: 2020/4/14 09:28
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.setName("producer");
        consumerThread.setName("consumer");

        producerThread.start();
        consumerThread.start();
    }
}

class Clerk{
    private int productCount;
    public synchronized void produceProduct() throws InterruptedException {
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"线程开始生产第"+productCount+"个商品");
            notify();
        }else {
            wait();
        }
    }

    public synchronized void consumeProduct() throws InterruptedException {
        if (productCount>0){
            System.out.println(Thread.currentThread().getName()+"线程开始消费第"+productCount+"个商品");
            productCount--;
            notify();
        }else {
            wait();
        }
    }

}

class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.produceProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                clerk.consumeProduct();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
