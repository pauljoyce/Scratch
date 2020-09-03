public class ToLowerCase {
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        String s = "Sdfg";
        ToLowerCase toLowerCase = new ToLowerCase();
        System.out.println(toLowerCase.toLowerCase(s));
    }
}
