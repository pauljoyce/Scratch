package proxy.nativeImpl;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 17:30
 */
public class LogInvocationHandler implements InvocationHandler {
    private Hello hello;
    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("params:" + Arrays.toString(args));
        return method.invoke(hello, args);
    }
}
