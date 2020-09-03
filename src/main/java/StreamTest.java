import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: mengchao
 * @Date: 2019-05-09 14:51
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        List<String> filtedList = list.stream().filter(string -> string.endsWith("d")).collect(Collectors.toList());
        System.out.println(filtedList);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello");

    }
}
