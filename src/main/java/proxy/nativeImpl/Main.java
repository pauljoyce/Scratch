package proxy.nativeImpl;

import java.lang.reflect.Proxy;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 17:15
 */
public class Main {
    public static void main(String[] args) {
        //在需要使用Hello的时候，通过JDK动态代理获取Hello的代理对象。
        Hello hello = (Hello) Proxy.newProxyInstance(
                HelloImpl.class.getClassLoader(), // 1. 类加载器
                new Class<?>[] {Hello.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new HelloImpl()));// 3. 方法调用的实际处理者
        System.out.println(hello.sayHello("love"));
    }
}
