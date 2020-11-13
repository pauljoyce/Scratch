package proxy.nativeImpl;


import java.util.logging.Logger;

/**
 * Hello接口的静态代理
 * @Author: mengchao
 * @Date: 2020/9/7 16:39
 */
public class StaticProxyHello implements Hello{
    private Hello hello;

    public StaticProxyHello(Hello hello){
        this.hello = hello;
    }
    @Override
    public String sayHello(String string) {
        System.out.println("proxy syaHello");
        return hello.sayHello(string);
    }

    @Override
    public void addUser() {
        System.out.println("proxy addUser");
    }
}
