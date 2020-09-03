public class Huiwen {
    public boolean isPalindrome(String s) {
        char[] strings = s.toLowerCase().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (char c:strings){
            if (((c>='0'&&c<='9')||(c>='a'&&c<='z'))&&c!=' '){
                stringBuffer.append(c);
            }
        }
        if (stringBuffer.toString().isEmpty()){
            return true;
        }
        else if (new String(stringBuffer).equals(stringBuffer.reverse().toString())) {
            return true;
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        Huiwen huiwen = new Huiwen();
        System.out.println(huiwen.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
