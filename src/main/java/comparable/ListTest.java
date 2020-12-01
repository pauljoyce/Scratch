package comparable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: mengchao
 * @Date: 2020/12/1 14:41
 */
public class ListTest {
    public static void main(String[] args) {
        Object[] a = Arrays.asList(1, 2, 5, 3).toArray();
        int[] a1 = {1, 2, 7, 3};
        //Arrays.sort(a);
        List<Integer> integers=Arrays.asList(1, 2, 5, 3);
        //Comparator
        integers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>o2){
                    return 1;
                }else if (o1.equals(o2)){
                    return 0;
                } else {
                    return -1;
                }

            }
        });
        System.out.println();
    }
}
