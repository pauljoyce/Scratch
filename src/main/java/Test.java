/**
 * @Author: mengchao
 * @Date: 2020/12/18 10:25
 */
public class Test {
    /**
     * 拼装胃镜病灶大小
     * @param sizeSTDs
     * @return
     */
    public static String getConcatString(String... sizeSTDs){
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:sizeSTDs
        ) {
            if (s==null||"".equals(s)){
                continue;
            }
            stringBuilder.append(s).append(",");
        }
        if (stringBuilder.length()==0){
            return "";
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1)==','){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = getConcatString(null,null);
        System.out.println();
    }
}
