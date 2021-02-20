package dailyTests;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2021/1/25 14:22
 */
public class ListContainsTest {
    private static boolean containsStructure(List<String> list, String... string){
        if (string.length==0){
            return false;
        }else {
            for (String s:string
                 ) {
                if (list.contains(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "左上肢", "左侧上肢","双上肢前臂肌群","双上肢上臂肌群","双上肢","上肢","左侧肢体","四肢","肢体",
                "双侧肢体","两侧肢体"
        );
        if (containsStructure(list, "d", "左侧上肢","e")) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
