package string;

/**
 * @Author: mengchao
 * @Date: 2020/11/26 11:47
 */
public class refTest {
    public static void main(String[] args) {
        String a = "hello";
        String b = "hello";
//        String a = new String("hello");
//        String b = new String("hello");
        //结果为true，因为通过这种方式创建的字符串是字面量，会被加入字符串常量池，引用的是常量池里的同一个地址
        //如果改为new String的方式，结果为false，虽然引用的是字符串常量池里的同一个地址，但是为两个引用分别创建了String对象
        System.out.println(a == b);
    }
}
