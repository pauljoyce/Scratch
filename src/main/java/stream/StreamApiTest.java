package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2020/11/24 16:28
 */
public class StreamApiTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int sum = integerList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        String[] strings = {"hello", "ll", "hh"};
        String str = Arrays.stream(strings).reduce("", (a, b) -> a + b + " ");
        System.out.println(str);
    }
}
