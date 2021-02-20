import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @Author: mengchao
 * @Date: 2021/1/8 14:44
 * Thrown when an application attempts to use null in a case where an object is required. These include:
 * Calling the instance method of a null object.
 * Accessing or modifying the field of a null object.
 * Taking the length of null as if it were an array.
 * Accessing or modifying the slots of null as if it were an array.
 * Throwing null as if it were a Throwable value.
 *
 *
 * 在空对象上调用实例方法。对空对象调用静态方法或类方法时，不会报 NPE，因为静态方法不需要实例来调用任何方法；
 * 访问或更改空对象上的任何变量或字段时；
 * 抛出异常时抛出 null；
 * 数组为 null 时，访问数组长度；
 * 数组为 null 时，访问或更改数组的插槽；
 * 对空对象进行同步或在同步块内使用 null。
 */
public class NullPointerTest {
    public static void main(String[] args) {
        String s=getString();
//        s.equals("ss");//nullPointer
//        "ss".equals(s);//OK
//        Integer.valueOf(s);//nullPointer
        String[] strings;
        strings = getStrings();
//        int a=strings.length;//nullPointer
        //使用Optional避免空指针
        Optional.ofNullable(s).map(String::toString).ifPresent(System.out::println);

    }

    static String getString(){
        return null;
    }
    static String[] getStrings(){
        return null;
    }
}
