import static java.lang.Thread.sleep;

public class ThreadDemo implements Runnable{
    private int count=10;
    private String name;


    public ThreadDemo(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo1 = new ThreadDemo("Thread1");
        ThreadDemo threadDemo2 = new ThreadDemo("Thread2");
        new Thread(threadDemo1).start();
        new Thread(threadDemo1).start();
    }
    @Override
    public void run() {
        synchronized (this){
            while (count>0){
                count--;
                System.out.println("Saled by" + Thread.currentThread() + "count left:" + count);
            }
        }
    }
}
