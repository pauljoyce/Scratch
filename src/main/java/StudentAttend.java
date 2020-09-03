public class StudentAttend {
    public boolean checkRecord(String s) {
        int countA = 0, countL = 0;
        char[] strings = s.toCharArray();
        for (int i=0;i<strings.length;i++){
            switch (strings[i]){
                case 'A':
                    countA++;
                    countL = 0;
                    break;
                case 'P':
                    countL = 0;
                    break;
                case 'L':
                    countL++;
                    break;
            }
            if (countA>=2){
                return false;
            }
            if (countL>=3){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        StudentAttend studentAttend = new StudentAttend();
        String s = "ALLLPPP";
        System.out.println(studentAttend.checkRecord(s));
    }
}
