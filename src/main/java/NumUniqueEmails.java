import java.util.HashSet;
import java.util.Set;

public class NumUniqueEmails {
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email:
             emails) {
            String[] afterCliped=email.split("@");

            String temp=afterCliped[0];
            if (temp.contains("+")){
                temp= temp.substring(0,temp.indexOf("+"));
            }
            if (temp.contains(".")){
                temp=temp.replace(".","");
            }
            set.add(temp+"@"+afterCliped[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        numUniqueEmails(emails);
    }
}
