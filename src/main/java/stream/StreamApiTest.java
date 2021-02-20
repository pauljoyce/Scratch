package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        Set<String> set = new HashSet<>();
        set.add("ff");
        set.add("fff");
        String s = set.stream().reduce("", (a, b) -> a + b + ",");
        if (s.endsWith(",")){
            s = s.substring(0, s.length() - 1);
        }
        System.out.println(s);
    }
}
