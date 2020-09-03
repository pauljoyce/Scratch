public class dominantIndex {
//    至少是其他数字两倍的最大数
    public int dominantIndex(int[] nums) {
        int max = 0, maxSec = 0, maxIndex = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]>max){
                maxSec = max;
                max = nums[i];
                maxIndex = i;
            }
            else if (nums[i]>maxSec){
                maxSec = nums[i];
            }
        }
        if (max>=2*maxSec){
            return maxIndex;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        dominantIndex dominantIndex = new dominantIndex();
        int[] x = {0, 0, 6, 2,3};
        System.out.println(dominantIndex.dominantIndex(x));
    }
}
