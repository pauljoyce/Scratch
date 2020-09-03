package Runtime;

/**
 * @Author: mengchao
 * @Date: 2020/8/28 09:57
 */
public class GetRuntimeTest {
    int a;
    public GetRuntimeTest(int a){
        this.a = a;
    }

    public static void main(String[] args) {
        GetRuntimeTest getRuntimeTest = new GetRuntimeTest(1);
        Runtime.getRuntime();
        System.out.println("X");
    }
}
