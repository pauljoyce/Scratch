package Sort;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {5, 4, 6, 2, 8, 3};
        quickSort(a, 0, a.length - 1);
        for (Integer i:a
             ) {
            System.out.println(i);
        }
    }
    public static void quickSort(int[] arr, int left, int right) {
        //数组最左边小于最右边不合法,直接退出
        if (left > right) {
            return;
        }
        //定义变量i指向最左边
        int i = left;
        //定义变量j指向最右边
        int j = right;
        //定义左边为基准元素base
        int base = arr[left];
        //只要i和j没有指向同一个元素,就继续交换
        while (i != j) {
            //从右向左寻找第一个小于基准元素的数
            while (arr[j] >= base && i < j) {
                j--;
            }
            //从左向右寻找第一个大于基准元素的数
            while (arr[i] <= base && i < j) {
                i++;
            }
            //执行到这里证明找到了i和j指向的元素
            //交换i和j指向的元素
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //将i和j共同指向的元素与基准元素交换
        arr[left] = arr[i];
        arr[i] = base;
        //对左边进行快速排序
        quickSort(arr, left, i - 1);
        //对右边进行快速排序
        quickSort(arr, i + 1, right);
    }
}
