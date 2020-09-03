package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数） 
 * 345 是 3 位数字（位数为奇数）  
 * 2 是 1 位数字（位数为奇数） 
 * 6 是 1 位数字 位数为奇数） 
 * 7896 是 4 位数字（位数为偶数）  
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 *
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: mengchao
 * @Date: 2020/2/12 09:24
 */
public class findNumbersWithEvenNumberOfDigits {
    public static int findNumbers(int[] nums) {
        int number = 0;
        for (int i:nums
             ) {
            if (i==0){
                continue;
            }
            int digits = 0;
            while(i!=0){
                i = i / 10;
                digits = digits + 1;
            }
            if (digits%2==0){
                number = number + 1;
            }
        }
        return number;
    }

    public static int findNumbers2(int[] nums) {
        int number = 0;
        List<String> list = new ArrayList<>();
        for (int i:nums
             ) {
            list.add(String.valueOf(i));
        }
        for (String s:list
             ) {
            if (s.length()%2==0){
                number = number + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        int[] nums = {555,901,482,1771};
        int i = findNumbers2(nums);
        System.out.println(i);
    }


}
