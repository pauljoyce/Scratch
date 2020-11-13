package proxy.nativeImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 17:15
 */
public class Main {
    public static void main(String[] args) {
        //静态代理
        Hello hello1 = new HelloImpl();
        Hello proxyHello = new StaticProxyHello(hello1);
        System.out.println(proxyHello.sayHello("hhh"));

        //JDK动态代理
        Hello hello = (Hello) Proxy.newProxyInstance(
                // 1. 类加载器
                HelloImpl.class.getClassLoader(),
                // 2. 代理需要实现的接口，可以有多个
                new Class<?>[] {Hello.class},
                // 3. 方法调用的实际处理者
                new LogInvocationHandler(new HelloImpl()));
        System.out.println(hello.sayHello("love"));
        hello.addUser();
    }
}
