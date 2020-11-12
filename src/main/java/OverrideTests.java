/**
 * @Author: mengchao
 * @Date: 2020/11/12 10:19
 */
public class OverrideTests {
    static class Father{
        void method(){
            System.out.println("father");
        }
    }
    static class Child extends Father{
        @Override
        void method(){
            System.out.println("child");
        }
    }

    public static void main(String[] args) {
        Father a = new Child();
        a.method();
    }
}
