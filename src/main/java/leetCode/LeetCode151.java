package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2020/11/24 14:31
 */
public class LeetCode151 {
    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");
        List<String> result = new ArrayList<>();
        for (int i = strings.length-1; i >=0 ; i--) {
            if (strings[i].equals("")){
                continue;
            }
            result.add(strings[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach(s1 -> stringBuilder.append(s1).append(" "));
        return stringBuilder.toString().trim();
//stream实现
//        return Arrays.stream(s.split(" "))
//                .map(String::trim)
//                .filter(word -> !word.isEmpty())
//                .reduce((word1, word2) -> word2 + " " + word1)
//                .orElse("");
    }

    public static void main(String[] args) {
        String s=reverseWords("  hello world!  ");
        System.out.println(s);
    }
}
