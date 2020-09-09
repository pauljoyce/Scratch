import java.util.Arrays;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2020/9/7 13:35
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "paul", "joyce");
        list.forEach(s -> System.out.println(s));
        list.forEach(System.out::println);

        Staff staff1 = new Staff(1);
        Staff staff2 = new Staff(2);
        Staff staff3 = new Staff(3);
        List<Staff> staffList = Arrays.asList(staff1, staff2, staff3);
        staffList.sort((s1,s2) -> s1.getId()-s2.getId());
    }
}
