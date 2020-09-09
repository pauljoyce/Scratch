package proxy.cglibImpl;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 18:24
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public static Logger log = Logger.getLogger("MyMethodInterceptor.class");
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info("You said: " + Arrays.toString(args));
        return proxy.invokeSuper(obj, args);
    }
}
