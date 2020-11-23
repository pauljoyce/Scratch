package LeetCode;


import java.util.Stack;

/**
 * 20. 有效的括号
 * @Author: mengchao
 * @Date: 2020/11/23 18:51
 */
public class LeetCode20 {
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        if (s.length()==0){
            return false;
        }
        for (char c:s.toCharArray()
             ) {
            if (stack.size()==0){
                stack.push(c);
            }
            else if (match(c, ((Character) stack.peek()))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        if (stack.size()==0){
            return true;
        }
        return false;
    }

    private static boolean match(char c,char matchChar){
        return c == ')' && matchChar == '(' || c == ']' && matchChar == '[' || c == '}' & matchChar == '{';
    }


    public static void main(String[] args) {
        System.out.println(isValid("[{}[]"));

    }
}
