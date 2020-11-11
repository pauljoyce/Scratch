import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型测试
 * @Author: mengchao
 * @Date: 2020/10/21 17:29
 */
public class GenericTest {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "2";
        List<String> list = testMethod3(s1, s2);
        System.out.println("");
    }

    public static <T> T testMethod(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static Object testMethod2(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static <T> List<T> testMethod3(T... param){
        return new ArrayList<>(Arrays.asList(param));
    }

    public static List<Object> testMethod4(List<?> list){
        String[] strings = {"x", "xx"};
        return new ArrayList<>(Arrays.asList(strings));
    }
}
