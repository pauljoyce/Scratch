/**
 * @Author: mengchao
 * @Date: 2020/2/18 09:22
 */
public class StringTest {
    public static void main(String[] args) {

//        String s3 = "hello";
//        String s4 = "hello";
//        String s1 = new String("hello");
//        String s2 = new String("hello");
//
//        System.out.println(s1 == s2);
//        System.out.println(s3 == s4);
//        System.out.println(s1 == s3);
//        System.out.println();
        String str1 = new String("1");
        System.out.println(str1 == str1.intern());
        System.out.println(str1 == "1");

        String str2 = new String("2") + new String("3");
        System.out.println(str2 == str2.intern());
        System.out.println(str2 == "23");

        String str4="45";
        String str3 = new String("4") + new String("5");
        System.out.println(str3==str3.intern());
        System.out.println(str3 == "45");

    }
}
