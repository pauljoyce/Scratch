//寻找数组中心索引
public class pivotIndex {
    public int pivotIndex(int[] nums) {
        int sum=0,sumLeft = 0,sumRight = 0;

        for (int n:nums){
            sum = sum + n;
        }

        for (int i=0;i<nums.length;i++){
            if (i==0){
                sumLeft = 0;
            }else {
                sumLeft = sumLeft + nums[i-1];
            }
            sumRight = sum - sumLeft - nums[i];
            if (sumLeft==sumRight){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        pivotIndex pivotIndex = new pivotIndex();
        int[] x = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex.pivotIndex(x));
    }
}
