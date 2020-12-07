package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 4, 9, 2};
        bubbleSort(nums);
        System.out.println();
    }
    public static void bubbleSort(int[] a){
        int len=a.length;
        for(int i=0;i<len;i++){
            //注意第二重循环的条件
            for(int j=0;j<len-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}
