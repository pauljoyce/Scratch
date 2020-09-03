package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: mengchao
 * @Date: 2020/2/10 17:55
 */
public class twoSum {
    /**
     * 不做处理直接两个for循环
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int i,j;
        for (i = 0;i<nums.length;i++) {
            for (j=nums.length-1;j>i;j--){
                if (nums[i]+nums[j]==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

//    /**
//     * 使用hash
//     * @param nums
//     * @param target
//     * @return
//     */
//    public static int[] twoSum2(int[] nums, int target) {
//        int[] result = new int[2];
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(16);
//        for (int i=0;i<nums.length;i++
//             ) {
//            hashMap.put(i, nums[i]);
//        }
//        hashMap.
//        return result;
//    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result=twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
