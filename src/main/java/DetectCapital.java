public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word==word.toUpperCase()){
            return true;
        }else if(word==word.toLowerCase()){
            return true;
        } else if (word.charAt(0) == word.toUpperCase().charAt(0)&&
                new StringBuilder(word).deleteCharAt(0).toString().equals
                        (new StringBuilder(word.toLowerCase()).deleteCharAt(0).toString())) {
            return true;
        }else {
            return false;
        }
    }
//    public boolean testequals(String word){
//        String s = "Flag";
//        return s == new String("Flag");
//    }

    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        String s = "flag";
        System.out.println(detectCapital.detectCapitalUse(s));
//        System.out.println(detectCapital.testequals(s));

    }
}
