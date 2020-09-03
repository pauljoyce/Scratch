public class Huiwen2 {
    public boolean validPalindrome(String s) {
        char[] strings = s.toCharArray();
        int i = 0, j = strings.length - 1;
        while(i<j){
            if (strings[i]==strings[j]){
                i++;
                j--;
            }else {
                if (judge(strings,i+1,j)){
                    return true;
                } else if (judge(strings,i,j-1)) {
                    return true;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean judge(char[] chars,int start,int end) {
        while (start < end) {
            if (chars[start] != chars[end])
                return false;
            start++;
            end--;
        }
        return true;

    }
        public static void main(String[] args) {
        Huiwen2 huiwen2 = new Huiwen2();
        System.out.println(huiwen2.validPalindrome(new String("aba")));
    }
}
