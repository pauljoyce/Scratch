package DesignPattern.Singleton;
/*
1、饿汉式：在程序启动或单件模式类被加载的时候，单件模式实例就已经被创建。
2、懒汉式：当程序第一次访问单件模式实例时才进行创建。
如何选择：如果单件模式实例在系统中经常会被用到，饿汉式是一个不错的选择。
    反之如果单件模式在系统中会很少用到或者几乎不会用到，那么懒汉式是一个不错的选择。
 */
public class Singleton {
    //懒汉式，第一次访问单例模式时才会创建Singleton实例
    private static Singleton singleton;

    //构造器用private修饰，只能通过getInstance方法来获取实例
    private Singleton(){}

    //getInstance()的返回值是一个对象的引用，
    // 并不是一个新的实例，所以不要错误的理解成多个对象
    // 加了synchronized关键字，保证线程安全
    public static synchronized Singleton getInstance(){
        if (singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }
}


//public class Singleton {
//    //饿汉式，类被加载时就创建Singleton实例
//    private static Singleton singleton=new Singleton();
//
//    //构造器用private修饰，只能通过getInstance方法来获取实例
//    private Singleton(){}
//
//    //getInstance()的返回值是一个对象的引用，
//    // 并不是一个新的实例，所以不要错误的理解成多个对象
//    // 加了synchronized关键字，保证线程安全
//    public static synchronized Singleton getInstance(){
//        return singleton;
//    }
//}

//// 枚举，不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
//public enum Singleton {
//    INSTANCE;
//    public void whateverMethod() {
//        System.out.println("Singleton");
//    }
//}