package proxy.nativeImpl;


import java.util.logging.Logger;

/**
 * Hello接口的静态代理
 * @Author: mengchao
 * @Date: 2020/9/7 16:39
 */
public class StaticProxyHello implements Hello{
    public static Logger log = Logger.getLogger("StaticProxyHello.class");
    @Override
    public String sayHello(String string) {
        log.info("You said:" + string);
        return "static proxy:" + string;
    }
}
