public class ReverseWords {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        String[] strs = new String[strings.length];
        for (int i=0;i<strings.length;i++){
            strs[i]=new StringBuilder(strings[i]).reverse().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<strings.length;i++){
            stringBuilder.append(strs[i]);
            if (i!=strs.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = " This is is a new word ";
        System.out.println(reverseWords.reverseWords(s));
    }
}
