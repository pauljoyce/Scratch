/**
 * 单例模式
 * 单例的实现思路:
 * 1\静态化实例对象
 * 2\私有化构造方法，禁止通过构造方法创建实例
 * 3\提供一个公共的静态方法，用来返回唯一实例
 * @Author: mengchao
 * @Date: 2020/4/16 18:23
 */
//懒汉，线程不安全
public class Singleton {
    private static Singleton SINGLETON;

    private  Singleton() {

    }

    public static Singleton getInstance(){
        if (SINGLETON ==null){
            SINGLETON = new Singleton();
        }
        return SINGLETON;
    }

}

/**
 * 懒汉，线程安全，因为使用了同步方法
 * 问题:加锁之后会使得程序变成串行化，只有抢到锁的线程才能去执行这段代码块，这会使得系统的性能大大下降。
 */
class Singleton2{
    private static Singleton2 singleton2;
    private Singleton2(){

    }
    public  static synchronized Singleton2 getInstance(){
        if (singleton2==null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/**
 * 懒汉式，线程安全
 * 采用双检锁，提高执行性能
 * 不加volatile可能会因为指令重排序造成构造方法没有完成就返回实例（？？？），因此造成空指针问题
 */
class Singleton5{
    private static volatile Singleton5 singleton5;
    private Singleton5(){

    }
    public static Singleton5 getInstance(){
        //第一次判断，如果这里不为空，不进入抢锁阶段，直接返回实例
        if (singleton5==null){
            synchronized (Singleton.class){
                if (singleton5==null){
                    singleton5 = new Singleton5();
                }
                return singleton5;
            }
        }else {
            return singleton5;
        }
    }
}

/**
 * 饿汉
 * 类加载时就初始化，浪费内存。
 * 它基于 classloader类加载机制避免了多线程的同步问题
 * static变量在类加载的时候会加载一次,后面一直使用这个实例
 */
class Singleton3{
    private static Singleton3 SINGLETON3 = new Singleton3();
    private Singleton3(){

    }
    public static Singleton3 getInstance(){
        return SINGLETON3;
    }
}

class Singleton6{
    private static Singleton6 SINGLETON6 ;
    static {
        SINGLETON6 = new Singleton6();
    }
    private Singleton6(){

    }
    public static Singleton6 getInstance(){
        return SINGLETON6;
    }
}

/**
 * 静态内部类单例模式也称单例持有者模式，实例由内部类创建，由于 JVM 在加载外部类的过程中, 是不会加载静态内部类的,
 * 只有内部类的属性/方法被调用时才会被加载, 并初始化其静态属性。静态属性由static修饰，保证只被实例化一次，并且严格保证实例化顺序。
 * 静态内部类单例模式是一种优秀的单例模式，是开源项目中比较常用的一种单例模式。
 * 在没有加任何锁的情况下，保证了多线程下的安全，并且没有任何性能影响和空间的浪费。
 */
class SingletonObject7 {


    private SingletonObject7(){

    }
    // 单例持有者
    private static class InstanceHolder{
        private  final static SingletonObject7 instance = new SingletonObject7();

    }

    //
    public static SingletonObject7 getInstance(){
        // 调用内部类属性
        return InstanceHolder.instance;
    }
}

/**
 * 枚举类型:表示该类型的对象是有限的几个
 * 我们限定为一个，就成了单例
 * 枚举类型是线程安全的，并且只会装载一次，设计者充分的利用了枚举的这个特性来实现单例模式，枚举的写法非常简单，
 * 而且枚举类型是所用单例实现中唯一一种不会被破坏的单例实现模式。
 */
enum Singleton4{
    SINGLETON_4;
    public Singleton4 getSingleton4(){
        return SINGLETON_4;
    }
}
