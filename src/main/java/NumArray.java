public class NumArray {
    int[] arraySums;
    public NumArray(int[] nums) {
        arraySums = new int[nums.length+1];//因为下面一行多了一个0占了一位，所以多加一位
        arraySums[0] = 0;
        for (int i=0;i<nums.length;i++){
            arraySums[i+1] = arraySums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return arraySums[j+1] - arraySums[i];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(2, 5));
    }
}
