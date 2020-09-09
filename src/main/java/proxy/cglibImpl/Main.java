package proxy.cglibImpl;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 18:26
 */
public class Main {
    public static void main(String[] args) {
        //需要使用HelloConcrete的时候，通过CGLIB动态代理获取代理对象。
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloConcrete hello = (HelloConcrete)enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}
