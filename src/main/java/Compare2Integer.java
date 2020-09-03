import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compare2Integer {
//    public List<Integer> compare(List<Integer>){
//        return
//    }

    public static void main(String[] args) {
        Integer[] a = {1, 0, 2, 4,8,9};
        Integer[] b = {0, 2, 4,8,9};
        List<Integer> listA = Arrays.asList(a);
        List<Integer> listB = Arrays.asList(b);
        List<Integer> result = new ArrayList<Integer>();
        for (Integer integer:listA){
            if (listB.contains(integer)) {
                result.add(integer);
            }
        }
        System.out.println(result);
    }
}
