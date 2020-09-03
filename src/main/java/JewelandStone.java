public class JewelandStone {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] chars = J.toCharArray();
        char[] chars1 = S.toCharArray();
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<chars1.length;j++){
                if (chars[i]==chars1[j]){
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        JewelandStone jewelandStone = new JewelandStone();
        String J = "aA";
        String S = "aAAbbB";
        int count=jewelandStone.numJewelsInStones(J, S);
    }
}
