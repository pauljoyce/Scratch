package proxy.nativeImpl;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 16:39
 */
public class HelloImpl implements Hello{
    @Override
    public String sayHello(String string) {
        return "Impl:" + string;
    }
}
