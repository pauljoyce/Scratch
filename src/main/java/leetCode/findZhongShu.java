package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 寻找众数（出现次数最多的数）
 * @Author: mengchao
 * @Date: 2020/12/6 23:27
 */
public class findZhongShu {
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 7, 3, 5, 4, 2, 5, 4};
        int maxKey = find(nums);
        System.out.println(maxKey);
    }

    private static int find(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int num:nums
             ) {
            if (map.get(num)==null){
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }
        int max = 0;
        int maxKey = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {

            if (max < entry.getValue()) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
