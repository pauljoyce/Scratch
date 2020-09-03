package LeetCode;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode 7
 * @Author: mengchao
 * @Date: 2019-05-22 19:08
 */
public class reverseInteger {
    public static int reverse(int x) {
        if (x==0){
            return 0;
        }else if (x>0){
            if (x%10==0){
                StringBuilder stringBuilder = new StringBuilder(new Integer(x).toString());
                char[] chars= stringBuilder.reverse().toString().toCharArray();
                List list = new ArrayList();
                for (int i = 0; i <chars.length ; i++) {
                    if (chars[i]=='0'){
                        chars[i] = '@';
                    }else {
                        break;
                    }
                }
                String s = new String(chars).replace("@", "");
                Integer integer;
                try{
                    integer = new Integer(s);
                }catch (Exception NumberFormatException){
                    integer = 0;
                }
                return integer;
            }
            else {
                StringBuilder stringBuilder = new StringBuilder(new Integer(x).toString());
                String s = stringBuilder.reverse().toString();
                Integer integer;
                try{
                    integer = new Integer(s);
                }catch (Exception NumberFormatException){
                    integer = 0;
                }
                return integer;
            }
        }else {
            String substring = new Integer(x).toString().substring(1);
            if (x%10==0){
                StringBuilder stringBuilder = new StringBuilder(substring);
                char[] chars= stringBuilder.reverse().toString().toCharArray();
                List list = new ArrayList();
                for (int i = 0; i <chars.length ; i++) {
                    if (chars[i]=='0'){
                        chars[i] = '@';
                    }else {
                        break;
                    }
                }
                String s = new String(chars).replace("@", "");
                Integer integer;
                try{
                    integer = new Integer(s);
                }catch (Exception NumberFormatException){
                    integer = 0;
                }
                return 0-integer;
            }
            else {
                StringBuilder stringBuilder = new StringBuilder(substring);
                String s = stringBuilder.reverse().toString();
                Integer integer;
                try{
                    integer = new Integer(s);
                }catch (Exception NumberFormatException){
                    integer = 0;
                }
                return 0-integer;
            }
        }
    }

    public static void main(String[] args) {
        int a = reverse(-100988888);
        System.out.println(a);
    }
}
