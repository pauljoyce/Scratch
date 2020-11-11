/**
 * RuntimeException的捕获测试
 * 结论：可以捕获，不过一般来说不会去捕获，因为RuntimeException比如空指针异常、数组越界异常都是可以在代码里处理的，
 * 而CheckedException比如IOException无法在代码中处理只能捕获异常
 * @Author: mengchao
 * @Date: 2020/11/6 10:13
 */
public class ExceptionTest {
    public static void main(String[] args) {
        String s = null;
        s = getString();
        System.out.println(s.length());
        try{
            System.out.println(s.length());
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    private static String getString(){
        return null;
    }

}
