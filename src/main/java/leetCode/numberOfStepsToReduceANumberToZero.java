package leetCode;

/**
 * leetcode 1342
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1 。
 * @Author: mengchao
 * @Date: 2020/2/12 11:21
 */
public class numberOfStepsToReduceANumberToZero {
    public static int numberOfSteps (int num) {
        int steps = 0;
        while (num!=0){
            if (num%2==0){
                num = num / 2;
                steps = steps + 1;
            }else {
                num = num - 1;
                steps = steps + 1;
            }
        }
        return steps;
    }

    public static void main(String[] args) {

    }
}
