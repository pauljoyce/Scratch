import java.util.*;

public class WordGap {
    public int getMinGap(String wordA,String wordB){
        String[] strings = {"This", "is", "a", "test", "text", ",", "for", "test", "only"};
        int min = 10000000;
        int lastPosWord1 = -1;
        int lastPosWordB = -1;
        List<String> list = new ArrayList<String>();
        Map map = new HashMap<String,Integer>();

        for (String string:strings){
            list.add(string);
        }
        if (!list.contains(wordA)||!list.contains(wordB)){
            return -1;
        }

        for (int i = 0; i < strings.length; i++) {
            String currentWord = strings[i];
            if (currentWord.equals(wordA)) {
                lastPosWord1 = i;

                int distance = lastPosWord1 - lastPosWordB;
                if (lastPosWordB >= 0 && distance<min) {
                    min = distance;
                }
            } else if (currentWord.equals(wordB)) {
                lastPosWordB = i;

                int distance = lastPosWordB - lastPosWord1;
                if (lastPosWord1 >= 0 && distance<min) {
                    min = distance;
                }
            }
        }
        return min;


    }
    public static void main(String[] args) {
        WordGap wordGap = new WordGap();
        System.out.println(wordGap.getMinGap("only", "test"));
    }
}
