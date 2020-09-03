public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        else if (haystack.indexOf(needle)==-1){
            return -1;
        }else {
            return haystack.indexOf(needle);
        }
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr(new String("Dxxf"),new String("f")));
    }
}
