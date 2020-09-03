import java.util.Arrays;

public class ReverseString {
    //我写的原始方法2ms
    public String reverseString(String s) {
        char[] strings = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=strings.length-1;i>=0;i--){
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }

    //这是执行效率最高的1ms
    public String reverseString2(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String ss = "sdsfbjdbfj";
        System.out.println(reverseString.reverseString(ss));
    }

}
